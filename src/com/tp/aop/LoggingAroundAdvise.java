package com.tp.aop;

 
import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;
  
@Component
@Aspect  
public class LoggingAroundAdvise  
{  
	
	private static final Logger logger = Logger.getLogger(LoggingAroundAdvise.class);
	
	@Before("execution(* com.tp.services.*.*(..))")
	public void logBefore(JoinPoint joinPoint) {

		logger.info("logBefore() is running!");
		logger.info("hijacked : " + joinPoint.getSignature().getName());
		logger.debug("******");
	} 
      
    @Around("execution(* com.tp.service.*.*(..))")
    public Object logTimeMethod(ProceedingJoinPoint joinPoint) throws Throwable {
		StopWatch stopWatch = new StopWatch();
		stopWatch.start();
		Object retVal = joinPoint.proceed();
		stopWatch.stop();
		StringBuffer logMsg = new StringBuffer();
		logMsg.append(joinPoint.getTarget().getClass().getName());
		logMsg.append(".");
		logMsg.append(joinPoint.getSignature().getName());
		logMsg.append("(");
		Object[] args = joinPoint.getArgs();
		for (int i = 0; i < args.length; i++) {
			logMsg.append(args[i]).append(",");
		}
		if (args.length > 0) {
			logMsg.deleteCharAt(logMsg.length() - 1);
		}
		logMsg.append(")");
		logMsg.append(" execution time: ");
		logMsg.append(stopWatch.getTotalTimeMillis());
		logMsg.append(" ms");
		logger.info(logMsg.toString());
		System.out.println("The exiting method;;;"+logMsg.toString());
		return retVal;
	}
    /*public Object myadvice(ProceedingJoinPoint pjp) throws Throwable   
    {  
    	long startTime = System.currentTimeMillis();
		logger.info("Request URL::"    
				+ ":: Start Time=" + System.currentTimeMillis());
    	
        System.out.println("Additional Concern Before calling actual method");  
        Object[] methodArgs = pjp.getArgs();
        if(null != methodArgs && methodArgs.length>0)
        {
        	for (int i = 0; i < methodArgs.length; i++) {
        		logger.info("the method Arg "+methodArgs[i] +" At index"+ i);
			}
        }
        
        Object obj=pjp.proceed();  
        long endTime = System.currentTimeMillis();
        logger.info("the execution time:"+(endTime-startTime));
        logger.info("reutrned Object:"+obj);
          System.out.println("The end....");
        return obj;  
    }  */
} 
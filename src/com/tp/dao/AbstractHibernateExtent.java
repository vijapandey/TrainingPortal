package com.tp.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public abstract class AbstractHibernateExtent extends HibernateDaoSupport {
	
	protected static final String _PROPERTY_NAME = "name";
	protected static final String _PROPERTY_DESCRIPTION = "description";
	protected static final String _PROPERTY_ACTIVE = "active";

	protected static final String CACHE_REGION_QUERY = "query.typesAndStaticDomainObjects";
	
	public Criteria createCriteria (final Class thisClass) {
		Criteria c = (Criteria) getHibernateTemplate().execute(new HibernateCallback() {
			public Object doInHibernate(Session session) {
				return session.createCriteria(thisClass);
			}
		});
		return c;
	}

}
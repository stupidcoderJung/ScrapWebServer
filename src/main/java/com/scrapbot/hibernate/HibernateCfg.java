package com.scrapbot.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateCfg {
	private SessionFactory factory;

	public SessionFactory getFactory() {
		return factory;
	}

	public static SessionFactory getFactoryInstance() {
		return LazyHolder.INSTANCE;
	}

	private static class LazyHolder {
		private static final SessionFactory INSTANCE = new HibernateCfg().getFactory();
	}
	public HibernateCfg() {
		Configuration con = new Configuration();
		con.configure("hibernate.cfg.xml");
		factory = con.buildSessionFactory();
	}
}

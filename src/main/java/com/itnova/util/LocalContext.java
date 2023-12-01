package com.itnova.util;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.naming.spi.InitialContextFactory;
import javax.naming.spi.InitialContextFactoryBuilder;

public class LocalContext extends InitialContext implements
		InitialContextFactoryBuilder, InitialContextFactory {

	Map<Object, Object> dataSources;

	LocalContext() throws NamingException {
		super();
		dataSources = new HashMap<Object, Object>();
	}

	@Override
	public Context getInitialContext(Hashtable<?, ?> environment)
			throws NamingException {
		return this;
	}

	@Override
	public InitialContextFactory createInitialContextFactory(Hashtable<?, ?> environment) throws NamingException {
		dataSources.putAll(environment);
		return this;
	}

	public void addDataSource(String name, String connectionString, String username, String password) {
		this.dataSources.put(name, new LocalDataSource(connectionString, username, password));
	}

	@Override
	public Object lookup(String name) throws NamingException {
		Object ret = dataSources.get(name);
		return (ret != null) ? ret : super.lookup(name);
	}
}

package com.gmail.stefan.backend.dbservices;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Currency;
import java.util.HashMap;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.apache.commons.beanutils.converters.BooleanConverter;

import com.vaadin.flow.data.converter.Converter;
//import org.sql2o.Sql2o;
//import org.sql2o.converters.BooleanConverter;
//import org.sql2o.converters.Converter;
//import org.sql2o.quirks.NoQuirks;


public class DBServices {
	
	
	private static volatile DataSource datasource;
//	private static RedissonClient redissonClient;
	protected Sql2o sql2o = null;


	@SuppressWarnings("rawtypes")
	public DBServices() {


		try {
			if(datasource == null)
				datasource = getDataSource();
			sql2o = new Sql2o(datasource, new NoQuirks(new HashMap<Class, Converter>(){
				
				private static final long serialVersionUID = -4592235949068842470L;

				{
					put(LocalDate.class, (Converter<?>) new LocalDateConverter());
					put(LocalDateTime.class, (Converter<?>) new LocalDateTimeConverter());
					put(Boolean.class, (Converter<?>) new BooleanConverter());
				}
				
				}));
		} catch (Exception e) {
			e.printStackTrace();
		}


	}

	private static DataSource getDataSource() {
		try {
			InitialContext initCtx;
			int counterTries = 0;
			while(counterTries<100) {
				try {
					Thread.yield();
					
					initCtx = new InitialContext();

					//Tomcat
					datasource = (DataSource) initCtx.lookup("java:/comp/env/jdbc/todo" );
					
					counterTries = 100;
					
					
				}
				catch (NamingException ne) {
					counterTries++;
					System.err.println("datasource lookup: " + ne.getMessage());
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return datasource  ;
	}
}
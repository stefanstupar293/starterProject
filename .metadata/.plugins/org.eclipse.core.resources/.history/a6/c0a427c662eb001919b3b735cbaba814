package com.gmail.stefan.backend.dbservices;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import org.sql2o.converters.Converter;
import org.sql2o.converters.ConverterException;

public class LocalDateTimeConverter implements Converter<LocalDateTime> {
    @Override
    public LocalDateTime convert(Object val) throws ConverterException {
        if (val == null) {
            return null;
        }
        try {
        	
        	return ((Date)val).toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
        	
        } catch (IllegalArgumentException ex) {
            throw new ConverterException("Don't know how to convert from type '" + val.getClass().getName() 
            		+ "' to type '" + LocalDateTime.class.getName() + "'", ex);
        }
    }

    @Override
    public Object toDatabaseParam(LocalDateTime val) {
        return new java.sql.Timestamp(val.atZone(ZoneId.systemDefault()).toInstant()
                .toEpochMilli());
    }
}
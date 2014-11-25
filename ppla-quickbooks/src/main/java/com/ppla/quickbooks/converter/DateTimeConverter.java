package com.ppla.quickbooks.converter;

import org.dozer.CustomConverter;
import org.dozer.MappingException;
import org.joda.time.DateTime;

/**
 * Custom converter for Joda DateTime's.
 * @author Scott McMaster
 * http://www.scotmcmaster365.com/
 *
 */
public class DateTimeConverter implements CustomConverter {

    @Override
    public Object convert(Object existingDestinationFieldValue,
            Object sourceFieldValue, Class<?> destinationClass,
            Class<?> sourceClass) {
        
        if (null == sourceFieldValue) {
            return null;
        }

        if (sourceFieldValue instanceof String) {
            return DateTime.parse((String) sourceFieldValue);
        } else if (sourceFieldValue instanceof DateTime) {
            return ((DateTime)sourceFieldValue).toString();
        }
        throw new MappingException("Misconfigured/unsupported mapping");
    }

//    @SuppressWarnings("unchecked")
//    @Override
//    public Object convert(Object existingDestinationFieldValue,
//            Object sourceFieldValue, Class destinationClass, Class sourceClass)
//    {
//        if( sourceFieldValue == null )
//        {
//            return null;
//        }
//
//        if( sourceFieldValue instanceof Calendar )
//        {
//            // Note that DateTime is immutable, so
//            // we can't do much with the existingDestinationFieldValue.
//            return new DateTime(sourceFieldValue);
//        }
//        else if( sourceFieldValue instanceof DateTime )
//        {
//            Calendar result;
//            if( existingDestinationFieldValue == null )
//            {
//                result = Calendar.getInstance();
//            }
//            else
//            {
//                result = (Calendar) existingDestinationFieldValue;
//            }
//            result.setTimeInMillis(((DateTime) sourceFieldValue).getMillis());
//            return result;
//        }
//        throw new MappingException("Misconfigured/unsupported mapping");
//    }

}
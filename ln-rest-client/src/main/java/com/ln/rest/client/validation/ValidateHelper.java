package com.ln.rest.client.validation;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

/**
 * Created by richardwu on 4/24/2017.
 */
public class ValidateHelper {

    private static final Logger logger = LoggerFactory.getLogger(ValidateHelper.class);


    public static String truncateValue(Class clazz, String fieldName, String value) {
        if (StringUtils.isEmpty(value) || StringUtils.isEmpty(fieldName)) {
            return null;
        }
        try {
            int size = clazz.getDeclaredField(fieldName).getAnnotation(Size.class).max();
            int inLength = value.length();
            if (inLength > size) {
                logger.warn("The length of " + fieldName + " (" + value + ") exceeds " + size + ". It is truncated to " + size + " characters.");
                value = value.substring(0, size);
            }
        } catch (NoSuchFieldException ex) {

            logger.error("The filed name " + fieldName + " is not a valid in Staff object. Error message is: " + ex.getMessage(), ex);

        } catch (SecurityException ex) {

            logger.error("The filed name " + fieldName + " is not accessible in Staff object. Error message is: " + ex.getMessage(), ex);

        }
        return value;
    }


    public static BigDecimal convertBigDecimalInRange(Class clazz, String fieldName, BigDecimal value, BigDecimal defaultValue) {

        if (value == null || StringUtils.isEmpty(fieldName)) {
            value = defaultValue;
        } else {
            BigDecimal max = null;
            BigDecimal min = null;
            try {
                max = new BigDecimal(clazz.getDeclaredField(fieldName).getAnnotation(DecimalMax.class).value());
                min = new BigDecimal(clazz.getDeclaredField(fieldName).getAnnotation(DecimalMin.class).value());
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            }

            if (value.compareTo(max) > 0 || value.compareTo(min) < 0) {
                logger.warn("The value of " + fieldName + " (" + value + ") is not in the range [" + min + "," + max + "]. It is replaced by default value: " + defaultValue + ".");
                value = defaultValue;
            }
        }
        return value;
    }

    public static String replaceDefaultValue(Class clazz, String fieldName, String value, String defaultValue) {

        if (StringUtils.isEmpty(value) || StringUtils.isEmpty(fieldName)) {
            return defaultValue;
        }

        try {

            String regexp = clazz.getDeclaredField(fieldName).getAnnotation(Pattern.class).regexp();

            if (value.matches(regexp)) {
                return value;
            } else {
                logger.warn("The format of " + fieldName + " value (" + value + ") does not match with regexp "+ regexp + ". It is replaced by default value: " + defaultValue + ".");
                return defaultValue;
            }

        } catch (NoSuchFieldException ex) {

            logger.error("The filed name " + fieldName + " is not a valid in Staff object. Error message is: " + ex.getMessage(), ex);

        } catch (SecurityException ex) {

            logger.error("The filed name " + fieldName + " is not accessible in Staff object. Error message is: " + ex.getMessage(), ex);

        }
        return value;
    }
}

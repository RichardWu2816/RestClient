package com.ln.rest.client.constants;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.lang.reflect.Modifier;

/**
 * Created by dell on 7/8/2017.
 */
public class AppConstants {

    public static final String STAFF_POST_DATA_ENDPOINT = "https://uat-api.sandata.com/interfaces/intake/staff/v1";
    public static final String PATIENT_POST_DATA_ENDPOINT = "https://uat-api.sandata.com/interfaces/intake/patient/v1";
    public static final String VISIT_POST_DATA_ENDPOINT = "https://uat-api.sandata.com/interfaces/intake/visit/v1";

    public static final String STAFF_GET_STATUS_ENDPOINT = "https://uat-api.sandata.com/interfaces/intake/staff/v1/status?uuid=";
    public static final String PATIENT_GET_STATUS_ENDPOINT = "https://uat-api.sandata.com/interfaces/intake/patient/v1/status?uuid=";
    public static final String VISIT_GET_STATUS_ENDPOINT = "https://uat-api.sandata.com/interfaces/intake/visit/v1/status?uuid=";

    public static final String USER_NAME = "Qq3x9qFtJppFMmaPqYqnfQ==";
    public static final String PASSWORD = "2WnNfb83Z0x5DOdc2Lb0uA==";

    public static final String SANDATA_UTC_DATE_TIME_FORMAT = "yyyy-MM-dd'T'HH:mm:ssX";

    public static final Gson GSON = new GsonBuilder().setDateFormat(SANDATA_UTC_DATE_TIME_FORMAT).excludeFieldsWithModifiers(Modifier.TRANSIENT).create();

    public static final String LN_REQUEST_ID = "LN_REQUEST_ID";
    public static final String UTC_DATE_TIME_FORMAT = "yyyy-MM-dd'T'HH:mm:ssX";
    public static final String PIPE = "|";
    public static final String ERROR_FLAG = "ERROR: ";
    public static final String WARNING_FLAG = "WARNING: ";
    public static final int SIZE_MAX_NOT_DEFINED_VALUE = -1;
    public static final String INVALID_PARAM_CODE = "-50";

    public static final String INVALID_PARAM_WARNING_CODE = "-782";


}

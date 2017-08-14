package com.ln.rest.client.services;


import com.ln.rest.client.constants.AppConstants;
import com.ln.rest.client.model.Patient;
import com.ln.rest.client.model.Response;
import com.ln.rest.client.model.Staff;
import com.ln.rest.client.model.Visit;
import com.ln.rest.client.utils.Encryptor;
import com.ln.rest.client.utils.RestClient;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;


@Service
@Component
@Transactional
public class EntityServiceImpl implements EntityService {

    private static final Logger logger = LoggerFactory.getLogger(EntityServiceImpl.class);

    RestClient restClient = new RestClient();
    private String username = Encryptor.decrypt(AppConstants.USER_NAME);
    private String password = Encryptor.decrypt(AppConstants.PASSWORD);


    @Override
    public Response invokePostDataStaff(List<Staff> staffList) {

        String uuid = MDC.get(AppConstants.LN_REQUEST_ID);
        if(StringUtils.isBlank(uuid)) {
            uuid = UUID.randomUUID().toString();
        }

        Response response = restClient.invokeRestPostService(AppConstants.STAFF_POST_DATA_ENDPOINT, username,
                password, staffList);


        response.setId(uuid);

        return response;
    }

    @Override
    public Response invokePostDataPatient(List<Patient> patientList) {

        String uuid = MDC.get(AppConstants.LN_REQUEST_ID);
        if(StringUtils.isBlank(uuid)) {
            uuid = UUID.randomUUID().toString();
        }

        Response response = restClient.invokeRestPostService(AppConstants.PATIENT_POST_DATA_ENDPOINT, username,
                password, patientList);

        response.setId(uuid);

        return response;
    }

    @Override
    public Response invokePostDataVisit(List<Visit> visitList) {

        String uuid = MDC.get(AppConstants.LN_REQUEST_ID);
        if(StringUtils.isBlank(uuid)) {
            uuid = UUID.randomUUID().toString();
        }

        Response response = restClient.invokeRestPostService(AppConstants.VISIT_POST_DATA_ENDPOINT, username,
                password, visitList);

        response.setId(uuid);

        return response;
    }

    @Override
    public Response invokeGetStatusStaff(String uuid) {

        String url = AppConstants.STAFF_GET_STATUS_ENDPOINT + uuid;

        Response response = restClient.invokeRestGetService(url, username,
                password);

        response.setId(uuid);

        return response;

    }

    @Override
    public Response invokeGetStatusPatient(String uuid) {

        String url = AppConstants.PATIENT_GET_STATUS_ENDPOINT + uuid;

        Response response = restClient.invokeRestGetService(url, username,
                password);

        response.setId(uuid);

        return response;

    }

    @Override
    public Response invokeGetStatusVisit(String uuid) {

        String url = AppConstants.VISIT_GET_STATUS_ENDPOINT + uuid;

        Response response = restClient.invokeRestGetService(url, username,
                password);

        response.setId(uuid);

        return response;

    }

}

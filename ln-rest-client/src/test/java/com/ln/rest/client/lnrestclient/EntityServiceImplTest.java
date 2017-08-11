package com.ln.rest.client.lnrestclient;

import com.google.gson.reflect.TypeToken;
import com.ln.rest.client.constants.AppConstants;
import com.ln.rest.client.model.Patient;
import com.ln.rest.client.model.Response;
import com.ln.rest.client.model.Staff;
import com.ln.rest.client.model.Visit;
import com.ln.rest.client.services.EntityServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.FileReader;
import java.util.List;

/**
 * Created by richardwu on 8/11/2017.
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class EntityServiceImplTest {

    private static final Logger logger = LoggerFactory.getLogger(EntityServiceImplTest.class);

    @Autowired
    private EntityServiceImpl entityServiceImpl;


    @Test
    public void invokePostDataStaffTest() throws Exception {

        List<Staff> inputStaffList = AppConstants.GSON.fromJson(new FileReader("src/test/data/staff.json"),
                new TypeToken<List<Staff>>() {}.getType());
        Response response = entityServiceImpl.invokePostDataStaff(inputStaffList);

        logger.info(response.toString());

    }

    @Test
    public void invokePostDataPatientTest() throws Exception{
        List<Patient> inputPatientList = AppConstants.GSON.fromJson(new FileReader("src/test/data/patient.json"),
                new TypeToken<List<Patient>>() {}.getType());
        Response response = entityServiceImpl.invokePostDataPatient(inputPatientList);

        logger.info(response.toString());
    }
    @Test
    public void invokePostDataVisitTest() throws Exception{
        List<Visit> inputVisitList = AppConstants.GSON.fromJson(new FileReader("src/test/data/visit.json"),
                new TypeToken<List<Visit>>() {}.getType());
        Response response = entityServiceImpl.invokePostDataVisit(inputVisitList);

        logger.info(response.toString());
    }

    @Test
    public void invokeGetStatusStaffTest(){
        String uuid = "131c41de-1632-4012-86f8-a44fc47fd877";
        Response response = entityServiceImpl.invokeGetStatusStaff(uuid);
        logger.info(response.toString());
    }
    @Test
    public void invokeGetStatusPatientTest(){
        String uuid = "7453a5a7-734c-45ad-849b-b319eb7c90ee";
        Response response = entityServiceImpl.invokeGetStatusPatient(uuid);
        logger.info(response.toString());
    }
    @Test
    public void invokeGetStatusVisitTest() {
        String uuid = "70e508d0-7511-43ba-b68c-f6ae93ab871a";
        Response response = entityServiceImpl.invokeGetStatusVisit(uuid);
        logger.info(response.toString());
    }
}

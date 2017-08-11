package com.ln.rest.client.services;


import com.ln.rest.client.model.Patient;
import com.ln.rest.client.model.Response;
import com.ln.rest.client.model.Staff;
import com.ln.rest.client.model.Visit;

import java.util.List;

public interface EntityService {
    Response invokePostDataStaff(List<Staff> staffList);
    Response invokePostDataPatient(List<Patient> patientList);
    Response invokePostDataVisit(List<Visit> visitList);

    Response invokeGetStatusStaff(String uuid);
    Response invokeGetStatusPatient(String uuid);
    Response invokeGetStatusVisit(String uuid);
}

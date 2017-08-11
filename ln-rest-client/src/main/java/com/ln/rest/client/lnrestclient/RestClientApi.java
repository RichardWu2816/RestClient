package com.ln.rest.client.lnrestclient;

import com.ln.rest.client.model.*;
import com.ln.rest.client.services.EntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

/**
 * Created by richardwu on 8/11/2017.
 */

@RestController
@RefreshScope
@RequestMapping("/v1")
public class RestClientApi {


    @Autowired
    private final EntityService entityService;

    @Autowired
    public RestClientApi(EntityService entityService) {
        this.entityService = entityService;
    }


    @PostMapping(value = "/invokePostDataStaff", produces = {MediaType.APPLICATION_JSON_VALUE}, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> invokePostDataStaff(@RequestBody(required = false) List<Staff> staffList) {

        Response response = entityService.invokePostDataStaff(staffList);

        if (response != null) {
            return ResponseEntity.ok(response);
        }

        response = new Response();
        response.setId(UUID.randomUUID().toString());
        response.setStatus(ServiceStatus.SUCCESS);
        response.setData(String.format("Thanks: [param_value=%s]", staffList));
        return ResponseEntity.ok(response);
    }

    @PostMapping(value = "/invokePostDataPatient", produces = {MediaType.APPLICATION_JSON_VALUE}, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> invokePostDataPatient(@RequestBody(required = false) List<Patient> patientList) {

        Response response = entityService.invokePostDataPatient(patientList);

        if (response != null) {
            return ResponseEntity.ok(response);
        }

        response = new Response();
        response.setId(UUID.randomUUID().toString());
        response.setStatus(ServiceStatus.SUCCESS);
        response.setData(String.format("Thanks: [param_value=%s]", patientList));
        return ResponseEntity.ok(response);
    }

    @PostMapping(value = "/invokePostDataVisit", produces = {MediaType.APPLICATION_JSON_VALUE}, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> invokePostDataVisit(@RequestBody(required = false) List<Visit> visitList) {

        Response response = entityService.invokePostDataVisit(visitList);

        if (response != null) {
            return ResponseEntity.ok(response);
        }

        response = new Response();
        response.setId(UUID.randomUUID().toString());
        response.setStatus(ServiceStatus.SUCCESS);
        response.setData(String.format("Thanks: [param_value=%s]", visitList));
        return ResponseEntity.ok(response);
    }

    @RequestMapping(value = "/invokeGetStatusStaff", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE}, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public Response invokeGetStatusStaff(@RequestParam(name = "uuid") String uuid) {

        return  entityService.invokeGetStatusStaff(uuid);

    }


    @RequestMapping(value = "/invokeGetStatusPatient", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE}, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public Response invokeGetStatusPatient(@RequestParam(name = "uuid") String uuid) {

        return  entityService.invokeGetStatusPatient(uuid);

    }


    @RequestMapping(value = "/invokeGetStatusVisit", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE}, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public Response invokeGetStatusVisit(@RequestParam(name = "uuid") String uuid) {

        return  entityService.invokeGetStatusVisit(uuid);

    }
}

package com.ln.rest.client.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.ln.rest.client.validation.DataChecks;
import com.ln.rest.client.validation.ValidateHelper;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


public class ResponsibleParty extends SandataMessage {

    public ResponsibleParty() {}

    public ResponsibleParty(
            String patientResponsiblePartyLastName,
            String patientResponsiblePartyFirstName
    ) {

        setPatientResponsiblePartyLastName(patientResponsiblePartyLastName);
        setPatientResponsiblePartyFirstName(patientResponsiblePartyFirstName);
    }


    @NotNull(message = "{patient.responsibleParty.PatientResponsiblePartyLastName.null.msg}", groups = DataChecks.class)
    @Size(min=1, max=30, message = "{patient.responsibleParty.PatientResponsiblePartyLastName.size.msg}", groups = DataChecks.class)
    @Pattern(regexp = "[A-Za-z'.\\-]{1,30}", message = "{patient.responsibleParty.PatientResponsiblePartyLastName.pattern.msg}", groups = DataChecks.class)
    @SerializedName("PatientResponsiblePartyLastName")
    @Expose
    private String patientResponsiblePartyLastName;

    @NotNull(message = "{patient.responsibleParty.PatientResponsiblePartyFirstName.null.msg}", groups = DataChecks.class)
    @Size(min=1, max=30, message = "{patient.responsibleParty.PatientResponsiblePartyFirstName.size.msg}", groups = DataChecks.class)
    @Pattern(regexp = "[A-Za-z'.\\-]{1,30}", message = "{patient.responsibleParty.PatientResponsiblePartyFirstName.pattern.msg}", groups = DataChecks.class)
    @SerializedName("PatientResponsiblePartyFirstName")
    @Expose
    private String patientResponsiblePartyFirstName;

    public String getPatientResponsiblePartyLastName() {
        return patientResponsiblePartyLastName;
    }

    public void setPatientResponsiblePartyLastName(String patientResponsiblePartyLastName) {
        this.patientResponsiblePartyLastName = ValidateHelper.truncateValue(getClass(), "patientResponsiblePartyLastName", patientResponsiblePartyLastName);
    }

    public String getPatientResponsiblePartyFirstName() {
        return patientResponsiblePartyFirstName;
    }

    public void setPatientResponsiblePartyFirstName(String patientResponsiblePartyFirstName) {
        this.patientResponsiblePartyFirstName = ValidateHelper.truncateValue(getClass(), "patientResponsiblePartyFirstName", patientResponsiblePartyFirstName);
    }

    public String toString() {
        String data =
                "Patient.ResponsibleParty["
                        + "patientResponsiblePartyLastName=" + patientResponsiblePartyLastName
                        + ",patientResponsiblePartyFirstName=" + patientResponsiblePartyFirstName
                        + "]";

        return data;
    }

}

package com.ln.rest.client.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.ln.rest.client.validation.DataChecks;
import com.ln.rest.client.validation.ValidateHelper;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * Created by richardwu on 3/6/2017.
 */
public class Phone extends SandataMessage {

    public Phone() {}

    public Phone(
            String patientPhoneType,
            String patientPhoneNumber
    ) {

        setPatientPhoneType(patientPhoneType);
        setPatientPhoneNumber(patientPhoneNumber);
    }


    @NotNull(message = "{patient.phone.PatientPhoneType.null.msg}", groups = DataChecks.class)
    @Size(min = 1, max = 32, message = "{patient.phone.PatientPhoneType.size.msg}", groups = DataChecks.class)
    @Pattern(regexp = "Fax|Home|Mobile|Work|Other|FAX|HOME|MOBILE|WORK|OTHER|fax|home|mobile|work|other", message = "{patient.phone.PatientPhoneType.pattern.msg}", groups = DataChecks.class)
    @SerializedName("PatientPhoneType")
    @Expose
    private String patientPhoneType;

    @NotNull(message = "{patient.phone.PatientPhoneNumber.null.msg}", groups = DataChecks.class)
    @Size(min = 10, max = 10, message = "{patient.phone.PatientPhoneNumber.size.msg}", groups = DataChecks.class)
    @Pattern(regexp = "^\\d{10}$", message = "{patient.phone.PatientPhoneNumber.pattern.msg}", groups = DataChecks.class)
    @SerializedName("PatientPhoneNumber")
    @Expose
    private String patientPhoneNumber;

    public String getPatientPhoneType() {
        return patientPhoneType;
    }

    public void setPatientPhoneType(String patientPhoneType) {
        this.patientPhoneType = ValidateHelper.replaceDefaultValue(getClass(), "patientPhoneType", patientPhoneType, "Other");
    }

    public String getPatientPhoneNumber() {
        return patientPhoneNumber;
    }

    public void setPatientPhoneNumber(String patientPhoneNumber) {
        this.patientPhoneNumber = ValidateHelper.truncateValue(getClass(), "patientPhoneNumber", patientPhoneNumber);
    }

    public String toString() {
        String data =
                "Patient.Phone["
                        + "patientPhoneType=" + patientPhoneType
                        + ",patientPhoneNumber=" + patientPhoneNumber
                        + "]";

        return data;
    }
}


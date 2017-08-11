package com.ln.rest.client.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.ln.rest.client.validation.DataChecks;
import com.ln.rest.client.validation.ValidateHelper;

import javax.validation.constraints.*;
import java.math.BigDecimal;

/**
 * Created by richardwu on 3/6/2017.
 */
public class Address  extends SandataMessage {

    public Address() {}

    public Address(
            String patientAddressType,
            Boolean patientAddressIsPrimary,
            String patientAddressLine1,
            String patientAddressLine2,
            String patientCity,
            String patientZip,
            String patientState,
            BigDecimal patientLongitude,
            BigDecimal patientLatitude,
            String patientTimezone

    ) {
        setPatientAddressType(patientAddressType);
        setPatientAddressIsPrimary(patientAddressIsPrimary);
        setPatientAddressLine1(patientAddressLine1);
        setPatientAddressLine2(patientAddressLine2);
        setPatientCity(patientCity);
        setPatientZip(patientZip);
        setPatientState(patientState);
        setPatientLongitude(patientLongitude);
        setPatientLatitude(patientLatitude);
        setPatientTimezone(patientTimezone);
    }


    @NotNull(message = "{patient.address.PatientAddressType.null.msg}", groups = DataChecks.class)
    @Size(min = 4, max = 25, message = "{patient.address.PatientAddressType.size.msg}", groups = DataChecks.class)
    @Pattern(regexp = "Business|Home|School|Other|BUSINESS|HOME|SCHOOL|OTHER|business|home|school|other", message = "{patient.address.PatientAddressType.pattern.msg}", groups = DataChecks.class)
    @SerializedName("PatientAddressType")
    @Expose
    private String patientAddressType;

    @NotNull(message = "{patient.address.PatientAddressIsPrimary.null.msg}", groups = DataChecks.class)
    @SerializedName("PatientAddressIsPrimary")
    @Expose
    private Boolean patientAddressIsPrimary;

    @NotNull(message = "{patient.address.PatientAddressLine1.null.msg}", groups = DataChecks.class)
    @Size(min=1, max=30, message = "{patient.address.PatientAddressLine1.size.msg}", groups = DataChecks.class)
    @Pattern(regexp = "[\\w .'-]{1,30}", message = "{patient.address.PatientAddressLine1.pattern.msg}", groups = DataChecks.class)
    @SerializedName("PatientAddressLine1")
    @Expose
    private String patientAddressLine1;

    @Size(min=1, max=30, message = "{patient.address.PatientAddressLine2.size.msg}", groups = DataChecks.class)
    @Pattern(regexp = "[\\w .'-]{1,30}", message = "{patient.address.PatientAddressLine2.pattern.msg}", groups = DataChecks.class)
    @SerializedName("PatientAddressLine2")
    @Expose
    private String patientAddressLine2;

    @NotNull(message = "{patient.address.PatientCity.null.msg}", groups = DataChecks.class)
    @Size(min=1, max=30, message = "{patient.address.PatientCity.size.msg}", groups = DataChecks.class)
    @Pattern(regexp = "[\\w .'-]{1,30}", message = "{patient.address.PatientCity.pattern.msg}", groups = DataChecks.class)
    @SerializedName("PatientCity")
    @Expose
    private String patientCity;

    @NotNull(message = "{patient.address.PatientState.null.msg}", groups = DataChecks.class)
    @Pattern(regexp = "AL|AK|AZ|AR|CA|CO|CT|DE|FL|GA|HI|ID|IL|IN|IA|KS|KY|LA|ME|MD|MA|MI|MN|MS|MO|MT|NE|NV|NH|NJ|NM|NY|NC|ND|OH|OK|OR|PA|RI|SC|SD|TN|TX|UT|VT|VA|WA|WV|WI|WY", message = "{patient.address.PatientState.invalid.msg}", groups = DataChecks.class)
    @SerializedName("PatientState")
    @Expose
    private String patientState;

    @NotNull(message = "{patient.address.PatientZip.null.msg}", groups = DataChecks.class)
    @Size(min=5, max=10, message = "{patient.address.PatientZip.size.msg}", groups = DataChecks.class)
    @Pattern(regexp = "^\\d{5}(?:[-\\s]\\d{4})?$", message = "{patient.address.PatientZip.pattern.msg}", groups = DataChecks.class)
    @SerializedName("PatientZip")
    @Expose
    private String patientZip;

    //@NotNull(message = "{patient.address.PatientLongitude.null.msg}", groups = DataChecks.class)
    @DecimalMax(value = "180", message = "{patient.address.PatientLongitude.DecimalMax.msg}", groups = DataChecks.class)
    @DecimalMin(value = "-180", message = "{patient.address.PatientLongitude.DecimalMin.msg}", groups = DataChecks.class)
    @SerializedName("PatientLongitude")
    @Expose
    private BigDecimal patientLongitude;

    //@NotNull(message = "{patient.address.PatientLatitude.null.msg}", groups = DataChecks.class)
    @DecimalMax(value="90", message = "{patient.address.PatientLatitude.DecimalMax.msg}", groups = DataChecks.class)
    @DecimalMin(value="-90", message = "{patient.address.PatientLatitude.DecimalMin.msg}", groups = DataChecks.class)
    @SerializedName("PatientLatitude")
    @Expose
    private BigDecimal patientLatitude;

    @Size(min=1, max=64, message = "{patient.address.PatientTimezone.size.msg}", groups = DataChecks.class)
    @Pattern(regexp = "[\\w /\\-]{1,64}", message = "{patient.address.PatientTimezone.pattern.msg}", groups = DataChecks.class)
    @SerializedName("PatientTimezone")
    @Expose
    private String patientTimezone;

    public String getPatientAddressType() {
        return patientAddressType;
    }

    public void setPatientAddressType(String patientAddressType) {
        this.patientAddressType = ValidateHelper.replaceDefaultValue(getClass(), "patientAddressType", patientAddressType, "Home");
    }

    public Boolean getPatientAddressIsPrimary() {
        return patientAddressIsPrimary;
    }

    public void setPatientAddressIsPrimary(Boolean patientAddressIsPrimary) {
        this.patientAddressIsPrimary = patientAddressIsPrimary;
    }

    public String getPatientAddressLine1() {
        return patientAddressLine1;
    }

    public void setPatientAddressLine1(String patientAddressLine1) {
        this.patientAddressLine1 = ValidateHelper.truncateValue(getClass(), "patientAddressLine1", patientAddressLine1);
    }

    public String getPatientAddressLine2() {
        return patientAddressLine2;
    }

    public void setPatientAddressLine2(String patientAddressLine2) {
        this.patientAddressLine2 = ValidateHelper.truncateValue(getClass(), "patientAddressLine2", patientAddressLine2);
    }

    public String getPatientCity() {
        return patientCity;
    }

    public void setPatientCity(String patientCity) {
        this.patientCity = ValidateHelper.truncateValue(getClass(), "patientCity", patientCity);
    }

    public String getPatientState() {
        return patientState;
    }

    public void setPatientState(String patientState) {
        this.patientState = patientState;
    }

    public String getPatientZip() {
        return patientZip;
    }

    public void setPatientZip(String patientZip) {
        this.patientZip = ValidateHelper.truncateValue(getClass(), "patientZip", patientZip);
    }

    public BigDecimal getPatientLongitude() {
        return patientLongitude;
    }

    public void setPatientLongitude(BigDecimal patientLongitude) {

        this.patientLongitude = ValidateHelper.convertBigDecimalInRange(getClass(), "patientLongitude", patientLongitude, new BigDecimal(0.0));
    }

    public BigDecimal getPatientLatitude() {
        return patientLatitude;
    }

    public void setPatientLatitude(BigDecimal patientLatitude) {

        this.patientLatitude = ValidateHelper.convertBigDecimalInRange(getClass(), "patientLatitude", patientLatitude, new BigDecimal(0.0));
    }

    public String getPatientTimezone() {
        return patientTimezone;
    }

    public void setPatientTimezone(String patientTimezone) {
        this.patientTimezone = ValidateHelper.truncateValue(getClass(), "patientTimezone", patientTimezone);
    }

    public String toString() {
        String data =
                "Patient.Address["
                        + "patientAddressType=" + patientAddressType
                        + ",patientAddressIsPrimary=" + patientAddressIsPrimary
                        + ",patientAddressLine1=" + patientAddressLine1
                        + ",patientAddressLine2=" + patientAddressLine2
                        + ",patientCity=" + patientCity
                        + ",patientZip=" + patientZip
                        + ",patientLongitude=" + patientLongitude
                        + ",patientLatitude" + patientLatitude
                        + ",patientTimezone=" + patientTimezone
                        + "]";

        return data;

    }
}

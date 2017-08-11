package com.ln.rest.client.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.ln.rest.client.validation.DataChecks;
import com.ln.rest.client.validation.ValidateHelper;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.Objects;

public class Patient extends SandataMessage {

    public Patient() {}

    public Patient(
            String businessEntityID,
            String businessEntityMedicaidIdentifier,
            String patientOtherID,
            String sequenceID,
            String patientMedicaidID,
            String patientLastName,
            String patientFirstName,
            String patientTimezone,
            String coordinatorID
    ) {

        setBusinessEntityID(businessEntityID);
        setBusinessEntityMedicaidIdentifier(businessEntityMedicaidIdentifier);
        setPatientOtherID(patientOtherID);
        setSequenceID(sequenceID);
        setPatientMedicaidID(patientMedicaidID);
        setPatientLastName(patientLastName);
        setPatientFirstName(patientFirstName);
        setPatientTimezone(patientTimezone);
        setCoordinatorID(coordinatorID);
    }

    // control the same patient could be in both valid and invalid list.
    private String controlID;

    @NotNull(message = "{patient.BusinessEntityID.null.msg}", groups = DataChecks.class)
    @Size(min=1, max=10, message = "{patient.BusinessEntityID.size.msg}", groups = DataChecks.class)
    @Pattern(regexp = "[\\d]{1,10}$", message = "{patient.BusinessEntityID.pattern.msg}", groups = DataChecks.class)
    @SerializedName("BusinessEntityID")
    @Expose
    private String businessEntityID;

    @NotNull(message = "{patient.BusinessEntityMedicaidIdentifier.null.msg}", groups = DataChecks.class)
    @Size(min=1, max=9, message = "{patient.BusinessEntityMedicaidIdentifier.size.msg}", groups = DataChecks.class)
    @Pattern(regexp = "[\\d]{1,7}$", message = "{patient.BusinessEntityMedicaidIdentifier.pattern.msg}", groups = DataChecks.class)
    @SerializedName("BusinessEntityMedicaidIdentifier")
    @Expose
    private String businessEntityMedicaidIdentifier;

    @NotNull(message = "{patient.PatientOtherID.null.msg}", groups = DataChecks.class)
    @Size(min = 1, max=64, message = "{patient.PatientOtherID.size.msg}", groups = DataChecks.class)
    @Pattern(regexp = "[\\w]{1,64}$", message = "{patient.PatientOtherID.pattern.msg}", groups = DataChecks.class)
    @SerializedName("PatientOtherID")
    @Expose
    private String patientOtherID;

    @NotNull(message = "{patient.SequenceID.null.msg}", groups = DataChecks.class)
    @Size(min=1, max=16, message = "{patient.SequenceID.size.msg}", groups = DataChecks.class)
    @Pattern(regexp = "\\d{1,16}", message = "{patient.SequenceID.pattern.msg}", groups = DataChecks.class)
    @SerializedName("SequenceID")
    @Expose
    private String sequenceID;

    @NotNull(message = "{patient.PatientMedicaidID.null.msg}", groups = DataChecks.class)
    @Size(min=1, max=15, message = "{patient.PatientMedicaidID.size.msg}", groups = DataChecks.class)
    @Pattern(regexp = "[\\d]{1,15}$", message = "{patient.PatientMedicaidID.pattern.msg}", groups = DataChecks.class)
    @SerializedName("PatientMedicaidID")
    private String patientMedicaidID;

    @NotNull(message = "{patient.PatientLastName.null.msg}", groups = DataChecks.class)
    @Size(min=1, max=30, message = "{patient.PatientLastName.size.msg}", groups = DataChecks.class)
    @Pattern(regexp = "[A-Za-z'.\\-]{1,30}", message = "{patient.PatientLastName.pattern.msg}", groups = DataChecks.class)
    @SerializedName("PatientLastName")
    @Expose
    private String patientLastName;

    @NotNull(message = "{patient.PatientFirstName.null.msg}", groups = DataChecks.class)
    @Size(min=1, max=30, message = "{patient.PatientFirstName.size.msg}", groups = DataChecks.class)
    @Pattern(regexp = "[A-Za-z'.\\-]{1,30}", message = "{patient.PatientFirstName.pattern.msg}", groups = DataChecks.class)
    @SerializedName("PatientFirstName")
    @Expose
    private String patientFirstName;

    @NotNull(message = "{patient.PatientTimezone.null.msg}", groups = DataChecks.class)
    @Size(min=1, max=64, message = "{patient.PatientTimezone.size.msg}", groups = DataChecks.class)
    @Pattern(regexp = "[\\w /\\-]{1,64}", message = "{patient.PatientTimezone.pattern.msg}", groups = DataChecks.class)
    @SerializedName("PatientTimezone")
    @Expose
    private String patientTimezone;

    @Size(min=1, max=64, message = "{patient.CoordinatorID.size.msg}", groups = DataChecks.class)
    @Pattern(regexp = "[\\w]{1,64}", message = "{patient.CoordinatorID.pattern.msg}", groups = DataChecks.class)
    @SerializedName("CoordinatorID")
    @Expose
    private String coordinatorID;

    @SerializedName("Address")
    @Expose
    private List<Address> addressList;

    @SerializedName("Phones")
    @Expose
    private List<Phone> phoneList;

    @SerializedName("ResponsibleParty")
    @Expose
    private List<ResponsibleParty> responsiblePartyList;

    public String getBusinessEntityID() {
        return businessEntityID;
    }

    public void setBusinessEntityID(String businessEntityID) {
        this.businessEntityID = ValidateHelper.truncateValue(getClass(), "businessEntityID", businessEntityID);
    }

    public String getBusinessEntityMedicaidIdentifier() {
        return businessEntityMedicaidIdentifier;
    }

    public void setBusinessEntityMedicaidIdentifier(String businessEntityMedicaidIdentifier) {
        this.businessEntityMedicaidIdentifier = ValidateHelper.truncateValue(getClass(), "businessEntityMedicaidIdentifier", businessEntityMedicaidIdentifier);
    }

    public String getPatientOtherID() {
        return patientOtherID;
    }

    public void setPatientOtherID(String patientOtherID) {
        this.patientOtherID = ValidateHelper.truncateValue(getClass(), "patientOtherID", patientOtherID);
        this.setOtherID(patientOtherID);
    }

    public String getSequenceID() {
        return sequenceID;
    }

    public void setSequenceID(String sequenceID) {
        this.sequenceID = ValidateHelper.truncateValue(getClass(), "sequenceID", sequenceID);
    }

    public String getPatientMedicaidID() {
        return patientMedicaidID;
    }

    public void setPatientMedicaidID(String patientMedicaidID) {
        this.patientMedicaidID = ValidateHelper.truncateValue(getClass(), "patientMedicaidID", patientMedicaidID);
    }

    public String getPatientLastName() {
        return patientLastName;
    }

    public void setPatientLastName(String patientLastName) {
        this.patientLastName = ValidateHelper.truncateValue(getClass(), "patientLastName", patientLastName);
    }

    public String getPatientFirstName() {
        return patientFirstName;
    }

    public void setPatientFirstName(String patientFirstName) {
        this.patientFirstName = ValidateHelper.truncateValue(getClass(), "patientFirstName", patientFirstName);
    }

    public String getPatientTimezone() {
        return patientTimezone;
    }

    public void setPatientTimezone(String patientTimezone) {
        this.patientTimezone = ValidateHelper.replaceDefaultValue(getClass(), "patientTimezone", patientTimezone, "US/Eastern");
    }

    public String getCoordinatorID() {
        return coordinatorID;
    }

    public void setCoordinatorID(String coordinatorID) {
        this.coordinatorID = ValidateHelper.truncateValue(getClass(), "coordinatorID", coordinatorID);
    }

    public List<Address> getAddressList() {
        return addressList;
    }

    public void setAddressList(List<Address> addressList) {
        this.addressList = addressList;
    }

    public List<Phone> getPhoneList() {
        return phoneList;
    }

    public void setPhoneList(List<Phone> phoneList) {
        this.phoneList = phoneList;
    }

    public List<ResponsibleParty> getResponsiblePartyList() {
        return responsiblePartyList;
    }

    public void setResponsiblePartyList(List<ResponsibleParty> responsiblePartyList) {
        this.responsiblePartyList = responsiblePartyList;
    }

    public String getControlID() {
        return controlID;
    }

    public void setControlID(String controlID) {
        this.controlID = controlID;
    }

    public String toString() {
        String data =
                "Patient["
                        + "businessEntityID=" + businessEntityID
                        + ",businessEntityMedicaidIdentifier=" + businessEntityMedicaidIdentifier
                        + ",patientOtherID=" + patientOtherID
                        + ",sequenceID=" + sequenceID
                        + ",patientMedicaidID=" + patientMedicaidID
                        + ",patientLastName=" + patientLastName
                        + ",patientFirstName=" + patientFirstName
                        + ",patientTimezone" + patientTimezone
                        + ",coordinatorID=" + coordinatorID
                        + ",controlID=" + controlID
                        + "]";

        return data;

    }

    @Override
    public boolean equals(Object o) {
        if( o instanceof Patient ) {
            Patient p = (Patient) o;
            return (
                    ((this.businessEntityID == null && p.getBusinessEntityID() == null) || this.businessEntityID.equalsIgnoreCase(p.getBusinessEntityID()))
                    && ((this.businessEntityMedicaidIdentifier == null && p.getBusinessEntityMedicaidIdentifier() == null) || this.businessEntityMedicaidIdentifier.equalsIgnoreCase(p.getBusinessEntityMedicaidIdentifier()))
                    && ((this.patientOtherID == null && p.getPatientOtherID() == null) || this.patientOtherID.equalsIgnoreCase(p.getPatientOtherID()))
                    && ((this.sequenceID == null && p.getSequenceID() == null) || this.sequenceID.equalsIgnoreCase(p.getSequenceID()))
                    && ((this.patientMedicaidID == null && p.getPatientMedicaidID() == null) || this.patientMedicaidID.equalsIgnoreCase(p.getPatientMedicaidID())))
                    || (this.controlID != null && this.controlID.equals(p.getControlID())
            );
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        if(controlID != null) {
            return Objects.hash(controlID);
        } else {
            return Objects.hash(businessEntityID, businessEntityMedicaidIdentifier, patientOtherID, sequenceID,
                    patientMedicaidID, patientLastName, patientFirstName, patientTimezone, coordinatorID);
        }
    }
}

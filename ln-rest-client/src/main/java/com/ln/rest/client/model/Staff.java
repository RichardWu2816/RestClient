package com.ln.rest.client.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.ln.rest.client.validation.DataChecks;
import com.ln.rest.client.validation.ValidateHelper;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class Staff extends SandataMessage {

    public Staff() {
    }

    public Staff(
            String businessEntityID,
            String businessEntityMedicaidIdentifier,
            String staffOtherID,
            String sequenceID,
            String staffID,
            String staffSSN,
            String staffLastName,
            String staffFirstName,
            String staffEmail,
            String staffPosition
    ) {
        setBusinessEntityID(businessEntityID);
        setBusinessEntityMedicaidIdentifier(businessEntityMedicaidIdentifier);
        setStaffOtherID(staffOtherID);
        setSequenceID(sequenceID);
        setStaffID(staffID);
        setStaffSSN(staffSSN);
        setStaffLastName(staffLastName);
        setStaffFirstName(staffFirstName);
        setStaffEmail(staffEmail);
        setStaffPosition(staffPosition);
    }


    @NotNull(message = "{staff.BusinessEntityID.null.msg}", groups = DataChecks.class)
    @Size(min = 1, max = 10, message = "{staff.BusinessEntityID.size.msg}", groups = DataChecks.class)
    @Pattern(regexp = "[\\d]{1,10}$", message = "{staff.BusinessEntityID.pattern.msg}", groups = DataChecks.class)
    @SerializedName("BusinessEntityID")
    @Expose
    private String businessEntityID;

    @NotNull(message = "{staff.BusinessEntityMedicaidIdentifier.null.msg}", groups = DataChecks.class)
    @Size(min = 1, max = 9, message = "{staff.BusinessEntityMedicaidIdentifier.size.msg}", groups = DataChecks.class)
    @Pattern(regexp = "[\\d]{1,7}$", message = "{staff.BusinessEntityMedicaidIdentifier.pattern.msg}", groups = DataChecks.class)
    @SerializedName("BusinessEntityMedicaidIdentifier")
    @Expose
    private String businessEntityMedicaidIdentifier;

    @NotNull(message = "{staff.StaffOtherID.null.msg}", groups = DataChecks.class)
    @Size(min = 1, max = 64, message = "{staff.StaffOtherID.size.msg}", groups = DataChecks.class)
    @Pattern(regexp = "[\\w]{1,64}$", message = "{staff.StaffOtherID.pattern.msg}", groups = DataChecks.class)
    @SerializedName("StaffOtherID")
    @Expose
    private String staffOtherID;

    @NotNull(message = "{staff.SequenceID.null.msg}", groups = DataChecks.class)
    @Size(min = 1, max = 16, message = "{staff.SequenceID.size.msg}", groups = DataChecks.class)
    @Pattern(regexp = "\\d{1,16}", message = "{staff.SequenceID.pattern.msg}", groups = DataChecks.class)
    @SerializedName("SequenceID")
    @Expose
    private String sequenceID;

    @NotNull(message = "{staff.StaffID.null.msg}", groups = DataChecks.class)
    @Size(min = 1, max = 9, message = "{staff.StaffID.size.msg}", groups = DataChecks.class)
    @Pattern(regexp = "\\d{1,9}", message = "{staff.StaffID.pattern.msg}", groups = DataChecks.class)
    @SerializedName("StaffID")
    @Expose
    private String staffID;

    @NotNull(message = "{staff.StaffSSN.null.msg}", groups = DataChecks.class)
    @Size(min = 9, max = 9, message = "{staff.StaffSSN.size.msg}", groups = DataChecks.class)
    @Pattern(regexp = "^\\d{9}$", message = "{staff.StaffSSN.pattern.msg}", groups = DataChecks.class)
    @SerializedName("StaffSSN")
    @Expose
    private String staffSSN;

    @NotNull(message = "{staff.StaffLastName.null.msg}", groups = DataChecks.class)
    @Size(min = 1, max = 30, message = "{staff.StaffLastName.size.msg}", groups = DataChecks.class)
    @Pattern(regexp = "[A-Za-z'.\\-]{1,30}", message = "{staff.StaffLastName.pattern.msg}", groups = DataChecks.class)
    @SerializedName("StaffLastName")
    @Expose
    private String staffLastName;

    @NotNull(message = "{staff.StaffFirstName.null.msg}", groups = DataChecks.class)
    @Size(min = 1, max = 30, message = "{staff.StaffFirstName.size.msg}", groups = DataChecks.class)
    @Pattern(regexp = "[A-Za-z'.\\-]{1,30}", message = "{staff.StaffFirstName.pattern.msg}", groups = DataChecks.class)
    @SerializedName("StaffFirstName")
    @Expose
    private String staffFirstName;

    @Size(min = 1, max = 64, message = "{staff.StaffEmail.size.msg}", groups = DataChecks.class)
    @Pattern(regexp = "^(?=.{1,64}$)[_a-zA-Z0-9-]+(\\.[_a-zA-Z0-9-]+)*@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*(\\.[a-zA-Z]{2,4})$", message = "{staff.StaffEmail.pattern.msg}", groups = DataChecks.class)
    @SerializedName("StaffEmail")
    @Expose
    private String staffEmail;

    @Size(min = 2, max = 3, message = "{staff.StaffPosition.size.msg}", groups = DataChecks.class)
    @Pattern(regexp = "HHA|HCA|RN|LPN|PCA|hha|hca|rn|lpn|pca|Hha|Hca|Rn|Lpn|Pca", message = "{staff.StaffPosition.pattern.msg}", groups = DataChecks.class)
    @SerializedName("StaffPosition")
    @Expose
    private String staffPosition;


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

    public String getStaffOtherID() {
        return staffOtherID;
    }

    public void setStaffOtherID(String staffOtherID) {
        this.staffOtherID = ValidateHelper.truncateValue(getClass(), "staffOtherID", staffOtherID);
        this.setOtherID(staffOtherID);
    }

    public String getSequenceID() {
        return sequenceID;
    }

    public void setSequenceID(String sequenceID) {
        this.sequenceID = ValidateHelper.truncateValue(getClass(), "sequenceID", sequenceID);
    }

    public String getStaffID() {
        return staffID;
    }

    public void setStaffID(String staffID) {
        this.staffID = ValidateHelper.truncateValue(getClass(), "staffID", staffID);

    }

    public String getStaffSSN() {
        return staffSSN;
    }

    public void setStaffSSN(String staffSSN) {
        this.staffSSN = ValidateHelper.truncateValue(getClass(), "staffSSN", staffSSN);
    }

    public String getStaffLastName() {
        return staffLastName;
    }

    public void setStaffLastName(String staffLastName) {
        this.staffLastName = ValidateHelper.truncateValue(getClass(), "staffLastName", staffLastName);
    }

    public String getStaffFirstName() {
        return staffFirstName;
    }

    public void setStaffFirstName(String staffFirstName) {
        this.staffFirstName = ValidateHelper.truncateValue(getClass(), "staffFirstName", staffFirstName);
    }

    public String getStaffEmail() {
        return staffEmail;
    }

    public void setStaffEmail(String staffEmail) {
        this.staffEmail = ValidateHelper.truncateValue(getClass(), "staffEmail", staffEmail);
    }

    public String getStaffPosition() {
        return staffPosition;
    }

    public void setStaffPosition(String staffPosition) {
        this.staffPosition = ValidateHelper.replaceDefaultValue(getClass(), "staffPosition", staffPosition, null);
    }

    @Override
    public boolean equals(Object o) {
        if( o instanceof Staff ) {
            Staff p = (Staff) o;
            return (
                    ((this.businessEntityID == null && p.getBusinessEntityID() == null) || this.businessEntityID.equalsIgnoreCase(p.getBusinessEntityID()))
                    && ((this.businessEntityMedicaidIdentifier == null && p.getBusinessEntityMedicaidIdentifier() == null ) || this.businessEntityMedicaidIdentifier.equalsIgnoreCase(p.getBusinessEntityMedicaidIdentifier()))
                    && ((this.staffOtherID == null && p.getStaffOtherID() == null) || this.staffOtherID.equalsIgnoreCase(p.getStaffOtherID()))
                    && ((this.sequenceID == null && p.getSequenceID() == null) || this.sequenceID.equalsIgnoreCase(p.getSequenceID()))
                    && ((this.staffID == null || p.getStaffID() == null) || this.staffID.equalsIgnoreCase(p.getStaffID()))
            );

        } else {
            return false;
        }
    }


    public String toString() {
        String data =
                "Staff["
                        + "businessEntityID=" + businessEntityID
                        + ",businessEntityMedicaidIdentifier=" + businessEntityMedicaidIdentifier
                        + ",staffOtherID=" + staffOtherID
                        + ",sequenceID=" + sequenceID
                        + ",staffID=" + staffID
                        + ",staffSSN=" + staffSSN
                        + ",staffLastName=" + staffLastName
                        + ",staffFirstName" + staffFirstName
                        + ",staffEmail=" + staffEmail
                        + ",staffPosition=" + staffPosition
                        + "]";

        return data;
    }
}

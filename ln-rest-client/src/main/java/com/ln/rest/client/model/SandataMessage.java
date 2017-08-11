package com.ln.rest.client.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by richardwu on 3/24/2017.
 */
public abstract class SandataMessage extends BaseObject {

    @SerializedName("ErrorCode")
    private String errorCode;

    @SerializedName("ErrorMessage")
    private String errorMessage;

    private transient String otherID;

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getOtherID() {
        return otherID;
    }

    public void setOtherID(String otherID) {
        this.otherID = otherID;
    }
}

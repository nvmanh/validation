package com.manhnv.validation;

import java.util.HashMap;
import java.util.Map;

import android.text.TextUtils;
import android.widget.TextView;

public class RequiredVerifier implements IVerifier {
    private TextView field;
    private String fieldName;
    Map<Integer, String> messages;
    private int errorCode;
    private boolean isRequired;
    private String userDefinedMessage;

    public RequiredVerifier(TextView field, String filedName) {
        this.field = field;
        this.fieldName = filedName;
        messages = new HashMap<Integer, String>();
        messages.put(ERROR_CODE_REQUIRED, "is required");
        this.errorCode = -1;
        setRequired(true);
    }

    @Override
    public boolean verify() {
        if (!isRequired) {
            setErrorCode(SUCCESS_CODE);
            return true;
        }
        boolean isValidate = getText().toString().trim().length() != 0;
        if (!isValidate) {
            errorCode = ERROR_CODE_REQUIRED;
        } else {
            setErrorCode(SUCCESS_CODE);
        }
        return isValidate;
    }

    @Override
    public String getErrorMessage() {
        return !TextUtils.isEmpty(userDefinedMessage) ? userDefinedMessage
            : getErrorMessage(getErrorCode());
    }

    public String getErrorMessage(int error) {
        return getFieldName() + " " + messages.get(error);
    }

    public String getText() {
        return getField().getText().toString();
    }

    public void setMessage(int error, String message) {
        messages.put(error, message);
    }

    @Override
    public String getFieldName() {
        return fieldName;
    }

    public TextView getField() {
        return field;
    }

    @Override
    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    protected void setRequired(boolean isRequired) {
        this.isRequired = isRequired;
    }

    @Override
    public void showError() {
        field.setClickable(true);
        field.setFocusable(true);
        field.setFocusableInTouchMode(true);
        field.setError(getErrorMessage());
    }

    @Override
    public void hideError() {
        field.setError(null);
    }

    @Override
    public void setErrorMessage(String message) {
        this.userDefinedMessage = message;
    }
}

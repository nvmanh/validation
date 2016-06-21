package com.manhnv.validation;

import com.manhnv.validation.utils.DateTimeUtil;

import android.widget.TextView;

public class FutureDateVerifier extends RequiredVerifier {
    private String dateFormat;

    public FutureDateVerifier(TextView field, String filedName, String dateFormat) {
        super(field, filedName);
        this.dateFormat = dateFormat;
        setMessage(ERROR_CODE_FUTURE, " must be in future");
    }

    @Override
    public boolean verify() {
        boolean isValid = super.verify();
        if (!isValid)
            return isValid;
        String text = getText();
        long future = DateTimeUtil.stringToDate(text, dateFormat).getTime();
        if (future <= System.currentTimeMillis()) {
            isValid = false;
            setErrorCode(ERROR_CODE_FUTURE);
        } else {
            isValid = true;
            setErrorCode(SUCCESS_CODE);
        }
        return isValid;
    }
}
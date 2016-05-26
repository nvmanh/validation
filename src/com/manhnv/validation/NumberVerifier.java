package com.manhnv.validation;

import java.text.NumberFormat;
import java.text.ParseException;

import android.widget.TextView;

public class NumberVerifier extends RequiredVerifier {
    public NumberVerifier(TextView field, String filedName) {
        super(field, filedName);
        setMessage(ERROR_CODE_NUMBER, " must be number");
    }

    @Override
    public boolean verify() {
        boolean isValid = super.verify();
        if (!isValid)
            return isValid;
        try {
            NumberFormat.getInstance().parse(getText());
            isValid = true;
        } catch (ParseException e) {
            isValid = false;
        }
        if (isValid)
            setErrorCode(SUCCESS_CODE);
        else
            setErrorCode(ERROR_CODE_NUMBER);
        return isValid;
    }
}
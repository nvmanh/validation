package com.manhnv.validation;

import android.widget.TextView;

public class LengthVerifier extends RequiredVerifier {
    private int min;
    private int max;

    /**
     * @param field
     * @param filedName
     * @param min
     * @param max:
     *            if max = 0, max will be ignored
     */
    public LengthVerifier(TextView field, String filedName, int min, int max) {
        super(field, filedName);
        this.min = min;
        this.max = max;
        if (min <= 0)
            throw new IllegalArgumentException("Min must be greater than 0");
        if (max != 0 && max < min)
            throw new IllegalArgumentException("Max < Min. Please make sure that Max >= Min ");
        setMessage(ERROR_CODE_MIN, " length must be than " + min);
        setMessage(ERROR_CODE_MAX, " length must lower than " + max);
    }

    @Override
    public boolean verify() {
        boolean isValid = super.verify();
        if (!isValid)
            return isValid;
        String text = getText();
        if (text.length() < min) {
            isValid = false;
            setErrorCode(ERROR_CODE_MIN);
        } else if (max != 0 && text.length() > max) {
            isValid = false;
            setErrorCode(ERROR_CODE_MAX);
        }
        return isValid;
    }
}

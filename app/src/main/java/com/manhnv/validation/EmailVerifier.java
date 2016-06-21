package com.manhnv.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import android.widget.TextView;

public class EmailVerifier extends RequiredVerifier {
    public EmailVerifier(TextView field, String filedName) {
        super(field, filedName);
        setMessage(ERROR_CODE_EMAIL, " is not valide");
        pattern = Pattern.compile(EMAIL_PATTERN);
    }

    @Override
    public boolean verify() {
        String email = getText();
        boolean isValide = super.verify();
        if (!isValide)
            return isValide;
        else if (!validate(email)) {
            // else if(!RegularExpressionUtils.isEmail(email)) {
            isValide = false;
            setErrorCode(ERROR_CODE_EMAIL);
        } else {
            isValide = true;
            setErrorCode(SUCCESS_CODE);
        }
        return isValide;
    }
    private Pattern pattern;
    private Matcher matcher;
    private static final String EMAIL_PATTERN =
        "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    /**
     * Validate hex with regular expression
     * 
     * @param hex
     *            hex for validation
     * @return true valid hex, false invalid hex
     */
    private boolean validate(String hex) {
        matcher = pattern.matcher(hex);
        return matcher.matches();
    }
}

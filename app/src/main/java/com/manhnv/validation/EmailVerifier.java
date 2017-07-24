package com.manhnv.validation;

import android.text.TextUtils;
import android.widget.TextView;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailVerifier extends RequiredVerifier {
    private String mEmailPattern;
    private Pattern pattern;
    private Matcher matcher;
    private static final String EMAIL_PATTERN =
            "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    public EmailVerifier(TextView field, String filedName) {
        super(field, filedName);
        setMessage(ERROR_CODE_EMAIL, " is not validate");
        pattern = Pattern.compile(EMAIL_PATTERN);
    }

    @Override
    public boolean verify() {
        String email = getText();
        boolean isValidate = super.verify();
        if (!isValidate) {
            return isValidate;
        } else if (!validate(email)) {
            isValidate = false;
            setErrorCode(ERROR_CODE_EMAIL);
        } else {
            isValidate = true;
            setErrorCode(SUCCESS_CODE);
        }
        return isValidate;
    }

    public void setEmailPattern(String emailPattern) {
        if (TextUtils.isEmpty(emailPattern)) {
            return;
        }
        mEmailPattern = emailPattern;
        pattern = Pattern.compile(emailPattern);
    }

    /**
     * Validate hex with regular expression
     *
     * @param hex hex for validation
     * @return true valid hex, false invalid hex
     */
    private boolean validate(String hex) {
        matcher = pattern.matcher(hex);
        return matcher.matches();
    }
}

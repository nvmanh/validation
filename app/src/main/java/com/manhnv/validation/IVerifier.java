package com.manhnv.validation;

public interface IVerifier {
    int SUCCESS_CODE = -1;
    int ERROR_CODE_REQUIRED = 0;
    int ERROR_CODE_MIN = 1;
    int ERROR_CODE_MAX = 2;
    int ERROR_CODE_EMAIL = 3;
    int ERROR_CODE_NUMBER = 4;
    int ERROR_CODE_FUTURE = 5;
    int ERROR_CODE_FROM_DATE = 6;
    int ERROR_CODE_TO_DATE = 7;

    /**
     * do validate action in here
     *
     * @return true: validated success<br>
     * false: validated fail
     */
    boolean verify();

    /**
     * error message will be show on
     *
     * @return if user define his message {@link #setErrorMessage(String)} -> show this message<br>
     * if not show default message field name + message
     * @see android.widget.EditText#setError(CharSequence)
     */
    String getErrorMessage();

    /**
     * using to show error message and you can know what field is invalid
     *
     * @return field name (pass in constructor by user)
     */
    String getFieldName();

    /**
     * belong to type of verifier: email, phone, blank ...
     *
     * @return String fit with error code
     */
    String getErrorMessage(int error);

    /**
     * belong to type of verifier: email, phone, blank ...
     *
     * @return code of error
     */
    int getErrorCode();

    /**
     * @see android.widget.EditText#setError(CharSequence)
     */
    void showError();

    /**
     * @see android.widget.EditText#setError(CharSequence)
     */
    void hideError();

    /**
     * user defined his message
     */
    void setErrorMessage(String message);
}
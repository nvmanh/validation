package com.manhnv.validation;

public interface IVerifier {
    public static final int SUCCESS_CODE = -1;
    public static final int ERROR_CODE_REQUIRED = 0;
    public static final int ERROR_CODE_MIN = 1;
    public static final int ERROR_CODE_MAX = 2;
    public static final int ERROR_CODE_EMAIL = 3;
    public static final int ERROR_CODE_NUMBER = 4;
    public static final int ERROR_CODE_FUTURE = 5;
    public static final int ERROR_CODE_FROM_DATE = 6;
    public static final int ERROR_CODE_TO_DATE = 7;

    /**
     * do validate action in here
     * 
     * @return true: validated success<br>
     *         false: validated fail
     */
    boolean verify();

    /**
     * error message will be show on
     * {@linkplain #android.widget.TextView.setError(CharSequence error)}
     * 
     * @return if user define his message {@link #setErrorMessage(String)} -> show this message<br>
     *         if not show default message field name + message
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
     * @param error
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
     * {@linkplain #android.widget.TextView.setError(CharSequence error)}
     */
    void showError();

    /**
     * {@linkplain #android.widget.TextView.setError(CharSequence error)} setError(null)
     */
    void hideError();

    /**
     * user defined his message
     * 
     * @param message
     */
    void setErrorMessage(String message);
}
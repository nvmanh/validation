package com.manhnv.validation;

import java.util.Date;

import com.manhnv.validation.utils.DateTimeUtil;

import android.widget.TextView;

public class DateRangeVerifier extends RequiredVerifier {
    private String dateFormat;
    private long from;
    private long to;

    public DateRangeVerifier(TextView field, String filedName, String dateFormat, String from,
        String to) {
        this(field, filedName, dateFormat, DateTimeUtil.stringToDate(from, dateFormat).getTime(),
            DateTimeUtil.stringToDate(to, dateFormat).getTime());
    }

    public DateRangeVerifier(TextView field, String filedName, String dateFormat, long from,
        long to) {
        super(field, filedName);
        if (from > to)
            throw new IllegalArgumentException("from date must be less than to date");
        this.dateFormat = dateFormat;
        String message = " must be from " + DateTimeUtil.dateToString(new Date(from), dateFormat)
            + " to " + DateTimeUtil.dateToString(new Date(to), dateFormat);
        setMessage(ERROR_CODE_FROM_DATE, message);
        setMessage(ERROR_CODE_TO_DATE, message);
        this.from = from;
        this.to = to;
    }

    @Override
    public boolean verify() {
        boolean isValid = super.verify();
        if (!isValid)
            return isValid;
        String text = getText();
        long future = DateTimeUtil.stringToDate(text, dateFormat).getTime();
        if (future < from) {
            isValid = false;
            setErrorCode(ERROR_CODE_FROM_DATE);
        } else if (future > to) {
            isValid = false;
            setErrorCode(ERROR_CODE_TO_DATE);
        } else {
            isValid = true;
            setErrorCode(SUCCESS_CODE);
        }
        return isValid;
    }
}

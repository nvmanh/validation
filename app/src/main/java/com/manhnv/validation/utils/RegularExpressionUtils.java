package com.manhnv.validation.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpressionUtils {
    public static final List<String> getListExpression(String content, String regex) {
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(content);
        List<String> list = new ArrayList<String>();
        while (m.find()) {
            String text = m.group(1);
            list.add(text);
        }
        return list;
    }
    public static final String EMAIL_PATTERN =
        "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    public static final boolean isEmail(String email) {
        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public static final boolean isValid(String valid, String expression) {
        Pattern p = Pattern.compile(expression);
        Matcher matcher = p.matcher(valid);
        return matcher.matches();
    }
}

package com.manhnv.validation;

import android.telephony.PhoneNumberUtils;
import android.text.TextUtils;
import android.widget.TextView;

public class PhoneVerifier extends RequiredVerifier {
    public PhoneVerifier(TextView field, String filedName) {
        super(field, filedName);
    }

    @Override
    public boolean verify() {
        String text = getText();
        return !TextUtils.isEmpty(text) && PhoneNumberUtils.isGlobalPhoneNumber(text);
    }
}
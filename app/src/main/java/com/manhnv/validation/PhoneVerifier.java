package com.manhnv.validation;

import android.telephony.PhoneNumberUtils;
import android.widget.TextView;

public class PhoneVerifier extends RequiredVerifier {
    public PhoneVerifier(TextView field, String filedName) {
        super(field, filedName);
    }

    @Override
    public boolean verify() {
        return super.verify() && PhoneNumberUtils.isGlobalPhoneNumber(getText());
    }
}
package com.manhnv.validation.sample;

import com.manhnv.validation.DateRangeVerifier;
import com.manhnv.validation.EmailVerifier;
import com.manhnv.validation.LengthVerifier;
import com.manhnv.validation.NumberVerifier;
import com.manhnv.validation.PhoneVerifier;
import com.manhnv.validation.RequiredVerifier;
import com.manhnv.validation.VerifierBuilder;
import com.manhnv.validation.utils.DateTimeUtil;

import android.app.Activity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

public class VerifyActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EditText edtNotBlankRequired = new EditText(this);
        EditText edtEmailRequired = new EditText(this);
        EditText edtPhoneRequired = new EditText(this);
        EditText edtNumberRequired = new EditText(this);
        EditText edtLengthRequired = new EditText(this);
        EditText edtInDateRangeRequired = new EditText(this);
        LinearLayout layout = new LinearLayout(this);
        layout.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT));
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.addView(edtNotBlankRequired);
        layout.addView(edtEmailRequired);
        layout.addView(edtPhoneRequired);
        layout.addView(edtNumberRequired);
        layout.addView(edtLengthRequired);
        layout.addView(edtInDateRangeRequired);
        setContentView(layout);
        VerifierBuilder builder = new VerifierBuilder();
        builder.registerVerifier(new RequiredVerifier(edtNotBlankRequired, "Your name"));
        builder.registerVerifier(new EmailVerifier(edtEmailRequired, "Email"));
        builder.registerVerifier(new PhoneVerifier(edtPhoneRequired, "Phone"));
        builder.registerVerifier(new NumberVerifier(edtNumberRequired, "Your ID card no."));
        builder.registerVerifier(new LengthVerifier(edtLengthRequired, "Address", 4, 300));
        builder.registerVerifier(new DateRangeVerifier(edtInDateRangeRequired, "Register date",
                DateTimeUtil.COMMON_DATE_FORMAT, "05/20/2016", "05/20/2017"));
        boolean validate = builder.verify();
        if (validate) {
            doContinue();
        }
    }

    private void doContinue() {
        Toast.makeText(this, "Verified!", Toast.LENGTH_SHORT).show();
    }
}
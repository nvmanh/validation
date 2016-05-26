# validation

### How to use:

        edtNotBlankRequired = (EditText) findViewById(R.id.edt_name);
        edtEmailRequired = (EditText) findViewById(R.id.edt_email);
        edtPhoneRequired = (EditText) findViewById(R.id.edt_phone);
        edtNumberRequired = (EditText) findViewById(R.id.edt_number);
        edtLengthRequired = (EditText) findViewById(R.id.edt_text_length);
        edtInDateRangeRequired = (EditText) findViewById(R.id.edt_future);
        
And validate:

        VerifierBuilder builder = new VerifierBuilder();
        builder.registerVerifier(new RequiredVerifier(edtNotBlankRequired, "Your name"));
        builder.registerVerifier(new EmailVerifier(edtEmailRequired, "Email"));
        builder.registerVerifier(new PhoneVerifier(edtPhoneRequired, "Phone"));
        builder.registerVerifier(new NumberVerifier(edtNumberRequired, "Your ID card no."));
        builder.registerVerifier(new LengthVerifier(edtLengthRequired, "Address", 4, 300));
        builder.registerVerifier(new DateRangeVerifier(edtInDateRangeRequired, "Register date",
            DateTimeUtil.COMMON_DATE_FORMAT, "05/20/2016", "05/20/2017"));
        boolean verify = builder.verify();
        if(verify){
            Toast.makeText(this, "Validate success!", Toast.LENGTH_LONG).show();
        }
        
### Download:

  You can checkout this repository or download JAR here:
  https://drive.google.com/file/d/0B-djf-eA7_LRUk5ObGNGcmRRdnM/view?usp=sharing
  

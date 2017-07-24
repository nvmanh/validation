package com.manhnv.validation;

import java.util.ArrayList;
import java.util.List;

public class VerifierBuilder {
    List<IVerifier> verifiers;
    IVerifier inValid;

    public VerifierBuilder() {
        verifiers = new ArrayList<IVerifier>();
    }

    /**
     * register your verifier here and we hold it in an array to check later
     * 
     * @param verifier
     * @return this <Builder pattern>
     */
    public VerifierBuilder registerVerifier(IVerifier verifier) {
        verifiers.add(verifier);
        return this;
    }

    /**
     * We will verify all verifier object which you registered in
     * {@link #registerVerifier(IVerifier)}
     * 
     * @return true: validate success<br>
     *         false: validate fail
     */
    public boolean verify() {
        for (int i = 0; i < verifiers.size(); i++) {
            IVerifier verifier = verifiers.get(i);
            verifier.hideError();
            if (!verifier.verify()) {
                verifier.showError();
                inValid = verifier;
                return false;
            }
        }
        inValid = null;
        return true;
    }

    /**
     * after get invalid verifier, you can get message to show which is validating and not success
     * 
     * @return error message
     */
    public String getErrorMessage() {
        if (inValid == null)
            return null;
        return inValid.getErrorMessage();
    }

    /**
     * code of verifier which not pass
     * 
     * @return code
     */
    public int getErrorCode() {
        if (inValid == null)
            return -1;
        return inValid.getErrorCode();
    }
}

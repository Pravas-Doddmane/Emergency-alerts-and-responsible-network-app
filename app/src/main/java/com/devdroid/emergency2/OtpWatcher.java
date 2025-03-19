package com.devdroid.emergency2;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

public class OtpWatcher implements TextWatcher {
    private final EditText[] otpFields;
    private final int index;

    public OtpWatcher(EditText[] otpFields, int index) {
        this.otpFields = otpFields;
        this.index = index;
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        if (count == 1 && index < otpFields.length - 1) {
            otpFields[index + 1].requestFocus(); // Move to next field
        }
    }

    @Override
    public void afterTextChanged(Editable s) {}
}

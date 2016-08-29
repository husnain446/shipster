package com.byteshaft.shipster.account;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.byteshaft.shipster.R;

public class ForgotPasswordActivity extends Activity {

    private Button mRecoverButton;
    private EditText mEmail;

    private String mEmailString;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.forgot_password_activity);
        mEmail = (EditText) findViewById(R.id.email_address);
        mRecoverButton = (Button) findViewById(R.id.recover);
        mRecoverButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (validate()) {
                    new ForgotPasswordTask().execute();
                }

            }
        });
    }

    public boolean validate() {
        boolean valid = true;
        mEmailString = mEmail.getText().toString();

        if (mEmailString.trim().isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.
                matcher(mEmailString).matches()) {
            mEmail.setError("enter a valid email address");
            valid = false;
        }
        return valid;
    }

    class ForgotPasswordTask extends AsyncTask<String, String, String> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected String doInBackground(String... strings) {
            return null;
        }
        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
        }
    }
}

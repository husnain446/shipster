package com.byteshaft.shipster.account;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import com.byteshaft.requests.HttpRequest;
import com.byteshaft.shipster.MainActivity;
import com.byteshaft.shipster.R;
import com.byteshaft.shipster.utils.WebserviceHelper;

import org.json.JSONException;
import org.json.JSONObject;
import java.net.HttpURLConnection;


public class LoginActivity extends Activity implements View.OnClickListener,
        HttpRequest.OnReadyStateChangeListener, HttpRequest.OnErrorListener {

    private EditText mEmail;
    private EditText mPassword;
    private Button mLoginButton;
    private TextView mRegisterTextView;
    private TextView mForgotPasswordTextView;

    private String mPasswordString;
    private String mEmailString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);
        mEmail = (EditText) findViewById(R.id.email_address);
        mPassword = (EditText) findViewById(R.id.password);
        mRegisterTextView = (TextView) findViewById(R.id.register);
        mForgotPasswordTextView = (TextView) findViewById(R.id.tv_forgot_password);
        mLoginButton = (Button) findViewById(R.id.login);

        mLoginButton.setOnClickListener(this);
        mForgotPasswordTextView.setOnClickListener(this);
        mRegisterTextView.setOnClickListener(this);
    }

    public boolean validate() {
        boolean valid = true;

        mEmailString = mEmail.getText().toString().trim();
        mPasswordString = mPassword.getText().toString().trim();

        if (mEmailString.trim().isEmpty()) {
            mEmail.setError("enter a valid email address");
            valid = false;
        } else {
            mEmail.setError(null);
        }

        if (mPasswordString.isEmpty() || mPassword.length() < 4) {
            mPassword.setError("Enter minimum 4 alphanumeric characters");
            valid = false;
        } else {
            mPassword.setError(null);
        }
        return valid;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.login:
                if (validate()) {
                    login(mEmailString, mPasswordString);
                    startActivity(new Intent(getApplicationContext(), MainActivity.class));
                }
                break;
            case R.id.register:
                startActivity(new Intent(getApplicationContext(), RegisterActivity.class));
                break;
            case R.id.tv_forgot_password:
                startActivity(new Intent(getApplicationContext(), ForgotPasswordActivity.class));

        }
    }

    private void login(String username, String password) {
        HttpRequest request = new HttpRequest(getApplicationContext());
        request.setOnReadyStateChangeListener(this);
        request.setOnErrorListener(this);
        request.open("POST", "https://shipsterusa.com/my_services/user/login.json");
        request.send(getLoginData(username, password));
        WebserviceHelper.showProgressDialog(LoginActivity.this, "Getting User Information");
    }



    private String getLoginData(String username, String password){

        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("username", username);
            jsonObject.put("password", password);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jsonObject.toString();

    }


    @Override
    public void onReadyStateChange(HttpRequest request, int readyState) {
        switch (readyState) {
            case HttpRequest.STATE_DONE:
                switch (request.getStatus()) {
                    case HttpURLConnection.HTTP_OK:
                        System.out.println(request.getResponseText());
                        WebserviceHelper.dismissProgressDialog();
                }
        }
    }

    @Override
    public void onError(HttpRequest request) {
        System.out.println(request.getStatus());
        switch (request.getStatus()) {
            case HttpURLConnection.HTTP_UNAUTHORIZED:
                Toast.makeText(getApplicationContext(), "wrong password", Toast.LENGTH_SHORT).show();
        }
    }
}

package com.byteshaft.shipster.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.byteshaft.shipster.R;

public class DashBoard extends Fragment implements View.OnClickListener {

    private View mBaseView;
    private TextView mAddressText;
    private Button editAccountButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mBaseView = inflater.inflate(R.layout.dashboard, container, false);
        mAddressText = (TextView) mBaseView.findViewById(R.id.tv_address);
        editAccountButton = (Button) mBaseView.findViewById(R.id.button_edit_account);
        editAccountButton.setOnClickListener(this);
        return mBaseView;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_edit_account:
                System.out.println("edit account");
                break;
        }
    }
}

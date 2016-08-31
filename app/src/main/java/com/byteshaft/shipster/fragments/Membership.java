package com.byteshaft.shipster.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.byteshaft.shipster.MainActivity;
import com.byteshaft.shipster.R;

public class Membership extends Fragment implements View.OnClickListener {

    private View mBaseView;
    private Button mCheckButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mBaseView = inflater.inflate(R.layout.membership, container, false);
        mCheckButton = (Button) mBaseView.findViewById(R.id.check_button);
        mCheckButton.setOnClickListener(this);
        return mBaseView;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.check_button:
                System.out.println("working");
                startActivity(new Intent(getActivity(), Checkout.class));

        }
    }
}

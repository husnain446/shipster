package com.byteshaft.shipster.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.byteshaft.shipster.R;

/**
 * Created by husnain on 8/17/16.
 */
public class ResetPassword extends Fragment {

    private View mBaseView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mBaseView = inflater.inflate(R.layout.reset_password, container, false);
        return mBaseView;
    }
}

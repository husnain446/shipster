package com.byteshaft.shipster.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Spinner;

import com.byteshaft.shipster.R;

public class ProhibitedShipments extends Fragment implements View.OnClickListener {

    private View mBaseView;
    private Spinner mSpinner;
    private Button mApplyButton;
    private Button mSaveButton;

    // checkboxes
    private CheckBox mAllShipmentsCheckbox;
    private CheckBox mFragileCheckbox;
    private CheckBox mInsuranceCheckbox;
    private CheckBox mShoeBOxCheckbox;
    private CheckBox mLargProductBox;
    private CheckBox mExtraSaftyCheckbox;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mBaseView = inflater.inflate(R.layout.prohibited_shipments, container, false);

        mAllShipmentsCheckbox = (CheckBox) mBaseView.findViewById(R.id.all_shipments_checkbox);
        mFragileCheckbox = (CheckBox) mBaseView.findViewById(R.id.fragile_sticker_checkbox);
        mInsuranceCheckbox = (CheckBox) mBaseView.findViewById(R.id.include_insurance_checkbox);
        mShoeBOxCheckbox = (CheckBox) mBaseView.findViewById(R.id.shoes_checkbox);
        mLargProductBox = (CheckBox) mBaseView.findViewById(R.id.larg_product_box_checkbox);
        mExtraSaftyCheckbox = (CheckBox) mBaseView.findViewById(R.id.extra_packing_material_checkbox);

        mSpinner = (Spinner) mBaseView.findViewById(R.id.items_per_page_spinner);
        mApplyButton = (Button) mBaseView.findViewById(R.id.button_apply);
        mSaveButton = (Button) mBaseView.findViewById(R.id.button_save);
        mApplyButton.setOnClickListener(this);
        mSaveButton.setOnClickListener(this);
        return mBaseView;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_apply:
                // TODO: 31/08/2016 apply button
                System.out.println("Apply Button" + " " +
                        mAllShipmentsCheckbox.isChecked());
                break;
            case R.id.button_save:
                // TODO: 31/08/2016 Save button
                System.out.println("Save button");
                break;
        }
    }
}

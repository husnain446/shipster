package com.byteshaft.shipster.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.byteshaft.shipster.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.zip.Inflater;

public class Account extends Fragment {

    private View mBaseView;
    private ListView mListView;
    private ArrayList<JSONObject> arrayList;
    private ArrayList<String> keysList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mBaseView = inflater.inflate(R.layout.account, container, false);
        mListView = (ListView) mBaseView.findViewById(R.id.listview);
        arrayList = new ArrayList<>();
        keysList = new ArrayList<>();
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("Customer#:", "103654");
            arrayList.add(jsonObject);
            jsonObject.put("First Name:", "husnain");
            arrayList.add(jsonObject);
            
            jsonObject.put("Last Name:", "hussi");
            arrayList.add(jsonObject);
            
            jsonObject.put("Gender:", "male");
            arrayList.add(jsonObject);
            
            jsonObject.put("City:", "multan");
            arrayList.add(jsonObject);
            
            jsonObject.put("Status:", "nothing");
            arrayList.add(jsonObject);
            
            jsonObject.put("Zip:", "60000");
            arrayList.add(jsonObject);
            
            jsonObject.put("Country:", "pakistan");
            arrayList.add(jsonObject);
            
            jsonObject.put("Mobile:", "+92467664737");
            arrayList.add(jsonObject);
            
            jsonObject.put("Phone:", "+9246766");
            arrayList.add(jsonObject);
            
            jsonObject.put("Email:", "byteshaft@gmail.com");
            arrayList.add(jsonObject);
            
            jsonObject.put("Roles:", "basic Customer");
            arrayList.add(jsonObject);

        } catch (JSONException e) {
            e.printStackTrace();
        }
        Log.i("TAG", String.valueOf(arrayList));
        Iterator<String> iter = jsonObject.keys();
        while (iter.hasNext()) {
            String key = iter.next();
            keysList.add(key);
        }
        CustomAdapter adapter = new CustomAdapter(getContext(), R.layout.delegate_account_info,
                arrayList, keysList);
        mListView.setAdapter(adapter);
        return mBaseView;
    }

    class CustomAdapter extends ArrayAdapter<ArrayList<String>> {

        private ArrayList<JSONObject> arrayList;
        private ArrayList<String> keysList;

        public CustomAdapter(Context context, int resource, ArrayList<JSONObject> arrayList,
                             ArrayList<String> keyList) {
            super(context, resource);
            this.arrayList = arrayList;
            this.keysList = keyList;
        }

        @Override
        public View getView(int i, View convertView, ViewGroup viewGroup) {
            ViewHolder holder;
            if (convertView == null) {
                LayoutInflater layoutInflater = getActivity().getLayoutInflater();
                convertView = layoutInflater.inflate(R.layout.delegate_account_info, viewGroup, false);
                holder = new ViewHolder();
                holder.mInfoTextView = (TextView) convertView.findViewById(R.id.info_textView);
                holder.mNameTextView = (TextView) convertView.findViewById(R.id.name_textView);
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }
            holder.mNameTextView.setText(keysList.get(i));
            try {
                holder.mInfoTextView.setText(arrayList.get(i).getString(keysList.get(i)));
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return convertView;
        }

        @Override
        public int getCount() {
            return keysList.size();
        }
    }

    class ViewHolder {

        private TextView mNameTextView;
        private TextView mInfoTextView;
    }
}

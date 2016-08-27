package com.byteshaft.shipster;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Window;
import android.view.WindowManager;


public class SplashScreenActivity extends Activity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.spalsh_screen);
//        new Handler().postDelayed(new Runnable(){
//            @Override
//            public void run() {
//                /* Create an Intent that will start the Menu-Activity. */
//                Intent mainIntent = new Intent(SplashScreenActivity.this, MainActivity.class);
//                startActivity(mainIntent);
//            }
//        }, 2000);
    }
}

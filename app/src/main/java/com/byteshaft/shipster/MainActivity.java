package com.byteshaft.shipster;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.byteshaft.shipster.account.LoginActivity;
import com.byteshaft.shipster.fragments.Account;
import com.byteshaft.shipster.fragments.DashBoard;
import com.byteshaft.shipster.fragments.Membership;
import com.byteshaft.shipster.fragments.Orders;
import com.byteshaft.shipster.fragments.ProhibitedShipments;
import com.byteshaft.shipster.fragments.Repackages;
import com.byteshaft.shipster.fragments.RequestPictures;
import com.byteshaft.shipster.fragments.ResetPassword;
import com.byteshaft.shipster.fragments.Shiments;
import com.byteshaft.shipster.fragments.ShipmentHistory;
import com.byteshaft.shipster.fragments.UpdateProfile;
import com.byteshaft.shipster.utils.AppGlobals;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    public static MainActivity sInstance;
    private View headerView;
    private TextView headerText;


    public static MainActivity getInstance() {
        return sInstance;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        headerView = findViewById(R.id.header);
        headerText = (TextView) headerView.findViewById(R.id.header_text);
        sInstance = this;
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_dashboard) {

            loadFragment(new DashBoard());
            headerText.setText("DASHBOARD");
        } else if (id == R.id.nav_account) {
            loadFragment(new Account());
            headerText.setText("ACCOUNT");

        } else if (id == R.id.nav_membership) {
            loadFragment(new Membership());
            headerText.setText("MEMBERSHIP");

        } else if (id == R.id.nav_shipments) {
            loadFragment(new Shiments());
            headerText.setText("SHIPMENTS");

        } else if (id == R.id.nav_request_pictures) {
            loadFragment(new RequestPictures());
            headerText.setText("REQUEST PICTURES");

        } else if (id == R.id.nav_repackages) {
            loadFragment(new Repackages());
            headerText.setText("REPACKAGES");

        } else if (id == R.id.nav_orders) {
            loadFragment(new Orders());
            headerText.setText("ORDERS");

        } else if (id == R.id.nav_shipment_history) {
            loadFragment(new ShipmentHistory());
            headerText.setText("SHIPPING HISTORY");

        } else if (id == R.id.nav_prohibited_shipments) {
            loadFragment(new ProhibitedShipments());
            headerText.setText("PROHIBITED SHIPMENST");

        } else if (id == R.id.nav_update_profile) {
            loadFragment(new UpdateProfile());
            headerText.setText("UPDATE PROFILE");

        } else if (id == R.id.nav_reset_password) {
            loadFragment(new ResetPassword());
            headerText.setText("RESET PASSWORD");

        } else if (id == R.id.nav_logout) {
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
            alertDialogBuilder.setTitle("Confirmation");
            alertDialogBuilder.setMessage("Do you really want to logout?").setCancelable(false).setPositiveButton("Ok",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            SharedPreferences sharedpreferences = AppGlobals.getPreferenceManager();
                            SharedPreferences.Editor editor = sharedpreferences.edit();
                            editor.clear();
                            editor.commit();
                            finish();
                            startActivity(new Intent(getApplicationContext(), LoginActivity.class));
                        }
                    });
            alertDialogBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                }
            });
            AlertDialog alertDialog = alertDialogBuilder.create();
            alertDialog.show();

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public static void loadFragment(Fragment fragment) {
        FragmentTransaction tx = MainActivity.getInstance().getSupportFragmentManager().beginTransaction();
        tx.replace(R.id.container, fragment);
        tx.commit();
    }
}

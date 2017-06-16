package com.example.itp.sample_2;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    String currentFragment = null;
    Fragment fragmentName = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        if (savedInstanceState==null){
            navigateTo(0);
        }

        BottomNavigationView bottomNavigationView = (BottomNavigationView)
                findViewById(R.id.navigation);

        bottomNavigationView.setOnNavigationItemSelectedListener
                (new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        //Fragment selectedFragment = null;
                        switch (item.getItemId()) {
                            case R.id.action_item1:
                                //  selectedFragment = ItemOneFragment.newInstance();
                                Toast.makeText(MainActivity.this, "First", Toast.LENGTH_SHORT).show();
                                break;
                            case R.id.action_item2:
                                // selectedFragment = ItemTwoFragment.newInstance();
                                Toast.makeText(MainActivity.this, "2", Toast.LENGTH_SHORT).show();
                                break;
                            case R.id.action_item3:
                                // selectedFragment = ItemThreeFragment.newInstance();
                                Toast.makeText(MainActivity.this, "3", Toast.LENGTH_SHORT).show();
                                break;
                        }
                        return true;
                    }
                });




    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    public void navigateTo(int position) {
        String tag = this.getClass().toString();
        switch (position) {
            case 0: {
                if (!(new MainActivityFragment().getClass().toString())
                        .equalsIgnoreCase(currentFragment)) {
                    getSupportFragmentManager()
                            .beginTransaction()
                            .addToBackStack(null)
                            .replace(R.id.fragment,
                                    new MainActivityFragment(), tag).commit();
                } else {
                    getSupportFragmentManager().popBackStack();
                    getSupportFragmentManager()
                            .beginTransaction()
                            .addToBackStack(null)
                            .replace(R.id.fragment,
                                    new MainActivityFragment(), tag).commit();
                }
                currentFragment = new MainActivityFragment().getClass().toString();

            }

        }
    }

    //Changing fragment
    public void changeFragment(Fragment nextFragment, boolean addToBackstack) {

        int containerId = R.id.fragment;

        FragmentManager fragmentManager = getSupportFragmentManager();
        final FragmentTransaction transaction = fragmentManager
                .beginTransaction();
        if (fragmentManager.findFragmentById(containerId) != null) {
            fragmentName = fragmentManager.findFragmentById(containerId);
        }
        transaction.replace(containerId, nextFragment);
        transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        if (addToBackstack == true) {
            transaction.addToBackStack(fragmentName.getClass().getName());
        }
        currentFragment = nextFragment.getClass().toString();
        transaction.commit();
    }


}

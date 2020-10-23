package com.example.recyclerviewhomework.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.widget.Toast;

import com.example.recyclerviewhomework.R;
import com.example.recyclerviewhomework.fragments.NumbersListFragment;

public class MainActivity extends AppCompatActivity implements ActivityWithSomeFragments {
    private static final long DOUBLE_CLICK_TO_EXIT_TIME = 2000;
    public long lastBackPressedTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            setFragment(new NumbersListFragment(), null);
        }
    }

    @Override
    public void setFragment(Fragment fragment, Bundle args) {
        getSupportFragmentManager().
                beginTransaction().
                addToBackStack(fragment.toString()).
                replace(R.id.container, fragment, fragment.toString()).
                commit();
        fragment.setArguments(args);
    }

    @Override
    public void onBackPressed() {
        if (getSupportFragmentManager().getBackStackEntryCount() > 1) {
            getSupportFragmentManager().popBackStack();
        }
        if (getSupportFragmentManager().getBackStackEntryCount() == 1) {
            if (lastBackPressedTime + DOUBLE_CLICK_TO_EXIT_TIME > System.currentTimeMillis()) {
                super.onBackPressed();
            } else {
                Toast.makeText(getBaseContext(), R.string.press_again_to_exit, Toast.LENGTH_SHORT).show();
            }
            lastBackPressedTime = System.currentTimeMillis();
        }
        if (getSupportFragmentManager().getBackStackEntryCount() == 0) {
            finishAndRemoveTask();
        }
    }
}
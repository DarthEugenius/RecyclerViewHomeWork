package com.example.recyclerviewhomework.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.widget.Toast;

import com.example.recyclerviewhomework.R;
import com.example.recyclerviewhomework.fragments.NumbersListFragment;
import com.example.recyclerviewhomework.models.NumberModel;

public class MainActivity extends AppCompatActivity {
    private static long lastBackPressedTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            setFragment(new NumbersListFragment(), null);
        }
    }

    public void setFragment(Fragment fragment, NumberModel numberModel) {

        getSupportFragmentManager().
                beginTransaction().
                addToBackStack(fragment.toString()).
                replace(R.id.container, fragment, fragment.toString()).
                commit();
        Log.d("---------", "---------: "+getSupportFragmentManager().getBackStackEntryCount());
        if (numberModel != null) {
            Bundle args = new Bundle();
            args.putString("currentNumberKey", numberModel.getNumber());
            args.putInt("currentColor", numberModel.getColor());
            fragment.setArguments(args);
        }
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d("MAIN ACTIVITY", "onSaveInstanceState: ");
    }

    @Override
    public void onBackPressed() {


        if (getSupportFragmentManager().getBackStackEntryCount() > 1) {
            getSupportFragmentManager().popBackStack();
        }
        if (getSupportFragmentManager().getBackStackEntryCount() == 1) {
            if (lastBackPressedTime + 2000 > System.currentTimeMillis()) {
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

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState, @NonNull PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);


    }
}
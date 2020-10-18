package com.example.recyclerviewhomework.fragments;

import android.content.res.Configuration;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.recyclerviewhomework.Constants;
import com.example.recyclerviewhomework.R;
import com.example.recyclerviewhomework.activities.MainActivity;
import com.example.recyclerviewhomework.adapters.NumbersListAdapter;


public class NumbersListFragment extends Fragment {
    private final String amountOfElementsKey = "AmountOfNumbers";
    int amountOfElements;
    NumbersListAdapter numbersListAdapter;

    public NumbersListFragment() {
        // Required empty public constructor
    }

    public static NumbersListFragment newInstance() {
        return new NumbersListFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null) {
            amountOfElements = savedInstanceState.getInt(amountOfElementsKey, Constants.NUMBER_LIST_SIZE);
        } else {
            amountOfElements = Constants.NUMBER_LIST_SIZE;
        }
        numbersListAdapter = new NumbersListAdapter(amountOfElements, (MainActivity) this.getActivity());
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(amountOfElementsKey, numbersListAdapter.getItemCount());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_numbers_list, container, false);
        Log.d("NUMBERLISTFRAGMENT", "onCreateView: " + amountOfElements);
        RecyclerView numbersListRecyclerView = view.findViewById(R.id.numbersListRecyclerViewId);
        int orientation = this.getResources().getConfiguration().orientation;
        int spanCount = (orientation == Configuration.ORIENTATION_PORTRAIT) ? Constants.SPAN_COUNT_PORTRAIT : Constants.SPAN_COUNT_LANDSCAPE;
        numbersListRecyclerView.setLayoutManager(new GridLayoutManager(getContext(), spanCount));
        numbersListRecyclerView.setAdapter(numbersListAdapter);
        TextView addNumberToListButton = view.findViewById(R.id.addNumberToListButtonId);
        addNumberToListButton.setOnClickListener(v -> {
            numbersListAdapter.addElement();
            numbersListRecyclerView.smoothScrollToPosition(numbersListRecyclerView.getAdapter().getItemCount() - 1);
        });
        return view;
    }

}
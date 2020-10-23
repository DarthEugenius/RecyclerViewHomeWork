package com.example.recyclerviewhomework.fragments;

import android.content.res.Configuration;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.recyclerviewhomework.R;
import com.example.recyclerviewhomework.activities.ActivityWithSomeFragments;
import com.example.recyclerviewhomework.adapters.NumbersListAdapter;

public class NumbersListFragment extends Fragment {
    private static final String AMOUNT_OF_NUMBER_KEY = "AMOUNT_OF_NUMBER_KEY";
    private static final int NUMBER_LIST_SIZE = 100;
    private static final int SPAN_COUNT_PORTRAIT = 3;
    private static final int SPAN_COUNT_LANDSCAPE = 4;
    int amountOfElements;
    NumbersListAdapter numbersListAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null) {
            amountOfElements = savedInstanceState.getInt(AMOUNT_OF_NUMBER_KEY, NUMBER_LIST_SIZE);
        } else {
            amountOfElements = NUMBER_LIST_SIZE;
        }
        numbersListAdapter = new NumbersListAdapter(amountOfElements, (ActivityWithSomeFragments) this.getActivity());
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(AMOUNT_OF_NUMBER_KEY, numbersListAdapter.getItemCount());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_numbers_list, container, false);
        RecyclerView numbersListRecyclerView = view.findViewById(R.id.numbersListRecyclerViewId);
        int orientation = this.getResources().getConfiguration().orientation;
        int spanCount = (orientation == Configuration.ORIENTATION_PORTRAIT) ? SPAN_COUNT_PORTRAIT : SPAN_COUNT_LANDSCAPE;
        numbersListRecyclerView.setLayoutManager(new GridLayoutManager(getContext(), spanCount));
        numbersListRecyclerView.setAdapter(numbersListAdapter);
        TextView addNumberToListButton = view.findViewById(R.id.addNumberToListButtonId);
        addNumberToListButton.setOnClickListener(v -> {
            numbersListAdapter.addElement();
            numbersListRecyclerView.smoothScrollToPosition(numbersListAdapter.getItemCount() - 1);
        });
        return view;
    }

}
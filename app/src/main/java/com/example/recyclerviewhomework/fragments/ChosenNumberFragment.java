package com.example.recyclerviewhomework.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.recyclerviewhomework.R;

public class ChosenNumberFragment extends Fragment {
    public static final String CURRENT_NUMBER_KEY = "CURRENT_NUMBER_KEY";
    public static final String CURRENT_COLOR_KEY = "CURRENT_COLOR_KEY";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_chosen_number, container, false);
        TextView chosenNumberTextView = view.findViewById(R.id.chosenNumberTextView);
        if (getArguments() != null && getActivity() != null) {
            chosenNumberTextView.setTextColor(getActivity().getResources().getColor(getArguments().getInt(CURRENT_COLOR_KEY)));
            chosenNumberTextView.setText(getArguments().getString(CURRENT_NUMBER_KEY));
        }
        return view;
    }
}
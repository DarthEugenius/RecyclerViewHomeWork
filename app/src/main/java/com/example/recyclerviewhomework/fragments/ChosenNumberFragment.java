package com.example.recyclerviewhomework.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.recyclerviewhomework.R;

public class ChosenNumberFragment extends Fragment {

    public ChosenNumberFragment() {

    }

    public static ChosenNumberFragment newInstance(String param1, String param2) {
        ChosenNumberFragment fragment = new ChosenNumberFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_chosen_number, container, false);
        TextView chosenNumberTextView = view.findViewById(R.id.chosenNumberTextView);
        chosenNumberTextView.setTextColor(getActivity().getResources().getColor(getArguments().getInt("currentColor")));
        chosenNumberTextView.setText(getArguments().getString("currentNumberKey"));
        return view;
    }

}
package com.example.recyclerviewhomework.adapters;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerviewhomework.R;
import com.example.recyclerviewhomework.activities.ActivityWithSomeFragments;
import com.example.recyclerviewhomework.data.NumbersListData;
import com.example.recyclerviewhomework.fragments.ChosenNumberFragment;
import com.example.recyclerviewhomework.models.NumberEntity;

public class NumbersListAdapter extends RecyclerView.Adapter<NumbersListAdapter.NumberListViewHolder> {
    public static final String CURRENT_NUMBER_KEY = "CURRENT_NUMBER_KEY";
    public static final String CURRENT_COLOR_KEY = "CURRENT_COLOR_KEY";
    NumbersListData numbersListData;
    ActivityWithSomeFragments activityWithSomeFragments;

    public NumbersListAdapter(int amountOfElements, ActivityWithSomeFragments activityWithSomeFragments) {
        this.numbersListData = new NumbersListData(amountOfElements);
        this.activityWithSomeFragments = activityWithSomeFragments;
    }

    @NonNull
    @Override
    public NumberListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.sample_number_view, parent, false);
        return new NumberListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NumberListViewHolder holder, int position) {
        NumberEntity currentNumber = numbersListData.getData().get(position);
        holder.numberTextView.setText(currentNumber.getNumber());
        holder.numberTextView.setTextColor(((Context) activityWithSomeFragments).getResources().getColor(currentNumber.getColor()));
        holder.itemView.setOnClickListener(v -> {
            Bundle args = new Bundle();
            args.putString(CURRENT_NUMBER_KEY, currentNumber.getNumber());
            args.putInt(CURRENT_COLOR_KEY, currentNumber.getColor());
            activityWithSomeFragments.setFragment(new ChosenNumberFragment(), args);
        });
    }

    @Override
    public int getItemCount() {
        return numbersListData.getData().size();
    }

    public void addElement() {
        numbersListData.addElement();
        this.notifyItemInserted(getItemCount());
    }

    public static class NumberListViewHolder extends RecyclerView.ViewHolder {
        public final TextView numberTextView;

        public NumberListViewHolder(@NonNull View itemView) {
            super(itemView);
            numberTextView = itemView.findViewById(R.id.numberTextView);
        }
    }
}

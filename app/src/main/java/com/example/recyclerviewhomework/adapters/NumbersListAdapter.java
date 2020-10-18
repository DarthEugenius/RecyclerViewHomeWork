package com.example.recyclerviewhomework.adapters;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;

import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerviewhomework.R;
import com.example.recyclerviewhomework.activities.MainActivity;
import com.example.recyclerviewhomework.data.NumbersListData;
import com.example.recyclerviewhomework.fragments.ChosenNumberFragment;
import com.example.recyclerviewhomework.models.NumberModel;


public class NumbersListAdapter extends RecyclerView.Adapter<NumbersListAdapter.NumberListViewHolder>{
    NumbersListData numbersListData;
    MainActivity mainActivity;

    public NumbersListAdapter(int amountOfNumbers, MainActivity mainActivity) {
        this.numbersListData = new NumbersListData(amountOfNumbers);
        this.mainActivity = (MainActivity) mainActivity;
    }

    @NonNull
    @Override
    public NumberListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.sample_number_view, parent, false);
        return new NumberListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NumberListViewHolder holder, int position) {
        NumberModel currentNumber = numbersListData.getData().get(position);
        holder.numberTextView.setText(currentNumber.getNumber());
        holder.numberTextView.setTextColor(mainActivity.getResources().getColor(currentNumber.getColor()));
        holder.itemView.setOnClickListener(v -> mainActivity.setFragment(new ChosenNumberFragment(), currentNumber));
    }

    @Override
    public int getItemCount() {
        return numbersListData.getData().size();
    }

    public static class NumberListViewHolder extends RecyclerView.ViewHolder {

        public final TextView numberTextView;

        public NumberListViewHolder(@NonNull View itemView) {
            super(itemView);
            numberTextView = itemView.findViewById(R.id.numberTextView);
        }

    }
    public void addElement(){
        numbersListData.addElement();
        this.notifyDataSetChanged();
    }
}

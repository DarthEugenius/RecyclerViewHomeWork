package com.example.recyclerviewhomework.models;

import com.example.recyclerviewhomework.R;

public class NumberModel {
    String number;

    int color;

    public final int evenNumbersColor = R.color.even_numbers_color;
    public final int oddNumbersColor = R.color.odd_numbers_color;

    public NumberModel(int number) {
        this.number = String.valueOf(number);
        if (number % 2 == 0) {
            this.color = evenNumbersColor;
        } else {
            this.color = oddNumbersColor;
        }
    }

    public String getNumber() {
        return number;
    }

    public int getColor() {
        return color;
    }
}

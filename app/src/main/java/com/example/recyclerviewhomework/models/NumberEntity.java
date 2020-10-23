package com.example.recyclerviewhomework.models;

import com.example.recyclerviewhomework.R;

public class NumberEntity {
    String number;
    int color;

    public static final int EVEN_NUMBERS_COLOR = R.color.even_numbers_color;
    public static final int ODD_NUMBERS_COLOR = R.color.odd_numbers_color;

    public NumberEntity(int number) {
        this.number = String.valueOf(number);
        if (number % 2 == 0) {
            this.color = EVEN_NUMBERS_COLOR;
        } else {
            this.color = ODD_NUMBERS_COLOR;
        }
    }

    public String getNumber() {
        return number;
    }

    public int getColor() {
        return color;
    }
}

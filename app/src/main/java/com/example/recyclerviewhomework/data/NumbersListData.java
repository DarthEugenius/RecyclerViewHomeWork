package com.example.recyclerviewhomework.data;

import com.example.recyclerviewhomework.Constants;
import com.example.recyclerviewhomework.models.NumberModel;

import java.util.ArrayList;
import java.util.List;

public class NumbersListData {
    private final List<NumberModel> list;

    public NumbersListData() {
        list = new ArrayList<>();
        for (int i = 1; i <= Constants.NUMBER_LIST_SIZE; i++) {
            list.add(new NumberModel(i));
        }
    }

    public NumbersListData(int n) {
        list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            list.add(new NumberModel(i));
        }
    }

    public List<NumberModel> getData() {
        return list;
    }
    public void addElement(){
        list.add(new NumberModel(list.size()+1));
    }
}

package com.example.recyclerviewhomework.data;

import com.example.recyclerviewhomework.models.NumberEntity;

import java.util.ArrayList;
import java.util.List;

public class NumbersListData {
    private final List<NumberEntity> list;

    public NumbersListData(int n) {
        list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            list.add(new NumberEntity(i));
        }
    }

    public List<NumberEntity> getData() {
        return list;
    }

    public void addElement() {
        list.add(new NumberEntity(list.size() + 1));
    }
}

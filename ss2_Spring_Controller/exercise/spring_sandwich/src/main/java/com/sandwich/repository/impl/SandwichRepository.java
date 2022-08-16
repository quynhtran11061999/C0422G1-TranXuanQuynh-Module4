package com.sandwich.repository.impl;

import com.sandwich.repository.ISandwichRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class SandwichRepository implements ISandwichRepository {

    private static List<String> stringList = new ArrayList<>();

    static {
        stringList.add("lettuce");
        stringList.add("tomato");
        stringList.add("mustard");
        stringList.add("sprouts");
    }

    @Override
    public List<String> findAll() {
        return stringList;
    }
}

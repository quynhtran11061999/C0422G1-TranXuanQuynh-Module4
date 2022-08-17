package com.medical_declaration.repository.impl;

import com.medical_declaration.repository.IMedicalRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MedicalRepository implements IMedicalRepository {
    private static List<String> gender = new ArrayList<>();
    private static List<String> nationality = new ArrayList<>();
    private static List<String> vehicle = new ArrayList<>();
    private static List<String> day = new ArrayList<>();
    private static List<String> month = new ArrayList<>();
    private static List<String> year = new ArrayList<>();

    static {

        gender.add("Nam");
        gender.add("Nữ");

        nationality.add("Việt Nam");
        nationality.add("Nhật Bản");
        nationality.add("Hàn Quốc");
        nationality.add("Mỹ");

        vehicle.add("Tàu bay");
        vehicle.add("Tàu thuyền");
        vehicle.add("Ô tô");
        vehicle.add("Khác(Ghi rõ)");

        for (int i = 1; i <32 ; i++) {
            day.add(String.valueOf(i));
        }

        for (int i = 0; i <13 ; i++) {
            month.add(String.valueOf(i));
        }

        for (int i = 1990; i <2023 ; i++) {
            year.add(String.valueOf(i));
        }
    }

    @Override
    public List<String> gender() {
        return gender;
    }

    @Override
    public List<String> nationality() {
        return nationality;
    }

    @Override
    public List<String> vehicle() {
        return vehicle;
    }

    @Override
    public List<String> day() {
        return day;
    }

    @Override
    public List<String> month() {
        return month;
    }

    @Override
    public List<String> year() {
        return year;
    }
}

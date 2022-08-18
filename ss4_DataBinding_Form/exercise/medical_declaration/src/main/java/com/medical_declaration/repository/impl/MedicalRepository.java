package com.medical_declaration.repository.impl;

import com.medical_declaration.model.Medical;
import com.medical_declaration.repository.IMedicalRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MedicalRepository implements IMedicalRepository {
    private static List<Medical> medicals = new ArrayList<>();
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

        for (int i = 1; i < 32; i++) {
            day.add(String.valueOf(i));
        }

        for (int i = 1; i < 13; i++) {
            month.add(String.valueOf(i));
        }

        for (int i = 1990; i < 2023; i++) {
            year.add(String.valueOf(i));
        }
    }

    @Override
    public List<Medical> displayList() {
        return medicals;
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

    @Override
    public Medical findById(int id) {
        for (Medical medical : medicals) {
            if (medical.getId() == id) {
                return medical;
            }
        }
        return null;
    }

    @Override
    public void add(Medical medical) {
        int id = (int) (Math.random() * 100);
        medical.setId(id);
        medicals.add(medical);
    }

    @Override
    public void update(int id, Medical medical) {
        for (Medical medical1 : medicals) {
            if (medical1.getId() == id) {
                medical1.setName(medical.getName());
                medical1.setYearOfBirth(medical.getYearOfBirth());
                medical1.setGender(medical.getGender());
                medical1.setNationality(medical.getNationality());
                medical1.setIdCard(medical.getIdCard());
                medical1.setVehicle(medical.getVehicle());
                medical1.setVehicleNumber(medical.getVehicleNumber());
                medical1.setSeats(medical.getSeats());
                medical1.setStartDay(medical.getStartDay());
                medical1.setStartMonth(medical.getStartMonth());
                medical1.setStartYear(medical.getStartYear());
                medical1.setEndDay(medical.getEndDay());
                medical1.setEndMonth(medical.getEndMonth());
                medical1.setEndYear(medical.getEndYear());
                medical1.setRoute(medical.getRoute());
            }
        }
    }
}

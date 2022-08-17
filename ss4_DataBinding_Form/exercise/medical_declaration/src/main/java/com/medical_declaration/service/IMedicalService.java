package com.medical_declaration.service;

import com.medical_declaration.model.Medical;

import java.util.List;

public interface IMedicalService {
    List<Medical> displayList();

    List<String> gender();

    List<String> nationality();

    List<String> vehicle();

    List<String> day();

    List<String> month();

    List<String> year();

    Medical findById(int id);

    void add(Medical medical);

    void update(int id, Medical medical);
}

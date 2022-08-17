package com.medical_declaration.service;

import java.util.List;

public interface IMedicalService {
    List<String> gender();
    List<String> nationality();
    List<String> vehicle();
    List<String> day();
    List<String> month();
    List<String> year();
}

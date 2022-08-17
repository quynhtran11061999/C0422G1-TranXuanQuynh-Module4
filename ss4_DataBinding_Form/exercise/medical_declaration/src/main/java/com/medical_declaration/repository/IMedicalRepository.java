package com.medical_declaration.repository;

import java.util.List;

public interface IMedicalRepository {
    List<String> gender();
    List<String> nationality();
    List<String> vehicle();
    List<String> day();
    List<String> month();
    List<String> year();
}

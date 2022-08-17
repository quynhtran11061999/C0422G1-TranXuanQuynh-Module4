package com.medical_declaration.service.impl;

import com.medical_declaration.repository.IMedicalRepository;
import com.medical_declaration.service.IMedicalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicalService implements IMedicalService {

    @Autowired
    private IMedicalRepository iMedicalRepository;

    @Override
    public List<String> gender() {
        return iMedicalRepository.gender();
    }

    @Override
    public List<String> nationality() {
        return iMedicalRepository.nationality();
    }

    @Override
    public List<String> vehicle() {
        return iMedicalRepository.vehicle();
    }

    @Override
    public List<String> day() {
        return iMedicalRepository.day();
    }

    @Override
    public List<String> month() {
        return iMedicalRepository.month();
    }

    @Override
    public List<String> year() {
        return iMedicalRepository.year();
    }

}

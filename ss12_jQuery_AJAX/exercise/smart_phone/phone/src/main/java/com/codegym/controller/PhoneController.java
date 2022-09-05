package com.codegym.controller;

import com.codegym.model.Phone;
import com.codegym.service.IPhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping(value = "/phoneRest")
public class PhoneController {
    @Autowired
    private IPhoneService iPhoneService;

    @GetMapping(value = "/list")
    public ResponseEntity<Page<Phone>> goList(@PageableDefault(size = 5) Pageable pageable) {
        Page<Phone> phonePage = this.iPhoneService.findAll(pageable);
        if (!phonePage.hasContent()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(phonePage, HttpStatus.OK);
    }

    @PostMapping(value = "/create")
    public ResponseEntity<Void> createPhone(@RequestBody Phone phone){
        this.iPhoneService.save(phone);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @PostMapping("/delete/{id}")
    public ResponseEntity<Void> goDelete(@PathVariable Integer id) {
        iPhoneService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/update/{id}")
    public ResponseEntity<?> goUpdate(@PathVariable Integer id) {
        Phone phone = iPhoneService.findById(Integer.valueOf(id));
        return new ResponseEntity<>(phone, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Phone> update(@RequestBody Phone phone, @RequestParam Integer id) {
        phone.setId(phone.getId());
        iPhoneService.save(phone);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
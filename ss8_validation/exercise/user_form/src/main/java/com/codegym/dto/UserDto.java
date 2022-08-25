package com.codegym.dto;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.time.Period;

public class UserDto implements Validator {
    @NotBlank(message = "Vui lòng nhập vào!!!")
    @Size(min = 5, max = 45)
    @Pattern(regexp = "[A-Za-z ]+", message = "Nhập sai định dạng. Vui lòng nhập lại!!!")
    private String firstName;

    @NotBlank(message = "Vui lòng nhập vào!!!")
    @Size(min = 5, max = 45)
    @Pattern(regexp = "[A-Za-z ]+", message = "Nhập sai định dạng. Vui lòng nhập lại!!!")
    private String lastName;

    @NotBlank(message = "Vui lòng nhập vào!!!")
    @Pattern(regexp = "(09)[0-9]{8}", message = "Nhập sai định dạng. Vui lòng nhập lại!!!")
    private String phoneNumber;

    @NotBlank(message = "Vui lòng nhập vào!!!")
    @DateTimeFormat
    private String age;

    @NotBlank(message = "Vui lòng nhập vào!!!")
    @Email
    private String email;

    public UserDto() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        UserDto userDto = (UserDto) target;
        String ageVal = userDto.getAge();
        if (age != null) {
            LocalDate localDate = LocalDate.parse(ageVal);
            Period period = Period.between(localDate, LocalDate.now());
            if (period.getYears() < 18) {
                errors.rejectValue("age", "add.age", "Phải lớn hơn hoặc bằng 18 tuổi!!!");
            }
        }
    }
}

package com.codegym.dto;


import com.codegym.model.customer.CustomerType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDto implements Validator {
    @NotBlank(message = "Vui lòng nhập vào!!!")
    @Pattern(regexp = "[A-Za-z ]+", message = "Nhập sai định dạng. Vui lòng nhập lại!!!")
    private String name;

    @NotBlank(message = "Vui lòng nhập vào!!!")
    private String dayOfBirth;

    @NotBlank(message = "Vui lòng nhập vào!!!")
    @Pattern(regexp = "^[0-9]{9}|[0-9]{12}$",message = "Nhập sai định dạng. Vui lòng nhập lại!!!")
    private String idCard;

    @NotBlank(message = "Vui lòng nhập vào!!!")
    @Pattern(regexp = "^((090)|(091)|(\\\\(84\\\\)\\\\+90)|(\\\\(84\\\\)\\\\+91))[0-9]{7}$",message = "Nhập sai định dạng. Vui lòng nhập lại!!!")
    private String phoneNumber;

    @Email(message = "Nhập sai định dạng. Vui lòng nhập lại!!!")
    @NotBlank(message = "Vui lòng nhập vào!!!")
    private String email;

    @NotBlank(message = "Vui lòng nhập vào!!!")
    private String address;

    private CustomerType customerType;

    private Boolean gender;

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}

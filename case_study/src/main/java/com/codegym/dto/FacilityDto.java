package com.codegym.dto;

import com.codegym.model.facility.FacilityType;
import com.codegym.model.facility.RentType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FacilityDto implements Validator {
    private int idService;

    @NotBlank(message = "Vui lòng nhập vào!!!")
    @Pattern(regexp = "[A-Za-z ]+", message = "Nhập sai định dạng. Vui lòng nhập lại!!!")
    private String name;

    @Min(value = 0,message = "Nhập sai định dạng. Vui lòng nhập lại!!!")
    private Integer area;

    @Min(value = 0,message = "Nhập sai định dạng. Vui lòng nhập lại!!!")
    private Double cost;

    @NotNull
    private Integer maxPeople;

    @NotNull
    private RentType rentTypeId;

    @NotNull
    private FacilityType serviceTypeId;

    @NotNull
    private String standardRoom;

    @NotNull
    private String descriptionOfAmenities;

    @Min(value = 0,message = "Nhập sai định dạng. Vui lòng nhập lại!!!")
    private Double poolArea;

    @Min(value = 0,message = "Nhập sai định dạng. Vui lòng nhập lại!!!")
    private Integer numberOfFloors;

    @NotNull
    private String freeService;

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
    }
}

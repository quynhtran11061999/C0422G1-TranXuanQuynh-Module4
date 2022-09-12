package com.codegym.model.facility;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "loai_dich_vu")
public class FacilityType {
    @Id
    @Column(name = "ma_loai_dich_vu")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int facilityTypeId;

    @Column(name = "ten_loai_dich_vu")
    private String facilityTypeName;

    @OneToMany(mappedBy = "serviceTypeId")
    private List<Facility> facilities;
}

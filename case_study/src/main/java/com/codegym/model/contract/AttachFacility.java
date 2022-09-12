package com.codegym.model.contract;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
@Table(name = "dich_vu_di_kem")
public class AttachFacility {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ma_dich_vu_di_kem")
    private Integer idAttachFacility;

    @Column(name = "ten_dich_vu_di_kem")
    private String nameAttachFacility;

    @Column(name = "gia")
    private Double cost;

    @Column(name = "don_vi")
    private String unit;

    @Column(name = "trang_thai")
    private String status;

    @JsonBackReference
    @OneToMany(mappedBy = "attachFacility")
    List<ContractDetail> contractDetails;
}

package com.codegym.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String categoryName;

    @OneToMany(mappedBy = "category")
    private List<Blog> blogs;
}

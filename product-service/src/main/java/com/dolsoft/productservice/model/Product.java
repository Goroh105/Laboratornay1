package com.dolsoft.productservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;

@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor(force = true)
public class Product extends RepresentationModel<Product> implements Serializable {

    private static final long serialVersionUID = 1L;

    private int id;
    private String name;        // Наименование
    private String size;        // Размер
    private double weight;      // Вес (кг)
}

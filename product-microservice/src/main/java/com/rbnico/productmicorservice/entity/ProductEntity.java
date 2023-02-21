package com.rbnico.productmicorservice.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document( value = "product" )
@NoArgsConstructor
@AllArgsConstructor
public class ProductEntity {

    @Id
    private Integer id;
    private String name;
    private String description;
    private Integer price;

}

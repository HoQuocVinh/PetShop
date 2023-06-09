package com.hcmute.vinh19110318.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "products")
public class Product extends AbstractEntity{
    private String id;
    private String productName;
    private String description;
    private double  price;
    private String categoryId;
}

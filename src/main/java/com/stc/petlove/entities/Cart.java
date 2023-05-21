package com.stc.petlove.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@NoArgsConstructor
@Document(collection = "carts")
public class Cart extends AbstractEntity{
    @Id
    private String id;
    private String userId;
    private List<String> productIds;
}

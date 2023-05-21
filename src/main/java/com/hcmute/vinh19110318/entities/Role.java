package com.hcmute.vinh19110318.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "role")
public class Role extends AbstractEntity{
    @Id
    private String id;
    private String roleName;
}

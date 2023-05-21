package com.stc.petlove.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "user")
public class User extends AbstractEntity{

    @Id
    private String id;
    private String userName;
    @NotBlank
    private String email;
    private String password;
    private String address;
    private String fullName;
    private Set<Role> roles;
}

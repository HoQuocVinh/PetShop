package com.hcmute.vinh19110318.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;
import java.util.Date;

@Data
@Document
public abstract class AbstractEntity {

    @CreatedDate
    @Field("createdDate")
    private Date createdDate = new Date();

    @LastModifiedDate
    @Field("lastModifiedDate")
    private Date lastModifiedDate = new Date();
}

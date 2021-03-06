package com.innocv.multibucket.domain;

import com.couchbase.client.java.repository.annotation.Field;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.couchbase.core.mapping.Document;

@Data
@Document
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class People {
    @Id
    private String id;
    @Field
    private String name;
    @Field
    private String surname;
}

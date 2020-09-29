package com.example.demo.enity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class City {

    @Id
    private String id;

    private String name;
    private String description;

}

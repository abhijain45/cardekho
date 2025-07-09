package com.cardekho.carsearch.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Document(indexName = "cars")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EsCar {
    @Id
    private String id;
    
    @Field(type = FieldType.Text)
    private String model;
    
    @Field(type = FieldType.Integer)
    private Integer year;
    
    @Field(type = FieldType.Keyword)
    private String color;
    
    @Field(type = FieldType.Double)
    private Double price;
    
    @Field(type = FieldType.Keyword)
    private String fuelType;
    
    @Field(type = FieldType.Keyword)
    private String transmission;
    
    @Field(type = FieldType.Long)
    private Long brandId;
    
    @Field(type = FieldType.Long)
    private Long manufacturerId;
}

package br.com.vechiato.donnacida_api.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@DynamoDbBean
public class Address {

    private String address;
    private String number;
    private String neighborhood;
    private String zipCode;
    private String city;
    private String state;
    private String country;
}

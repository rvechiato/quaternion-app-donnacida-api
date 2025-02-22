package br.com.vechiato.donnacida_api.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbAttribute;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbSortKey;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@DynamoDbBean
public class Caregiver {

    private String tenant;
    private String caregiverId;
    private String cpf;
    private String name;
    private String email;
    private String color;
    private String thumbnail;

    private Address address;

    @DynamoDbPartitionKey
    @DynamoDbAttribute("tenant")
    public String getTenant() {
        return tenant;
    }

    @DynamoDbSortKey
    @DynamoDbAttribute("caregiver_id")
    public String getCaregiverId() {
        return caregiverId;
    }

    @DynamoDbAttribute("address")
    public Address getAddress() {
        return address;
    }
}

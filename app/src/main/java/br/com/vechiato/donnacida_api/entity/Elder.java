package br.com.vechiato.donnacida_api.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbAttribute;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@DynamoDbBean
public class Elder {
    private String elderId;
    private String name;
    private String email;
    private String cellphone;

    @DynamoDbPartitionKey
    @DynamoDbAttribute("elder_id")
    public String getElderId() {
        return elderId;
    }
}

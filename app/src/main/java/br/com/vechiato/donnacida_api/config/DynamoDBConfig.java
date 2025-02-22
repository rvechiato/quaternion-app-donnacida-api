package br.com.vechiato.donnacida_api.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;


import java.net.URI;

@Configuration
public class DynamoDBConfig {

    @Value("${spring.data.dynamodb.host}")
    private String host;

    @Bean
    public DynamoDbClient dynamoDbClient() {
        return DynamoDbClient.builder()
                .endpointOverride(URI.create(host))
                .region(Region.SA_EAST_1)
                .build();
    }

}

package br.com.vechiato.donnacida_api.repository.impl;

import br.com.vechiato.donnacida_api.entity.Elder;
import br.com.vechiato.donnacida_api.repository.IEntityRepository;

import io.awspring.cloud.dynamodb.DynamoDbTemplate;
import org.springframework.stereotype.Repository;
import software.amazon.awssdk.enhanced.dynamodb.Key;

import java.util.Optional;
import java.util.UUID;

@Repository
public class ElderRepository implements IEntityRepository<Elder> {

    private final DynamoDbTemplate dynamoDbTemplate;

    public ElderRepository(DynamoDbTemplate dynamoDbTemplate) {
        this.dynamoDbTemplate = dynamoDbTemplate;
    }

    @Override
    public Optional<Elder> findById(String identification) {
        var entity = this.dynamoDbTemplate.load(Key.builder()
                .partitionValue(identification)
                .build(), Elder.class);

        return Optional.ofNullable(entity);
    }

    @Override
    public Optional<Elder> save(Elder entity) {
        entity.setElderId(ensureSetId(entity));
        var result = dynamoDbTemplate.save(entity);
        return Optional.of(result);
    }

    @Override
    public void delete(Elder entity) {
        dynamoDbTemplate.delete(entity);
    }

    @Override
    public String ensureSetId(Elder entity){
       return Optional.ofNullable(entity.getElderId())
                .orElseGet(() ->  UUID.randomUUID().toString());
    }
}

package br.com.vechiato.donnacida_api.repository.impl;

import br.com.vechiato.donnacida_api.entity.Caregiver;
import br.com.vechiato.donnacida_api.repository.IEntityRepository;
import io.awspring.cloud.dynamodb.DynamoDbTemplate;
import org.springframework.stereotype.Repository;
import software.amazon.awssdk.enhanced.dynamodb.Key;
import software.amazon.awssdk.enhanced.dynamodb.model.QueryConditional;
import software.amazon.awssdk.enhanced.dynamodb.model.QueryEnhancedRequest;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class CaregiverRepository implements IEntityRepository<Caregiver> {

    private final DynamoDbTemplate dynamoDbTemplate;

    public CaregiverRepository(DynamoDbTemplate dynamoDbTemplate) {
        this.dynamoDbTemplate = dynamoDbTemplate;
    }

    @Override
    public Optional<Caregiver> findById(String identification) {
        var entity = dynamoDbTemplate.load(Key.builder()
                .partitionValue(identification).build(), Caregiver.class);
        return Optional.ofNullable(entity);
    }

    @Override
    public Optional<Caregiver> save(Caregiver entity) {
        entity.setCaregiverId(ensureSetId(entity));
        return Optional.of(this.dynamoDbTemplate.save(entity));
    }

    @Override
    public void delete(Caregiver entity) {
        dynamoDbTemplate.delete(entity);

    }

    public List<Caregiver> findBytenant(String tenant){

        var key = Key.builder().partitionValue(tenant).build();
        var condition = QueryConditional.keyEqualTo(key);
        var query = QueryEnhancedRequest.builder().queryConditional(condition).build();

        var execution =  dynamoDbTemplate.query(query , Caregiver.class);
        var resultList = execution.items().stream().toList();

        return resultList.isEmpty()? Collections.emptyList() : resultList;

    }

    @Override
    public String ensureSetId(Caregiver entity) {
        return Optional.ofNullable(entity.getCaregiverId())
                .orElseGet(() -> UUID.randomUUID().toString());
    }
}

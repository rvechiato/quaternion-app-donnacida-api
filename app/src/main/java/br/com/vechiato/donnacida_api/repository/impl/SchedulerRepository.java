package br.com.vechiato.donnacida_api.repository.impl;

import br.com.vechiato.donnacida_api.entity.Scheduler;
import io.awspring.cloud.dynamodb.DynamoDbTemplate;
import org.springframework.stereotype.Repository;
import software.amazon.awssdk.enhanced.dynamodb.Expression;
import software.amazon.awssdk.enhanced.dynamodb.Key;
import software.amazon.awssdk.enhanced.dynamodb.model.QueryConditional;
import software.amazon.awssdk.enhanced.dynamodb.model.QueryEnhancedRequest;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;

import java.time.Instant;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public class SchedulerRepository  {

    private final DynamoDbTemplate dynamoDbTemplate;

    public SchedulerRepository(DynamoDbTemplate dynamoDbTemplate) {
        this.dynamoDbTemplate = dynamoDbTemplate;
    }

    // Salvar um agendamento no DynamoDB
    public Optional<Scheduler> save(Scheduler schedule) {
        return Optional.of(dynamoDbTemplate.save(schedule));
    }

    // Buscar agendamentos por caregiverId usando o GSI
    public List<Scheduler> findByPeriod(String tenant, Instant start, Instant end) {

        Map<String, AttributeValue> expressionValues = Map.ofEntries(
                Map.entry(":start", AttributeValue.builder().n(Long.toString(start.getEpochSecond())).build()),
                Map.entry(":end", AttributeValue.builder().n(Long.toString(end.getEpochSecond())).build())
        );

        Map<String, String> expressionNames = Map.of("#startDate", "startDate"); // Evita palavras reservadas


        Expression filterExpression = Expression.builder()
                .expression("#startDate BETWEEN :start AND :end")
                .expressionValues(expressionValues)
                .expressionNames(expressionNames)
                .build();

        // 🔹 Criar a query para o DynamoDB
        QueryEnhancedRequest query = QueryEnhancedRequest.builder()
                .queryConditional(QueryConditional.keyEqualTo(
                        Key.builder().partitionValue(tenant).build() // 🔥 Buscar por Tenant (PK)
                ))
                .filterExpression(filterExpression) // ✅ Agora usa um objeto Expression
                .build();

        // 🔹 Executar a consulta e retornar os resultados
        return dynamoDbTemplate.query(query, Scheduler.class)
                .items()
                .stream()
                .toList();
    }
}

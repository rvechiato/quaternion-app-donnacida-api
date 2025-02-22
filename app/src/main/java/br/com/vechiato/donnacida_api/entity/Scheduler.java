package br.com.vechiato.donnacida_api.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.*;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@DynamoDbBean
public class Scheduler {

    private String tenant;
    private String caregiverId;
    private LocalDate startAt;
    private LocalDate endAt;
    private String notes;

    @DynamoDbPartitionKey
    public String getTenant() {
        return tenant;
    }

    @DynamoDbSortKey
    @DynamoDbAttribute("start_at")
    public LocalDate getStartAt() {
        return startAt;
    }

    @DynamoDbSecondaryPartitionKey(indexNames = "schedule-index")
    @DynamoDbAttribute("caregiver_id")
    public String getCaregiverId() {
        return caregiverId;
    }

    @DynamoDbAttribute("end_at")
    public LocalDate getEndAt() {
        return endAt;
    }
}

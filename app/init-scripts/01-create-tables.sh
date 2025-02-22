#!/bin/bash

# Variables
DYNAMODB_ENDPOINT=http://localhost:4566
REGION=sa-east-1

# Aguarda o LocalStack iniciar completamente
echo "Aguardando LocalStack iniciar..."
until curl -s $DYNAMODB_ENDPOINT > /dev/null; do
    sleep 1
done

echo "LocalStack iniciado, criando tabelas..."

# Criando uma tabela de exemplo
aws dynamodb create-table \
    --table-name elder \
    --attribute-definitions AttributeName=elder_id,AttributeType=S \
    --key-schema AttributeName=elder_id,KeyType=HASH \
    --provisioned-throughput ReadCapacityUnits=5,WriteCapacityUnits=5 \
    --endpoint-url $DYNAMODB_ENDPOINT \
    --region $REGION

aws dynamodb create-table \
    --table-name caregiver \
    --attribute-definitions \
        AttributeName=tenant,AttributeType=S \
        AttributeName=caregiver_id,AttributeType=S \
    --key-schema \
        AttributeName=tenant,KeyType=HASH \
        AttributeName=caregiver_id,KeyType=RANGE \
    --provisioned-throughput ReadCapacityUnits=5,WriteCapacityUnits=5 \
    --endpoint-url $DYNAMODB_ENDPOINT \
    --region $REGION

aws dynamodb create-table \
    --table-name scheduler \
    --attribute-definitions \
        AttributeName=tenant,AttributeType=S \
        AttributeName=start_at,AttributeType=S \
        AttributeName=caregiver_id,AttributeType=S \
    --key-schema \
        AttributeName=tenant,KeyType=HASH \
        AttributeName=start_at,KeyType=RANGE \
    --billing-mode PAY_PER_REQUEST \
    --global-secondary-indexes \
        "IndexName=schedule-index,\
        KeySchema=[{AttributeName=caregiver_id,KeyType=HASH},{AttributeName=start_at,KeyType=RANGE}],\
        Projection={ProjectionType=ALL}" \
    --endpoint-url $DYNAMODB_ENDPOINT \
    --region $REGION

echo "Tabelas criadas com sucesso!"
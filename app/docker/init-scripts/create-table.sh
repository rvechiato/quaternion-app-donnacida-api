#!/bin/bash

set -x

# Nome da tabela
TABLE_NAME="Schedules"

# Região da AWS
AWS_REGION="sa-east-1"

awslocal dynamodb create-table \
    --table-name player_history \
    --attribute-definitions \
        AttributeName=username,AttributeType=S \
        AttributeName=game_id,AttributeType=S \
    --key-schema \
        AttributeName=username,KeyType=HASH \
        AttributeName=game_id,KeyType=RANGE \
    --provisioned-throughput \
        ReadCapacityUnits=5,WriteCapacityUnits=5 \
    --region sa-east-1

echo "#######################################################"
echo "Tabela 'GameScores' criada com sucesso no LocalStack!"
echo "#######################################################"
#!/usr/bin/env bash

# Create Pub/Sub topic using the emulator
sleep 10
curl -X PUT http://pubsub:8432/v1/projects/${PROJECT_ID}/topics/${TOPIC_NAME}

# Create a subscription under the previously created topic
SUBSCRIBER=$(echo ${USERNAME} | tr "[:upper:]" "[:lower:]")
QUALIFIED_TOPIC_NAME="projects/${PROJECT_ID}/topics/${TOPIC_NAME}"
curl -s -X PUT \
http://pubsub:8432/v1/projects/${PROJECT_ID}/subscriptions/${SUBSCRIPTION_NAME}-${SUBSCRIBER} \
-H 'content-type: application/json' \
--data '{"topic":"'"$QUALIFIED_TOPIC_NAME"'"}'
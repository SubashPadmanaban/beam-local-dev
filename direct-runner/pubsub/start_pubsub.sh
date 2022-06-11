#!/usr/bin/env bash

# Check user environment variable
if [[ -z "${PROJECT_ID}" ]]; then
  echo "Missing PROJECT_ID environment variable" >&2
  exit 1
fi

if [[ -z "${PUBSUB_EMULATOR_HOST}" ]]; then
  echo "Missing PUBSUB_EMULATOR_HOST environment variable" >&2
  exit 1
fi

# Start emulator
gcloud beta emulators pubsub start \
--data-dir=/opt/data \
--host-port=${PUBSUB_EMULATOR_HOST}

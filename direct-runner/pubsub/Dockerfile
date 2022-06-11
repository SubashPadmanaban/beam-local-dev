FROM gcr.io/google.com/cloudsdktool/google-cloud-cli:emulators

# Create volume to persist Pub/Sub data
VOLUME /opt/data

COPY ./start_pubsub.sh ./start_pubsub.sh
RUN ["chmod", "+x", "./start_pubsub.sh"]
ENTRYPOINT ["./start_pubsub.sh"]
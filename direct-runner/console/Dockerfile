FROM gcr.io/google.com/cloudsdktool/google-cloud-cli:emulators

COPY ./pubsub_init.sh ./pubsub_init.sh

RUN ["chmod", "+x", "./pubsub_init.sh"]
ENTRYPOINT ["./pubsub_init.sh"]
FROM gcr.io/google.com/cloudsdktool/google-cloud-cli:emulators

LABEL description="The Apache Beam Local environment Pubsub init container."

LABEL maintainer="Subash Padmanaban <subash@subashpadmanaban.com>"

COPY ./pubsub_init.sh ./pubsub_init.sh

RUN ["chmod", "+x", "./pubsub_init.sh"]
ENTRYPOINT ["./pubsub_init.sh"]
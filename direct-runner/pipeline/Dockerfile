FROM centos:7.8.2003

LABEL description="The Apache Beam Local environment main pipeline container."

LABEL maintainer="Subash Padmanaban <subash@subashpadmanaban.com>"

RUN yum install -y \
    java-11-openjdk-11.0.8.10-0.el7_8 \ 
    && yum clean all

RUN rm -rf /var/cache/yum

ADD build/libs/pipeline.jar /pipeline.jar

USER nobody

ENTRYPOINT [ "java", "-cp", "/pipeline.jar", "com.beamlocal.StreamPipeline" ]
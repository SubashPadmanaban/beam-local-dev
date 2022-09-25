package com.beamlocal.transforms;

import com.google.pubsub.v1.PubsubMessage;
import org.apache.beam.sdk.io.gcp.pubsub.PubsubIO;
import org.apache.beam.sdk.transforms.DoFn;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SimplePrintFn extends DoFn<PubsubMessage, String> {

    private static final Logger LOG = LoggerFactory.getLogger(SimplePrintFn.class);

    @ProcessElement
    public void processElement(@Element PubsubMessage message, OutputReceiver<String> receiver) {
        LOG.debug("Input Pub/Sub message is " + message.toString());
    }
}

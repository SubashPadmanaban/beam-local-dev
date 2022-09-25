package com.beamlocal.transforms;

import com.beamlocal.PubsubEvent;
import com.google.gson.Gson;
import org.apache.beam.sdk.io.gcp.pubsub.PubsubMessage;
import org.apache.beam.sdk.transforms.DoFn;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PubsubEventHandler extends DoFn<PubsubMessage, PubsubEvent> {

    private static final Logger LOG = LoggerFactory.getLogger(PubsubEventHandler.class);

    @ProcessElement
    public void processElement(@Element PubsubMessage message, OutputReceiver<PubsubEvent> receiver) {
        LOG.debug("Input Pub/Sub message is " + message.toString());
        PubsubEvent event = new PubsubEvent();
        try {
            Gson gson = new Gson();
            event = gson.fromJson(String.valueOf(message.getPayload()), PubsubEvent.class);
        } catch (Exception e) {
            LOG.debug("Error converting Pub/Sub message to PubsubEvent class." + e.toString());
        }
        receiver.output(event);
    }
}

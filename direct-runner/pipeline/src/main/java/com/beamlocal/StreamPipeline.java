package com.beamlocal;

import com.beamlocal.transforms.PubsubEventHandler;
import org.apache.beam.runners.dataflow.options.DataflowPipelineOptions;
import org.apache.beam.sdk.Pipeline;
import org.apache.beam.sdk.io.gcp.pubsub.PubsubIO;
import org.apache.beam.sdk.options.Description;
import org.apache.beam.sdk.options.PipelineOptionsFactory;
import org.apache.beam.sdk.transforms.ParDo;

public final class StreamPipeline {
    public static final String MESSAGE_ATTRIBUTE = "message_id";

    public static void main(String[] args) {

        var opts = PipelineOptionsFactory.fromArgs(args).withValidation().as(Options.class);
        var topciName = opts.getTopicName();
        var subscription = opts.getSubscriptionName();
        var pubsubRootUrl = opts.getPubsubRootUrl();

        var pipeline = Pipeline.create(opts);

        var pubsubEvents =
                pipeline
                    .apply(
                            "Read Pubsub",
                            PubsubIO.readMessagesWithAttributesAndMessageId()
                                    .fromSubscription(subscription)
                                    .withIdAttribute(MESSAGE_ATTRIBUTE))
                    .apply("Convert Pub/Sub to string", ParDo.of(new PubsubEventHandler()));

    }

    public interface Options extends DataflowPipelineOptions {
        @Description("Topic name for Pub/Sub source.")
        String getTopicName();

        void setTopicName(String value);

        @Description("Subscription name for Pub/Sub consumer.")
        String getSubscriptionName();

        void setSubscriptionName(String value);

        @Description("Pub/Sub root URL.")
        String getPubsubRootUrl();

        void setPubsubRootUrl(String value);
    }

}
package pipeline;

import org.apache.beam.runners.dataflow.options.DataflowPipelineOptions;
import org.apache.beam.sdk.Pipeline;
import org.apache.beam.sdk.options.Description;
import org.apache.beam.sdk.options.PipelineOptionsFactory;

public final class StreamingPipeline {
    public static void main(String[] args){
        var opts = PipelineOptionsFactory.fromArgs(args).withValidation().as(Options.class);
        var subscriptionName = opts.getSubscriptionName();
        var
        var pipeline = Pipeline.create(opts);
    }

    public interface Options extends DataflowPipelineOptions {
        @Description("Environment for streaming pipeline")
        String getEnvironment();

        @SuppressWarnings("unused")
        void setEnvironment(String environment);

        @Description("Name of Pub/Sub subscription")
        String getSubscriptionName();

        @SuppressWarnings("unused")
        void setSubscriptionName(String subscriptionName);

        @Description("Name of Pub/Sub topic")
        String getTopicName();

        @SuppressWarnings("unused")
        void setTopicName(String topicName);
    }
}
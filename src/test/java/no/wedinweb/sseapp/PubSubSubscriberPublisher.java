package no.wedinweb.sseapp;

import no.wedinweb.sseapp.pubsub.PubSub;
import no.wedinweb.sseapp.pubsub.Topic;

class PubSubSubscriberPublisher {

    private PubSub pubSub;

    PubSubSubscriberPublisher(PubSub pubSub) {
        this.pubSub = pubSub;
    }

    void publish(Topic topic, String message) {
        pubSub.publish(topic, message);
    }

}

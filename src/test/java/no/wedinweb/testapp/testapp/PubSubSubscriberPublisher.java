package no.wedinweb.testapp.testapp;

import no.wedinweb.testapp.pubsub.PubSub;
import no.wedinweb.testapp.pubsub.Topic;

class PubSubSubscriberPublisher {

    private PubSub pubSub;

    PubSubSubscriberPublisher(PubSub pubSub) {
        this.pubSub = pubSub;
    }

    void publish(Topic topic, String message) {
        pubSub.publish(topic, message);
    }

}

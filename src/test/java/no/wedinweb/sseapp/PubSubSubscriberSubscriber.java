package no.wedinweb.sseapp;

import no.wedinweb.sseapp.pubsub.PubSubSubscriber;
import no.wedinweb.sseapp.pubsub.PubSub;
import no.wedinweb.sseapp.pubsub.Topic;

class PubSubSubscriberSubscriber implements PubSubSubscriber {

    private PubSub pubSub;
    private String mymessage = "";

    PubSubSubscriberSubscriber(PubSub pubSub) {
        this.pubSub = pubSub;
    }

    void subscribe(Topic topic) {
        pubSub.subscribe(topic, this);
    }

    @Override
    public void receive(String message) {
        mymessage = message;
    }

    String getMymessage() {
        return mymessage;
    }
}

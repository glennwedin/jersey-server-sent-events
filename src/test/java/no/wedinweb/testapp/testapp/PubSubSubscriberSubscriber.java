package no.wedinweb.testapp.testapp;

import no.wedinweb.testapp.pubsub.PubSubSubscriber;
import no.wedinweb.testapp.pubsub.PubSub;
import no.wedinweb.testapp.pubsub.Topic;

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

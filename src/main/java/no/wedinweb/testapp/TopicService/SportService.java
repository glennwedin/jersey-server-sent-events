package no.wedinweb.testapp.TopicService;

import no.wedinweb.testapp.pubsub.PubSub;
import no.wedinweb.testapp.pubsub.PubSubSubscriber;
import no.wedinweb.testapp.pubsub.Topic;

public class SportService extends AbstractTopicService implements PubSubSubscriber {

    private String message;

    public SportService(PubSub pubSub) {
        super(pubSub);
        pubSub.subscribe(Topic.SPORT, this);
    }

    @Override
    public void receive(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public void setMessageEmpty() {
        message = "";
    }
}


package no.wedinweb.testapp.TopicService;

import no.wedinweb.testapp.pubsub.PubSub;
import no.wedinweb.testapp.pubsub.Topic;

public abstract class AbstractTopicService {

    private PubSub pubSub;

    protected AbstractTopicService(PubSub pubSub) {
        this.pubSub = pubSub;
    }

    public void publish(Topic topic, String message) {
        pubSub.publish(topic, message);
    }

    abstract public String getMessage();

    abstract public void setMessageEmpty();
}

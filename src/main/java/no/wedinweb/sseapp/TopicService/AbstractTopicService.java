package no.wedinweb.sseapp.TopicService;

import no.wedinweb.sseapp.pubsub.PubSub;
import no.wedinweb.sseapp.pubsub.Topic;

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

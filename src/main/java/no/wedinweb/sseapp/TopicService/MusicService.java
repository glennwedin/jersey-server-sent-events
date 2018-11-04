package no.wedinweb.sseapp.TopicService;

import no.wedinweb.sseapp.pubsub.PubSub;
import no.wedinweb.sseapp.pubsub.PubSubSubscriber;
import no.wedinweb.sseapp.pubsub.Topic;

public class MusicService extends AbstractTopicService implements PubSubSubscriber {

    private String message;

    public MusicService(PubSub pubSub) {
        super(pubSub);
        pubSub.subscribe(Topic.MUSIC, this);
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


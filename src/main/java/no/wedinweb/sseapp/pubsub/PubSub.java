package no.wedinweb.sseapp.pubsub;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PubSub {

    private HashMap<Topic, List<PubSubSubscriber>> messagelist = new HashMap<>();


    public void subscribe(Topic topic, PubSubSubscriber subscriber) {
        List<PubSubSubscriber> topics = messagelist.get(topic);
        if(topics == null) {
            topics = new ArrayList<>();
            messagelist.put(topic, topics);
        }
        topics.add(subscriber);
    }

    public void publish(Topic topic, String message) {
        List<PubSubSubscriber> topics = messagelist.get(topic);
        if(topics != null) {
            topics.forEach(t -> t.receive(message));
        }
    }


}

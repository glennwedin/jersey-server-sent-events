package no.wedinweb.sseapp;

import no.wedinweb.sseapp.pubsub.PubSub;
import no.wedinweb.sseapp.pubsub.Topic;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SseApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Test
	public void testPubSub() {
		PubSub pubSub = new PubSub();

		PubSubSubscriberSubscriber pubSubSubscriber = new PubSubSubscriberSubscriber(pubSub);
		pubSubSubscriber.subscribe(Topic.SPORT);

		PubSubSubscriberSubscriber musicPubSubSubscriber = new PubSubSubscriberSubscriber(pubSub);
		musicPubSubSubscriber.subscribe(Topic.MUSIC);

		PubSubSubscriberPublisher pubSubPublisher = new PubSubSubscriberPublisher(pubSub);
		pubSubPublisher.publish(Topic.MUSIC, "Dette er en musikk");

		assert(pubSubSubscriber.getMymessage()).contentEquals("");
		assert(musicPubSubSubscriber.getMymessage()).contentEquals("Dette er en musikk");

		pubSubPublisher.publish(Topic.SPORT, "Dette er sport");
		assert(pubSubSubscriber.getMymessage()).contentEquals("Dette er sport");


	}

}

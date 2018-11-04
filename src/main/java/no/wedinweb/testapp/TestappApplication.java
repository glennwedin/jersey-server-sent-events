package no.wedinweb.testapp;

import no.wedinweb.testapp.Event.EventResource;
import no.wedinweb.testapp.Stuff.StuffResource;
import no.wedinweb.testapp.TopicService.AbstractTopicService;
import no.wedinweb.testapp.TopicService.MusicService;
import no.wedinweb.testapp.TopicService.SportService;
import no.wedinweb.testapp.pubsub.PubSub;
import org.glassfish.hk2.utilities.binding.AbstractBinder;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TestappApplication extends ResourceConfig {

	public static void main(String[] args) {
		SpringApplication.run(TestappApplication.class, args);
	}

	public TestappApplication() {
		register(StuffResource.class);
		register(EventResource.class);
		register(CorsFilter.class);

		register(abstractBinder());

	}

	private AbstractBinder abstractBinder() {
		return new AbstractBinder() {
			@Override
			protected void configure() {
				PubSub pubSub = new PubSub();
				bind(new MusicService(pubSub)).to(AbstractTopicService.class);
				bind(new SportService(pubSub)).to(AbstractTopicService.class);
			}
		};
	}
}

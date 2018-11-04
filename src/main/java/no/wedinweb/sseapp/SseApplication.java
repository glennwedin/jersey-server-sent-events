package no.wedinweb.sseapp;

import no.wedinweb.sseapp.Event.EventResource;
import no.wedinweb.sseapp.Stuff.StuffResource;
import no.wedinweb.sseapp.TopicService.AbstractTopicService;
import no.wedinweb.sseapp.TopicService.MusicService;
import no.wedinweb.sseapp.TopicService.SportService;
import no.wedinweb.sseapp.pubsub.PubSub;
import org.glassfish.hk2.utilities.binding.AbstractBinder;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SseApplication extends ResourceConfig {

	public static void main(String[] args) {
		SpringApplication.run(SseApplication.class, args);
	}

	public SseApplication() {
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

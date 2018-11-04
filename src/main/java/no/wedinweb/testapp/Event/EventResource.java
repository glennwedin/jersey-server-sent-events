package no.wedinweb.testapp.Event;

import javax.inject.Inject;
import javax.ws.rs.*;

import no.wedinweb.testapp.TopicService.MusicService;
import no.wedinweb.testapp.TopicService.SportService;
import org.glassfish.jersey.media.sse.EventOutput;
import org.glassfish.jersey.media.sse.OutboundEvent;
import org.glassfish.jersey.media.sse.SseFeature;

import java.io.IOException;

@Path("event")
public class EventResource {

    @Inject
    private MusicService musicService;
    @Inject
    private SportService sportService;

    private static volatile EventOutput eventOutput = new EventOutput();

    @GET
    @Path("/")
    @Produces(SseFeature.SERVER_SENT_EVENTS)
    public EventOutput music() {
        final EventOutput seq = new EventOutput();

        new Thread(() -> {
            try {
                while(true) {
                    if (musicService.getMessage() != null) {
                        seq.write(new OutboundEvent.Builder().name("music")
                                .data(String.class, musicService.getMessage()).build());
                        musicService.setMessageEmpty();
                    }
                    if (sportService.getMessage() != null) {
                        seq.write(new OutboundEvent.Builder().name("sport")
                                .data(String.class, sportService.getMessage()).build());
                        sportService.setMessageEmpty();
                    }
                    seq.write(new OutboundEvent.Builder().name("domain-progress").data(String.class, "70%").build());
                    Thread.sleep(200);
                }
            } catch (final InterruptedException | IOException e) {
                // e.printStackTrace(); client broke connection... who cares
            }
        }).start();

        return seq;
    }

}

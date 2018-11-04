package no.wedinweb.testapp.Stuff;

import no.wedinweb.testapp.TopicService.AbstractTopicService;
import no.wedinweb.testapp.pubsub.Topic;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/")
public class StuffResource {

    @Inject
    private AbstractTopicService pubSub;

    @Path("/music")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String setMusic(@QueryParam("music") String message) {
        pubSub.publish(Topic.MUSIC, message);
        return "Ok";
    }

    @Path("/sport")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String setSport(@QueryParam("sport") String message) {
        pubSub.publish(Topic.SPORT, message);
        return "Ok";
    }
}

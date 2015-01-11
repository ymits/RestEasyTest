package my.cool.app;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/RESTEasyTest")
public class RestEasyTest {

    @GET
    @Path("/{param}")
    @Produces(MediaType.TEXT_PLAIN)
    public String getMsg(@PathParam("param") String name) {
        String msg = "Rest say: good " + name;
        return msg;
    }
}
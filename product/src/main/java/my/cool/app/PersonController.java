package my.cool.app;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import my.cool.model.Person;

import org.jboss.resteasy.annotations.Suspend;
import org.jboss.resteasy.spi.AsynchronousResponse;

@Path("/person")
@Produces(MediaType.APPLICATION_JSON)
public class PersonController {

	@GET
	public Response index() {
		return Response.ok(new Person("Hello")).build();
	}

	@GET
	@Path("/name/{name}")
	public void name(final @Suspend(10000) AsynchronousResponse response, @PathParam("name") final String name) {
		Thread t = new Thread()
	      {
	         @Override
	         public void run()
	         {
	            try
	            {
	               //Response jaxrs = Response.ok("basic").type(MediaType.TEXT_PLAIN).build();
	               Response jaxrs = Response.ok(new Person(33, name)).build();
	               response.setResponse(jaxrs);
	            }
	            catch (Exception e)
	            {
	               e.printStackTrace();
	            }
	         }
	      };
	      t.start();
	}
}

package my.cool.app;

import static org.junit.Assert.assertEquals;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.client.WebTarget;

import my.cool.model.Person;

import org.jboss.resteasy.test.BaseResourceTest;
import org.jboss.resteasy.test.TestPortProvider;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class PersonControllerTest extends BaseResourceTest {

	@BeforeClass
	public static void beforeClass() throws Exception {
		addPerRequestResource(PersonController.class);
	}

	Client client;

	@Before
	public void setUp() {
		client = ClientBuilder.newClient();
	}

	@After
	public void tearDown() {
		client.close();
	}

	Builder request(String path) {
		WebTarget target = client.target(TestPortProvider
				.generateURL("/person" + path));
		return target.request();
	}

	@Test
	public void index() throws Exception {
		try (CloseableResponse response = CloseableResponse.of(request("").get())) {
			assertEquals(200, response.getStatus());
			Person person = response.readEntity(Person.class);
			assertEquals("Hello", person.getName());
		}
	}

	@Test
	public void name() throws Exception {
		try (CloseableResponse response = CloseableResponse.of(request("/Joe").get())) {
			assertEquals(200, response.getStatus());
			Person person = response.readEntity(Person.class);
			assertEquals(33, person.getAge());
			assertEquals("Joe", person.getName());
		}
	}

}

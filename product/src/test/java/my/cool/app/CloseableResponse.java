package my.cool.app;

import java.lang.annotation.Annotation;
import java.net.URI;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import javax.ws.rs.core.EntityTag;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Link;
import javax.ws.rs.core.Link.Builder;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.NewCookie;
import javax.ws.rs.core.Response;

public class CloseableResponse extends Response implements AutoCloseable {

	final Response delegate;

	CloseableResponse(Response response) {
		this.delegate = response;
	}

	public int hashCode() {
		return delegate.hashCode();
	}

	public int getStatus() {
		return delegate.getStatus();
	}

	public StatusType getStatusInfo() {
		return delegate.getStatusInfo();
	}

	public boolean equals(Object obj) {
		return delegate.equals(obj);
	}

	public Object getEntity() {
		return delegate.getEntity();
	}

	public <T> T readEntity(Class<T> entityType) {
		return delegate.readEntity(entityType);
	}

	public <T> T readEntity(GenericType<T> entityType) {
		return delegate.readEntity(entityType);
	}

	public <T> T readEntity(Class<T> entityType, Annotation[] annotations) {
		return delegate.readEntity(entityType, annotations);
	}

	public String toString() {
		return delegate.toString();
	}

	public <T> T readEntity(GenericType<T> entityType, Annotation[] annotations) {
		return delegate.readEntity(entityType, annotations);
	}

	public boolean hasEntity() {
		return delegate.hasEntity();
	}

	public boolean bufferEntity() {
		return delegate.bufferEntity();
	}

	public MediaType getMediaType() {
		return delegate.getMediaType();
	}

	public Locale getLanguage() {
		return delegate.getLanguage();
	}

	public int getLength() {
		return delegate.getLength();
	}

	public Set<String> getAllowedMethods() {
		return delegate.getAllowedMethods();
	}

	public Map<String, NewCookie> getCookies() {
		return delegate.getCookies();
	}

	public EntityTag getEntityTag() {
		return delegate.getEntityTag();
	}

	public Date getDate() {
		return delegate.getDate();
	}

	public Date getLastModified() {
		return delegate.getLastModified();
	}

	public URI getLocation() {
		return delegate.getLocation();
	}

	public Set<Link> getLinks() {
		return delegate.getLinks();
	}

	public boolean hasLink(String relation) {
		return delegate.hasLink(relation);
	}

	public Link getLink(String relation) {
		return delegate.getLink(relation);
	}

	public Builder getLinkBuilder(String relation) {
		return delegate.getLinkBuilder(relation);
	}

	public MultivaluedMap<String, Object> getMetadata() {
		return delegate.getMetadata();
	}

	public MultivaluedMap<String, Object> getHeaders() {
		return delegate.getHeaders();
	}

	public MultivaluedMap<String, String> getStringHeaders() {
		return delegate.getStringHeaders();
	}

	public String getHeaderString(String name) {
		return delegate.getHeaderString(name);
	}

	@Override
	public void close() {
		delegate.close();
	}

	public static CloseableResponse of(Response response) {
		return new CloseableResponse(response);
	}
}

package name.marmar.javatwo;

import com.wordnik.swagger.jaxrs.json.JacksonJsonProvider;
import name.marmar.javatwo.filter.CORSRequestOptionsFilter;
import name.marmar.javatwo.filter.CORSResponseFilter;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.io.ObjectInputStream;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@ApplicationPath("/rest")
public class RestApplication extends Application {

    @Override
    public Map<String, Object> getProperties() {
        Map<String, Object> result = new HashMap<>();
        result.put("com.sun.jersey.config.feature.DisableWADL", true);
        return result;
    }

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> s = new HashSet<Class<?>>();
        s.add(RoomResource.class);
        s.add(PresentationResource.class);
        s.add(ConferenceDayResource.class);
        s.add(CORSResponseFilter.class);
        s.add(CORSRequestOptionsFilter.class);
        s.add(JacksonJsonProvider.class);
        s.add(com.wordnik.swagger.jaxrs.listing.ApiDeclarationProvider.class);
        s.add(com.wordnik.swagger.jaxrs.listing.ApiListingResource.class);
        s.add(com.wordnik.swagger.jaxrs.listing.ApiListingResourceJSON.class);
        s.add(com.wordnik.swagger.jaxrs.listing.ResourceListingProvider.class);
        return s;
    }
}

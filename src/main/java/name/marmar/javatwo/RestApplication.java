package name.marmar.javatwo;

import name.marmar.javatwo.filter.CORSRequestOptionsFilter;
import name.marmar.javatwo.filter.CORSResponseFilter;
import org.glassfish.jersey.message.filtering.EntityFilteringFeature;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

@ApplicationPath("/rest")
public class RestApplication extends Application {



    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> s = new HashSet<Class<?>>();
        s.add(RoomResource.class);
        s.add(PresentationResource.class);
        s.add(ConferenceDayResource.class);
        s.add(CORSResponseFilter.class);
        s.add(CORSRequestOptionsFilter.class);
        s.add(EntityFilteringFeature.class);
        return s;
    }
}

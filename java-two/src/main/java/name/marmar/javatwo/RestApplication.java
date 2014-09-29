package name.marmar.javatwo;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.*;

@ApplicationPath("/rest")
public class RestApplication extends Application {

    public Map<String, Object> getProperties() {
        Map<String, Object> props = new HashMap<>();
        props.put("jersey.config.server.wadl.generatorConfig", WadlConfig.class);
        return props;
    }

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> s = new HashSet<Class<?>>();
        s.add(RoomResource.class);
        s.add(PresentationResource.class);
        s.add(ConferenceDayResource.class);
        return s;
    }
}

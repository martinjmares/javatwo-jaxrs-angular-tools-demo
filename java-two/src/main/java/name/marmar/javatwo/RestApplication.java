package name.marmar.javatwo;

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
        return s;
    }
}

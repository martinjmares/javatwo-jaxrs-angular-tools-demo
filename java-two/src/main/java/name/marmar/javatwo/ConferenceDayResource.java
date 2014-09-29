package name.marmar.javatwo;

import name.marmar.javatwo.model.ConferenceDay;
import name.marmar.javatwo.model.Presentation;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import java.util.Collection;

/** Rest resource for enumeration of valid conference days
 */
@Path("confday")
public class ConferenceDayResource {

    private final static String RESULT;
    static {
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for (ConferenceDay day : ConferenceDay.values()) {
            if (sb.length() > 1) {
                sb.append(", ");
            }
            sb.append('\"').append(day).append('\"');
        }
        sb.append(']');
        RESULT = sb.toString();
    }

    /** Returns list valid conference days.
     */
    @GET
    @Produces("application/json")
    public String list() {
        return RESULT;
    }

}

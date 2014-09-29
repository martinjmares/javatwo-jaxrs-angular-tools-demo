package name.marmar.javatwo;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
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
@Api(value = "confday", description = "Access to list of conference days." )
public class ConferenceDayResource {

    private static final String RESULT;
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
    @ApiOperation(value = "List of conference days.",
            response = String.class,
            responseContainer = "List")
    public String list() {
        return RESULT;
    }

}

package name.marmar.javatwo;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.Collections2;
import com.wordnik.swagger.annotations.*;
import name.marmar.javatwo.model.ConferenceDay;
import name.marmar.javatwo.model.Presentation;
import name.marmar.javatwo.model.Room;
import name.marmar.javatwo.service.PresentationCatalogueService;

import javax.inject.Inject;
import javax.ws.rs.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.logging.Logger;

/** Rest resource for presentations.
 */
@Path("presentation")
@Api(value = "presentation", description = "Manage presentations." )
public class PresentationResource {

    private static final Logger log = Logger.getLogger(PresentationResource.class.getName());

    @Inject
    private PresentationCatalogueService service;

    /** Returns list of planned presentations.
     *
     * @param day is optional and if is set then result is filtered for this particular day.
     * @param room is optioanl and if set then result is filtered for this particular room.
     * @return list of presentations
     */
    @GET
    @Produces("application/json")
    @ApiOperation(value = "List of planned presentations.",
            notes = "It is possible to filter result using query parameters room and day",
            response = Presentation.class,
            responseContainer = "List")
    public Collection<Presentation> list(@ApiParam( value = "Filter just for this day events", required = false )
                                         @QueryParam("day") final ConferenceDay day,
                                         @ApiParam( value = "Filter just for this room number", required = false )
                                         @QueryParam("room") final Integer room) {
        log.info("listPresentations(" + day + ", " + room + ")");
        List<Predicate<Presentation>> predicates = new ArrayList<>(2);
        if (day != null) {
            predicates.add(new Predicate<Presentation>() {
                @Override
                public boolean apply(Presentation presentation) {
                    return day == presentation.getConferenceDay();
                }
            });
        }
        if (room != null) {
            predicates.add(new Predicate<Presentation>() {
                @Override
                public boolean apply(Presentation presentation) {
                    return room.intValue() == presentation.getRoomNumber();
                }
            });
        }
        return Collections2.filter(service.listPresentations(), Predicates.and(predicates));
    }

    /** Add a new presentation
     */
    @POST
    @Produces("application/json")
    @ApiOperation(value = "Add a new presentation.",
            response = Presentation.class)
    @ApiResponses( {
            @ApiResponse( code = 409, message = "Presentation with such name already exists." )
    } )
    public Presentation add(@ApiParam( value = "Presentation to be add", required = true )Presentation presentation) {
        service.add(presentation);
        return presentation;
    }

}

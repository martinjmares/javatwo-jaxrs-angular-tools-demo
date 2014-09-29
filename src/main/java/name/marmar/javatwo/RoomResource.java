package name.marmar.javatwo;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import name.marmar.javatwo.filter.RoomDetailView;
import name.marmar.javatwo.model.Presentation;
import name.marmar.javatwo.model.Room;
import name.marmar.javatwo.service.RoomCatalogueService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import java.util.Collection;

/** Rest resource for Room.
 */
@Path("room")
@Api(value = "room", description = "Manage rooms." )
public class RoomResource {

    @Inject
    private RoomCatalogueService roomCatalogueService;

    @GET
    @Produces("application/json")
    @ApiOperation(value = "List of conference rooms.",
            response = Room.class,
            responseContainer = "List")
    public Collection<Room> list() {
        return roomCatalogueService.listRooms();
    }

    @GET
    @Produces("application/json")
    @Path("/{roomNumber}")
    @ApiOperation(value = "Detail of the conference room.")
    @RoomDetailView
    public Room getByNumber(@ApiParam( value = "Number of requested room" ) @PathParam("roomNumber") Integer roomNumber) {
        return roomCatalogueService.getRoomByNumber(roomNumber);
    }
}

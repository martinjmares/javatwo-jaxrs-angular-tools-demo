package name.marmar.javatwo;

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
public class RoomResource {

    @Inject
    private RoomCatalogueService roomCatalogueService;

    @GET
    @Produces("application/json")
    public Collection<Room> list() {
        return roomCatalogueService.listRooms();
    }

    @GET
    @Produces("application/json")
    @Path("{roomNumber}")
    public Room getByNumber(@PathParam("roomNumber") Integer roomNumber) {
        return roomCatalogueService.getRoomByNumber(roomNumber);
    }
}

package name.marmar.javatwo.model;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

import javax.xml.bind.annotation.XmlRootElement;

/** Room in conference center.
 *
 * @author martinmares
 */
@XmlRootElement
@ApiModel( value = "Room", description = "Represents conference room in one of the JavaTwo conference centers." )
public class Room {

    @ApiModelProperty( value = "Room number", required = true )
    private int number;
    @ApiModelProperty( value = "Name of the room for better orientation and more human friendly approach.")
    private String name;
    private String building;
    @ApiModelProperty( value = "Number of seats in the room in conference room configuration.", required = true )
    private int seats;

    public Room() {
    }

    public Room(int number, String name, String building, int seats) {
        this.number = number;
        this.name = name;
        this.building = building;
        this.seats = seats;
    }

    /** Gets Room number.
     */
    public int getNumber() {
        return number;
    }

    /** Sets room number
     */
    public void setNumber(int number) {
        this.number = number;
    }

    /** Some rooms has a name because it is more easy to remember.
     */
    public String getName() {
        return name;
    }

    /** Some rooms has a name because it is more easy to remember.
     */
    public void setName(String name) {
        this.name = name;
    }

    /** Name of the building
     */
    public String getBuilding() {
        return building;
    }

    /** Name of the building
     */
    public void setBuilding(String building) {
        this.building = building;
    }

    /** Number of seats in the room.
     */
    public int getSeats() {
        return seats;
    }

    /** Number of seats in the room.
     */
    public void setSeats(int seats) {
        this.seats = seats;
    }
}

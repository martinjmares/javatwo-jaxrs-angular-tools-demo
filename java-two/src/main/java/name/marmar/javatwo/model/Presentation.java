package name.marmar.javatwo.model;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * JavaTwo presentation description.
 */
@XmlRootElement
public class Presentation {

    private String name;
    private String presenter;
    private int roomNumber;
    private ConferenceDay conferenceDay;
    private int reservationCount;

    public Presentation() {
    }

    public Presentation(String name, String presenter, int roomNumber, ConferenceDay conferenceDay) {
        this.name = name;
        this.presenter = presenter;
        this.roomNumber = roomNumber;
        this.conferenceDay = conferenceDay;
    }

    /** Name of the presentation
     */
    public String getName() {
        return name;
    }

    /** Name of the presentation
     */
    public void setName(String name) {
        this.name = name;
    }

    /** Name of the person who will present it.
     */
    public String getPresenter() {
        return presenter;
    }

    /** Name of the person who will present it.
     */
    public void setPresenter(String presenter) {
        this.presenter = presenter;
    }

    /** Room where presentation will be.
     */
    public int getRoomNumber() {
        return roomNumber;
    }

    /** Room where presentation will be.
     */
    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    /** On which day of the conference will this presentation happen.
     */
    public ConferenceDay getConferenceDay() {
        return conferenceDay;
    }

    /** On which day of the conference will this presentation happen.
     */
    public void setConferenceDay(ConferenceDay conferenceDay) {
        this.conferenceDay = conferenceDay;
    }

    /** How many attendees made a reservation for this presentation.
     */
    public int getReservationCount() {
        return reservationCount;
    }

    /** How many attendees made a reservation for this presentation.
     */
    public void setReservationCount(int reservationCount) {
        this.reservationCount = reservationCount;
    }
}

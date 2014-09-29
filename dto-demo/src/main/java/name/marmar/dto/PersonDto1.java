package name.marmar.dto;

/**
 * Created by martinmares on 28.09.14.
 */
public class PersonDto1 {
    private String firstName;
    private String surname;
    public String company;

    public PersonDto1() {
    }

    @Override
    public String toString() {
        return "PersonDto1{" +
                "\n    firstName='" + firstName + '\'' +
                "\n    surname='" + surname + '\'' +
                "\n    company='" + company + '\'' +
                '}';
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        if (surname != null) {
            this.surname = surname.toUpperCase();
        } else {
            this.surname = null;
        }
    }
}

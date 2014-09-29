package name.marmar.dto;

import name.marmar.model.Address;

/**
 * Created by martinmares on 28.09.14.
 */
public class PersonDto3 {
    private String firstName;
    private String surname;
    private String company;
    private Address address;

    public PersonDto3() {
    }

    @Override
    public String toString() {
        return "PersonDto1{" +
                "\n    firstName='" + firstName + '\'' +
                "\n    surname='" + surname + '\'' +
                "\n    company='" + company + '\'' +
                "\n    address='" + address + '\'' +
                '}';
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}

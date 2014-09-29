package name.marmar.dto;

import name.marmar.model.Address;

/**
 * Created by martinmares on 28.09.14.
 */
public class PersonDto4 {
    private String firstName;
    private String surname;
    private String company;
    private String age;
    private int yearOfBirth;


    public PersonDto4() {
    }

    @Override
    public String toString() {
        return "PersonDto1{" +
                "\n    firstName='" + firstName + '\'' +
                "\n    surname='" + surname + '\'' +
                "\n    company='" + company + '\'' +
                "\n    age='" + age + '\'' +
                "\n    yearOfBirth='" + yearOfBirth + '\'' +
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

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }
}

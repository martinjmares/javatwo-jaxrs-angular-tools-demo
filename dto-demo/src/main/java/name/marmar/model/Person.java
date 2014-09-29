package name.marmar.model;

/**
 * Created by martinmares on 28.09.14.
 */
public class Person {

    public static final Person person = new Person("John", "Li", "ACME", 31,
            new Address("Long st.", 1, "San Francisco"));

    private String firstName;
    private String surname;
    private String company;
    private int age;
    private Address address;

    public Person() {
    }

    public Person(String firstName, String surname, String company, int age, Address address) {
        this.firstName = firstName;
        this.surname = surname;
        this.company = company;
        this.age = age;
        this.address = address;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Person{" +
                "\n    firstName='" + firstName + '\'' +
                "\n    surname='" + surname + '\'' +
                "\n    company='" + company + '\'' +
                "\n    age=" + age +
                "\n    address=" + address +
                '}';
    }
}

package name.marmar.dto;

/**
 * Created by martinmares on 29.09.14.
 */
public class PersonDto2 {
    public static class Name {
        public String firstName;
        public String surname;

        public String toString() {
            return firstName + " " + surname;
        }
    }

    private Name name;
    private String company;

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    @Override
    public String toString() {
        return "PersonDto2{" +
                "\n    name=" + name +
                "\n    company='" + company + '\'' +
                '}';
    }
}

package Person;

public class Person {
    protected final String name;
    protected final String surname;
    protected int age;
    protected String address;

    protected Person(String name, String surname, int age, String address) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.address = address;
    }

    public boolean hasAge() {
        return age < 0 ? false : true;
    }

    public boolean hasAddress() {
        return address == null ? false : true;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void happyBirthday() {
        if (this.hasAge()) {
            age += 1;
        }
    }

    @Override
    public String toString() {
        return String.format("%s %s%s%s", name, surname,
                hasAge() ? ( age == 0 ? " - младенец" : String.format(" возрастом %s лет", age) ): "",
                hasAddress() ? String.format(" из города %s", address) : "");
    }

    @Override
    public int hashCode() {
        return (name.hashCode()* 256830/surname.hashCode())^2;
    }

    public PersonBuilder newChildBuilder() {
        return new PersonBuilder()
                .setSurname(surname)
                .setAge(0)
                .setAddress(address);
    }
}

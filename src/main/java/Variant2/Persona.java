package Variant2;

import Person.Person;

public class Persona {
    protected final String name;
    protected final String surname;
    protected int age;
    protected String address;

    protected Persona(PersonaBuilder builder) {
        this.name = builder.name;
        this.surname = builder.surname;
        this.age = (builder.age != 0 ? builder.age : -1);
        if (builder.address != null) {
            this.address = address;
        }
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

    public PersonaBuilder newChildBuilder(String name) {
        return new PersonaBuilder(name, surname)
                .setAge(0)
                .setAddress(address);
    }

    public static class PersonaBuilder {

        protected final String name;
        protected final String surname;
        protected int age = -1;
        protected String address;

        public PersonaBuilder(String name, String surname) {
            this.name = name;
            this.surname = surname;
        }

        public PersonaBuilder setAge(int age) {
            if (age >= 0 && age <= 110) {
                this.age = age;
            } else {
                throw new IllegalArgumentException("Некорректные данные для поля 'возраст'");
            }
            return this;
        }

        public PersonaBuilder setAddress(String address) {
            this.address = address;
            return this;
        }

        public Persona build() {
            return new Persona(this);
        }
    }
}

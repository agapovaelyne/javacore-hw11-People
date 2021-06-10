package Person;

public class PersonBuilder {
    protected String name;
    protected String surname;
    protected int age = -1;
    protected String address;

    public PersonBuilder() { }

    public PersonBuilder setName(String name) {
        if (this.name == null) {
            this.name = name;
        } else { //если даже при строительстве имя можно задать только один раз и нельзя менять
            throw new IllegalArgumentException(String.format("У человека %s уже есть имя!", this.name));
        }
        return this;
    }

    public PersonBuilder setSurname(String surname) {
        if (this.surname == null) {
            this.surname = surname;
        } else { //если даже при строительстве фамилию можно задать только один раз и нельзя менять
            throw new IllegalArgumentException(String.format("У человека%s уже есть фамилия - %s!", this.name == null ? "" : " " + this.name, this.surname));
        }
        return this;
    }

    public PersonBuilder setAge(int age) {
        if (age >= 0 && age <= 110) {
            this.age = age;
        } else {
            throw new IllegalArgumentException("Некорректные данные для поля 'возраст'");
        }
        return this;
    }

    public PersonBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    public Person build() {
        if (name == null) {
            throw new IllegalStateException("Не заполнено обязательное поле 'имя'. Используйте метод setName()");
        }
        if (surname == null) {
            throw new IllegalStateException("Не заполнено обязательное поле 'фамилия'. Используйте метод setSurname()");
        }
        return new Person (name, surname, age, address);
    }
}
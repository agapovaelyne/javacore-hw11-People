package Person;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PersonBuilderTest {
    @Test
    void setName_test1(){
        String name = "TestName";
        Person testPerson = new PersonBuilder()
                .setName(name)
                .setSurname("TestSurname")
                .build();
        Assert.assertEquals(testPerson.getName(), name);
    }

    @Test
    void setName_test2(){
        String name = "TestName";
        PersonBuilder testBuilder = new PersonBuilder()
                .setName(name);
        Assert.assertEquals(testBuilder.name, name);
    }

    @Test
    void setName_test3(){
        String name1 = "TestName1";
        String name2 = "TestName2";
        PersonBuilder testBuilder = new PersonBuilder().setName(name1);
        IllegalArgumentException result = Assertions.assertThrows(IllegalArgumentException.class, () ->
                testBuilder.setName(name2)
                );
        Assertions.assertEquals(String.format("У человека %s уже есть имя!", name1), result.getMessage());
    }

    @Test
    void setSurame_test1(){
        String surname = "TestSurname";
        Person testPerson = new PersonBuilder()
                .setName("TestName")
                .setSurname(surname)
                .build();
        Assert.assertEquals(testPerson.getSurname(), surname);
    }

    @Test
    void setSurame_test2(){
        String surname = "TestSurname";
        PersonBuilder testBuilder = new PersonBuilder()
                .setSurname(surname);
        Assert.assertEquals(testBuilder.surname, surname);
    }

    @Test
    void setSurame_test3(){
        String surname1 = "TestSurname1";
        String surname2 = "TestSurname2";
        PersonBuilder testBuilder = new PersonBuilder().setSurname(surname1);
        IllegalArgumentException result = Assertions.assertThrows(IllegalArgumentException.class, () ->
                testBuilder.setSurname(surname2)
                );
        Assertions.assertEquals(String.format("У человека уже есть фамилия - %s!", surname1), result.getMessage());
    }

    @Test
    void setSurame_test4(){
        String surname1 = "TestSurname1";
        String surname2 = "TestSurname2";
        PersonBuilder testBuilder = new PersonBuilder()
                .setName("TestName")
                .setSurname(surname1);
        IllegalArgumentException result = Assertions.assertThrows(IllegalArgumentException.class, () ->
                testBuilder.setSurname(surname2)
                );
        Assertions.assertEquals(String.format("У человека %s уже есть фамилия - %s!", testBuilder.name, surname1), result.getMessage());
    }

    @Test
    void setAge_test1(){
        int age = 5;
        Person testPerson = new PersonBuilder()
                .setName("TestName")
                .setSurname("TestSurname")
                .setAge(age)
                .build();
        Assert.assertEquals(testPerson.getAge(), age);
    }

    @Test
    void setAge_test2(){
        int age = 5;
        PersonBuilder testBuilder = new PersonBuilder()
                .setAge(age);
        Assert.assertEquals(testBuilder.age, age);
    }

    @Test
    void setAge_test3(){
        int age = -100;
        PersonBuilder testBuilder = new PersonBuilder();
        IllegalArgumentException result = Assertions.assertThrows(IllegalArgumentException.class, () ->
                testBuilder.setAge(age)
                );
        Assertions.assertEquals("Некорректные данные для поля 'возраст'", result.getMessage());
    }

    @Test
    void setAge_test4(){
        int age1 = 5;
        int age2 = 10;
        PersonBuilder testBuilder = new PersonBuilder()
                .setAge(age1)
                .setAge(age2);
        Assertions.assertEquals(testBuilder.age, age2);
    }

    @Test
    void setAddress_test1(){
        String address = "Milan";
        Person testPerson = new PersonBuilder()
                .setName("TestName")
                .setSurname("TestSurname")
                .setAddress(address)
                .build();
        Assert.assertEquals(testPerson.getAddress(), address);
    }

    @Test
    void setAddress_test2(){
        String address = "Milan";
        PersonBuilder testBuilder = new PersonBuilder()
                .setAddress(address);
        Assert.assertEquals(testBuilder.address, address);
    }

    @Test
    void setAddress_test3(){
        String address1 = "Milan";
        String address2 = "New York";
        PersonBuilder testBuilder = new PersonBuilder()
                .setAddress(address1)
                .setAddress(address2);
        Assert.assertEquals(testBuilder.address, address2);
    }

    @Test
    void build_test1(){
        String name = "TestName";
        String surname = "TestSurname";
        int age = 5;
        String address = "New York";
        Person testPerson = new PersonBuilder()
                .setName(name)
                .setSurname(surname)
                .setAge(age)
                .setAddress(address)
                .build();
        Assert.assertEquals(testPerson.getName(), name);
        Assert.assertEquals(testPerson.getSurname(), surname);
        Assert.assertEquals(testPerson.getAge(), age);
        Assert.assertEquals(testPerson.getAddress(), address);
    }

    @Test
    void build_test2(){
        String name = "TestName";
        String surname = "TestSurname";
        Person testPerson = new PersonBuilder()
                .setName(name)
                .setSurname(surname)
                .build();
        Assert.assertEquals(testPerson.getName(), name);
        Assert.assertEquals(testPerson.getSurname(), surname);
        Assert.assertEquals(testPerson.getAge(), -1);
        Assert.assertEquals(testPerson.getAddress(), null);
    }

    @Test
    void build_test3(){
        String name = "TestName";
        PersonBuilder testBuilder = new PersonBuilder()
                .setName(name);
        IllegalStateException result = Assertions.assertThrows(IllegalStateException.class, () ->
                testBuilder.build()
                );
        Assertions.assertEquals("Не заполнено обязательное поле 'фамилия'. Используйте метод setSurname()", result.getMessage());
    }

    @Test
    void build_test4(){
        String surname = "TestSurname";
        PersonBuilder testBuilder = new PersonBuilder()
                .setSurname(surname);
        IllegalStateException result = Assertions.assertThrows(IllegalStateException.class, () ->
                testBuilder.build()
                );
        Assertions.assertEquals("Не заполнено обязательное поле 'имя'. Используйте метод setName()", result.getMessage());
    }
}

package Person;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class PersonTest {

    private Person pers_full = new Person("TestName", "TestSurname", 5, "New York");
    private Person pers_unfull = new PersonBuilder()
                .setName("TestName")
                .setSurname("TestSurname")
                .build();
    private Person pers_baby = new Person("TestName", "TestSurname", 0, "New York");

    @Test
    void hasAge_test1() {
        boolean actual = pers_full.hasAge();
        Assert.assertTrue(actual);
    }

    @Test
    void hasAge_test2() {
        boolean actual = pers_unfull.hasAge();
        Assert.assertFalse(actual);
    }

    @Test
    void hasAddress_test1() {
        boolean actual = pers_full.hasAddress();
        Assert.assertTrue(actual);
    }

    @Test
    void hasAddress_test2() {
        boolean actual = pers_unfull.hasAddress();
        Assert.assertFalse(actual);
    }

    @Test
    void getName_test() {
        String name = "TestName";
        String actual = pers_full.getName();
        Assert.assertEquals(name, actual);
    }

    @Test
    void getSurname_test() {
        String surname = "TestSurname";
        String actual = pers_full.getSurname();
        Assert.assertEquals(surname, actual);
    }

    @Test
    void getAge_test1() {
        int age = 5;
        int actual = pers_full.getAge();
        Assert.assertEquals(age, actual);
    }

    @Test
    void getAge_test2() {
        int age = 5;
        int actual = pers_unfull.getAge();
        Assert.assertEquals(-1, actual);
    }

    @Test
    void getAddress_test1() {
        String address = "New York";
        String actual = pers_full.getAddress();
        Assert.assertEquals(address, actual);
    }

    @Test
    void getAddress_test2() {
        String actual = pers_unfull.getAddress();
        Assert.assertEquals(null, actual);
    }

    @Test
    void setAddress_test1() {
        String address = "New Jersey";
        pers_full.setAddress(address);
        String actual = pers_full.getAddress();
        Assert.assertEquals(address, actual);
    }

    @Test
    void setAddress_test2() {
        String address = "New Jersey";
        pers_unfull.setAddress(address);
        String actual = pers_unfull.getAddress();
        Assert.assertEquals(address, actual);
    }

    @Test
    void happyBirthday_test1() {
        int expected = pers_full.getAge()+1;
        pers_full.happyBirthday();
        int actual = pers_full.getAge();
        Assert.assertEquals(expected, actual);
    }

    @Test
    void happyBirthday_test2() {
        int expected = -1;
        pers_unfull.happyBirthday();
        int actual = pers_unfull.getAge();
        Assert.assertEquals(expected, actual);
    }

    @Test
    void toString_test1() {
        Assert.assertTrue(pers_baby.toString().contains("младенец"));
    }

    @Test
    void toString_test2() {
        Assert.assertFalse(pers_unfull.toString().contains("из города"));
    }

    @Test
    void toString_test3() {
        Assert.assertFalse(pers_unfull.toString().contains("возрастом"));
    }

    @Test
    void newChildBuilder_test1() {
        Person child = pers_full.newChildBuilder()
                .setName("TestChildName")
                .build();
        Assert.assertEquals(child.getSurname(),pers_full.getSurname());
    }

    @Test
    void newChildBuilder_test2() {
        Person child = pers_full.newChildBuilder()
                .setName("TestChildName")
                .build();
        Assert.assertEquals(child.getAddress(),pers_full.getAddress());
    }

    @Test
    void newChildBuilder_test3() {
        Person child = pers_unfull.newChildBuilder()
                .setName("TestChildName")
                .build();
        Assert.assertEquals(child.getAddress(),pers_unfull.getAddress());
    }
}

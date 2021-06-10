package Variant2;

public class Main2 {
    public static void main(String[] args) {
        Persona mom = new Persona.PersonaBuilder("Анна", "Вольф")
                .setAge(31)
                .setAddress("Сидней")
                .build();
        Persona son = mom.newChildBuilder("Антошка")
                .build();
        System.out.println("У " + mom + " есть сын, " + son);

        //new Persona.PersonaBuilder().build(); Не хватает обязательных полей - так нельзя

        try {
            // Возраст недопустимый
            new Persona.PersonaBuilder("Виктор", "Вольф").setAge(-100).build();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }
}

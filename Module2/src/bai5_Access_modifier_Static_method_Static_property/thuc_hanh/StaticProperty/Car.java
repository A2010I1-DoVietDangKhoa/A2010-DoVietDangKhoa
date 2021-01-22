package bai5_Access_modifier_Static_method_Static_property.thuc_hanh.StaticProperty;

public class Car {

    private String name;

    private String engine;



    public static int numberOfCars;



    public Car(String name, String engine) {

        this.name = name;

        this.engine = engine;

        numberOfCars++;

    }



    // getters and setters

}


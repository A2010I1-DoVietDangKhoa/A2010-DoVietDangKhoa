package bai7_Abstract_Class_va_Interface.thuc_hanh.LopAnimalVaInterfaceEdible;

public class Tiger extends Animal implements Edible{
    @Override
    public String makeSound() {
        return "Tiger: roarrrrr!";
    }

    @Override
    public String howToEat() {
        return "Tiger couldn't be eaten.";
    }
}

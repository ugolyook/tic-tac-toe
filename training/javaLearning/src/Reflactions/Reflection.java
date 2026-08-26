package Reflactions;

public class Reflection {
    private int number = 546;
    private String animal = "Frog";
    private static int SENSE_OF_LIFE;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setAnimal(String animal) {
        this.animal = animal;
    }

    private void printInfo() {
        System.out.println(animal + number);
    }
}



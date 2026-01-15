public class Gamer {
    private String name_1;
    private String name_2;
    String simbol_1;
    String simbol_2;


    public Gamer() {}

    public String getName_1() {return name_1;}
    public void setName_1(String name_1) {this.name_1 = name_1;}

    public String getSimbol_1() {return simbol_1;}
    public void setSimbol_1(String simbol_1) {this.simbol_1 = simbol_1;}

    public String getName_2() {return name_2;}
    public void setName_2(String name_2) {this.name_2 = name_2;}

    public String getSimbol_2() {return simbol_2;}
    public void setSimbol_2(String simbol_2) {this.simbol_2 = simbol_2;}

    public void showInfo() {
        System.out.println("1 Gamer name:" + getName_1() + "\n1 Gamer simbol:" + getSimbol_1());
        System.out.println("\n2 Gamer name:" + getName_2() + "\n2 Gamer simbol:" + getSimbol_2() );
    }
}

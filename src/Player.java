public class Player {
    private String name1;
    private String name2;
    String simbol1;
    String simbol2;


    public Player() {}

    public String getName1() {return name1;}
    public void setName1(String name1) {this.name1 = name1;}

    public String getSimbol1() {return simbol1;}
    public void setSimbol1(String simbol1) {this.simbol1 = simbol1;}

    public String getName2() {return name2;}
    public void setName2(String name2) {this.name2 = name2;}

    public String getSimbol2() {return simbol2;}
    public void setSimbol2(String simbol2) {this.simbol2 = simbol2;}

    public void showInfo() {
        System.out.println("1 Gamer name:" + getName1() + "\n1 Gamer simbol:" + getSimbol1());
        System.out.println("\n2 Gamer name:" + getName2() + "\n2 Gamer simbol:" + getSimbol2() );
    }
}

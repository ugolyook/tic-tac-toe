public class Player {
    private String name;
    char simbol;


    public Player() {}

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}

    public char getSimbol() {return simbol;}
    public void setSimbol(char simbol) {this.simbol = simbol;}

    public void showInfo() {
        System.out.println("1 Gamer name:" + getName() + "\n1 Gamer simbol:" + getSimbol());
    }
}

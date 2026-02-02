public class Player {
    private String name;
    private char simbol;

    public Player() {}

    public Player(String name) {
    }

    public String getName() {return name;}

    public void setName(String name) {this.name = name;}

    public char getSimbol() {return simbol;}

    public void setSimbol(char simbol) {this.simbol = simbol;}

    public String toString() {
        return(name);
    }
}

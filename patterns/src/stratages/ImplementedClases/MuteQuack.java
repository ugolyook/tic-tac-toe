package stratages.ImplementedClases;

import stratages.Interfaces.QuackBehavior;

public class MuteQuack implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("Silence...");
    }
}

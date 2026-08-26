package stratages.extendedClases;

import stratages.ImplementedClases.FlyWithWings;
import stratages.ImplementedClases.Quack;

public class MallardDuck extends Duck {
    public MallardDuck(){
        quackBehavior = new Quack();
        flyBehavior = new FlyWithWings();
    }
    @Override
    public void display() {
        System.out.println("I'm a real mallard duck!");
    }
}

package stratages.extendedClases;

import stratages.ImplementedClases.FlyNoWay;
import stratages.ImplementedClases.Quack;

public class ModelDuck extends Duck {
    public ModelDuck(){
        flyBehavior=new FlyNoWay();
        quackBehavior=new Quack();
    }

    @Override
    public void display() {
        System.out.println("I'm a model duck");
    }
}

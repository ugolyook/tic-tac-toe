package Annotations;

import java.lang.reflect.Method;

public class AnnotationDemo {

    @Name(value = "Work Method")
    public void work() {
        System.out.println("Working...");
    }

    @Name
    public void rest() {
        System.out.println("Resting...");
    }

    public void normalMethod() {
        System.out.println("Normal method...");
    }

    static void main(String[] args) {
        AnnotationDemo demo = new AnnotationDemo();

        Method[] methods = demo.getClass().getDeclaredMethods();

        for (Method method : methods) {
            if (method.isAnnotationPresent(Name.class)) {
                Name nameAnnotation = method.getAnnotation(Name.class);

                System.out.println(" Method with annotation @Name: " + method.getName());
                System.out.println(" Value: " + nameAnnotation.value());
                try {
                    method.invoke(demo);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("Method without annotation: " + method.getName());
            }
        }
    }
}
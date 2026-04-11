import Reflactions.Reflection;

void main() {
    Reflection refl = new Reflection();
    int number = refl.getNumber();
    String animal = null;
    printInfo(refl);

    try{
        Field fieldSenseOfLife = Reflection.class.getDeclaredField("SENSE_OF_LIFE");
        fieldSenseOfLife.setAccessible(true);
        fieldSenseOfLife.set(null, 42);
        System.out.println(fieldSenseOfLife.get(null));
    }catch (NoSuchFieldException e) {
        throw new RuntimeException(e);
    } catch (IllegalAccessException e) {
        throw new RuntimeException(e);
    }

    try {
        Field field = Reflection.class.getDeclaredField("animal");
        field.setAccessible(true);
        field.set(refl, (String) "new value");
    } catch (NoSuchFieldException | IllegalAccessException e) {
        e.printStackTrace();
    }

    printInfo(refl);
    System.out.println(ArrayList.class.getName());
    System.out.println(ArrayList.class.getPackageName());

    try {
        ArrayList<String> arrayList = (ArrayList) ArrayList.class.getConstructor().newInstance();

        Constructor[] constructors = ArrayList.class.getConstructors();
        for (Constructor constructor : constructors) {
            Class[] paramTypes = constructor.getParameterTypes();
            for (Class paramType : paramTypes) {
                System.out.println(paramType.getName() + " ");
            }
            System.out.println();
        }
    } catch ( InstantiationException | IllegalAccessException |
             NoSuchMethodException | InvocationTargetException e) {
        e.printStackTrace();
    }
}

public static void printInfo(Object refl) {
    try {
        Method method = refl.getClass().getDeclaredMethod("printInfo");
        method.setAccessible(true);
        method.invoke(refl);
    } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
        e.printStackTrace();
    }
}

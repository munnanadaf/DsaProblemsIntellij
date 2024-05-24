//package interview;
//import java.lang.reflect.Constructor;
//import java.lang.reflect.InvocationTargetException;
//
//public class SingletonBreaker {
//    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
//        // Get the Singleton instance using reflection
//        Constructor<Singleton> constructor = Singleton.class.getDeclaredConstructor();
//        constructor.setAccessible(true);
//        Singleton instance1 = constructor.newInstance();
//
//        // Access the original instance and the new instance
//        Singleton instance2 = Singleton.getInstance();
//
//        // Both instances are different
//        System.out.println("Instance 1 hashcode: " + instance1.hashCode());
//        System.out.println("Instance 2 hashcode: " + instance2.hashCode());
//    }
//}
//
//import java.io.*;
//
//public class SingletonBreaker {
//    public static void main(String[] args) throws IOException, ClassNotFoundException {
//        Singleton instance1 = Singleton.getInstance();
//
//        // Serialize the Singleton instance
//        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("singleton.ser"))) {
//            oos.writeObject(instance1);
//        }
//
//        // Deserialize the Singleton instance
//        Singleton instance2;
//        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("singleton.ser"))) {
//            instance2 = (Singleton) ois.readObject();
//        }
//
//        // Both instances are different
//        System.out.println("Instance 1 hashcode: " + instance1.hashCode());
//        System.out.println("Instance 2 hashcode: " + instance2.hashCode());
//    }
//}
//
//public enum Singleton {
//    INSTANCE;
//
//    public void doSomething() {
//        // Your singleton logic here
//    }
//}
//
//public class Singleton {
//    private static final Singleton INSTANCE = new Singleton();
//
//    private Singleton() {}
//
//    public static Singleton getInstance() {
//        return INSTANCE;
//    }
//
//    public void doSomething() {
//        // Your singleton logic here
//    }
//}
//
//
//public class Singleton {
//    private static volatile Singleton instance;
//
//    private Singleton() {}
//
//    public static Singleton getInstance() {
//        if (instance == null) {
//            synchronized (Singleton.class) {
//                if (instance == null) {
//                    instance = new Singleton();
//                }
//            }
//        }
//        return instance;
//    }
//
//    public void doSomething() {
//        // Your singleton logic here
//    }
//}
//
//
//public class Singleton {
//    private Singleton() {}
//
//    private static class SingletonHelper {
//        private static final Singleton INSTANCE = new Singleton();
//    }
//
//    public static Singleton getInstance() {
//        return SingletonHelper.INSTANCE;
//    }
//
//    public void doSomething() {
//        // Your singleton logic here
//    }
//}
//import java.lang.reflect.Constructor;
//import java.lang.reflect.InvocationTargetException;
//
//public class SingletonBreaker {
//    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
//        // Get the Singleton instance using reflection
//        Constructor<Singleton> constructor = Singleton.class.getDeclaredConstructor();
//        constructor.setAccessible(true);
//        Singleton instance1 = constructor.newInstance();
//
//        // Access the original instance and the new instance
//        Singleton instance2 = Singleton.getInstance();
//
//        // Both instances are different
//        System.out.println("Instance 1 hashcode: " + instance1.hashCode());
//        System.out.println("Instance 2 hashcode: " + instance2.hashCode());
//    }
//}
//import java.lang.reflect.Constructor;
//import java.lang.reflect.InvocationTargetException;
//
//public class SingletonBreaker {
//    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
//        // Get the Singleton instance using reflection
//        Constructor<Singleton> constructor = Singleton.class.getDeclaredConstructor();
//        constructor.setAccessible(true);
//        Singleton instance1 = constructor.newInstance();
//
//        // Access the original instance and the new instance
//        Singleton instance2 = Singleton.getInstance();
//
//        // Both instances are different
//        System.out.println("Instance 1 hashcode: " + instance1.hashCode());
//        System.out.println("Instance 2 hashcode: " + instance2.hashCode());
//    }
//}
//
//

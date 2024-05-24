package interview;

import java.lang.reflect.Method;

class MyClass {
	public void sayHello(String name) {
		System.out.println("Hello, " + name + "!");
	}
}

public class ReflectionExample {
	public static void main(String[] args) throws Exception {
		// Get the class object for MyClass
		Class<?> myClass = MyClass.class;

		// Get the method named "sayHello" with a parameter of type String
		Method method = myClass.getMethod("sayHello", String.class);

		// Create an instance of MyClass
		Object obj = myClass.getDeclaredConstructor().newInstance();

		// Invoke the method dynamically
		method.invoke(obj, "John");
	}
}
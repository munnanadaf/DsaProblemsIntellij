package interview;

public class GarbageCollectionExample {
	static class MyClass {

		String name;

		MyClass(String name) {
			this.name = name;
		}

		@Override
		protected void finalize() throws Throwable {
			System.out.println(name + " is being deleted");
		}
	}

	static void createObjects() {
		MyClass obj1 = new MyClass("Object 1");
		MyClass obj2 = new MyClass("Object 2");

		obj1 = obj2; // creating cycle reference
		obj2 = obj1; // creating cycle reference

		obj1 = null;
		obj2 = null;
	}

	public static void main(String[] args) {
		createObjects();

		System.gc();

		System.out.println("Garbage collection finished...");
	}

}

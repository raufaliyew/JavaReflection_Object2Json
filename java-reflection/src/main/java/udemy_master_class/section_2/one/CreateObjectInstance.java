package udemy_master_class.section_2.one;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CreateObjectInstance {

    public static void main(String[] args)
            throws InvocationTargetException, InstantiationException, IllegalAccessException {

        Address address = createInstanceWithArguments(Address.class, "Narimanov", 10);
        Person person = createInstanceWithArguments(Person.class, address, "Ali", 20);

        System.out.println(person);
    }

    public static <T> T createInstanceWithArguments(Class<T> clazz, Object... args)
            throws InvocationTargetException, InstantiationException, IllegalAccessException {

        for (Constructor<?> constructor : clazz.getDeclaredConstructors()) {
            if (constructor.getParameterTypes().length == args.length) {
                return (T) constructor.newInstance(args);
            }
        }

        System.out.println("An appropriate constructor was not found");
        return null;
    }

    public static void printConstructData(Class<?> clazz) {
        Constructor<?>[] constructors = clazz.getDeclaredConstructors();
        System.out.println(String.format("class %s has %d declared constructors",
                clazz.getSimpleName(), constructors.length));

        for (Constructor<?> constructor : constructors) {
            Class<?>[] parameterTypes = constructor.getParameterTypes();

            List<String> parameterTypeNames = Arrays.stream(parameterTypes)
                    .map(Class::getSimpleName)
                    .collect(Collectors.toList());

            System.out.println(parameterTypeNames);
        }

    }


    public static class Person {
        private final Address address;
        private final String name;
        private final int age;


        public Person() {
            this.address = null;
            this.name = "anonymous";
            this.age = 0;
        }

        public Person(String name) {
            this.address = null;
            this.name = name;
            this.age = 0;
        }

        public Person(String name, int age) {
            this.address = null;
            this.name = name;
            this.age = age;
        }

        public Person(Address address, String name, int age) {
            this.address = address;
            this.name = name;
            this.age = age;
        }


        @Override
        public String toString() {
            return String.format("Person [address: %s, name: %s, age: %s]", address, name, age);
        }
    }

    public static class Address {
        private String street;
        private int number;

        public Address(String street, int number) {
            this.street = street;
            this.number = number;
        }


        @Override
        public String toString() {
            return String.format("Address [street: %s, number: %s]", street, number);
        }
    }
}

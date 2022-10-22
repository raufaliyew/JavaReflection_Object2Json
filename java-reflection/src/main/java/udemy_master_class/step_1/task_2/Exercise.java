package udemy_master_class.step_1.task_2;

import java.util.HashSet;
import java.util.Set;

public class Exercise {

    public static void main(String[] args) {
        findAllImplementedInterfaces(A.class).forEach(System.out::println);
    }
        
    /**
     * Returns all the interfaces that the current input class implements.
     * Note: If the input is an interface itself, the method returns all the interfaces the 
     * input interface extends.
     */
    public static Set<Class<?>> findAllImplementedInterfaces(Class<?> input) {
        Set<Class<?>> allImplementedInterfaces = new HashSet<>();
        
        Class<?>[] inputInterfaces = input.getInterfaces();


        for (Class<?> currentInterface : inputInterfaces) {
            allImplementedInterfaces.add(currentInterface);
            Set<Class<?>> extendedInterfaces = findAllImplementedInterfaces(currentInterface);
            allImplementedInterfaces.addAll(extendedInterfaces);
        }

        return allImplementedInterfaces;
    }
}
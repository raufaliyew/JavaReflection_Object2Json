package udemy_master_class.section_2.task1;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class Main {

    public static void main(String[] args){
        A a = createInstanceWithArguments(A.class);

        System.out.println(a);
    }

    public static <T> T createInstanceWithArguments(Class<T> clazz) {
        clazz.getMethods();


        return null;
    }


    public static interface A {
        void  printInterfaceName();
    }
}

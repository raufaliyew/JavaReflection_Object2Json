package udemy_master_class.section_2.task1;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

public class CreateInterfaceImplementation {
    public static void main(String[] args) {
        implementedInterface(A.class);
    }

    public static <T> void implementedInterface(Class<T> clazz) {
        T t = (T) Proxy.newProxyInstance(clazz.getClassLoader(), new Class<?>[] {clazz},
                (proxy, method, args) -> proxy);

        Method[] declaredMethods = t.getClass().getDeclaredMethods();

        Arrays.stream(declaredMethods).forEach(method -> System.out.println(method.getName()));
    }

    public interface A {
        void a();

        void b();

        void c();

    }
}

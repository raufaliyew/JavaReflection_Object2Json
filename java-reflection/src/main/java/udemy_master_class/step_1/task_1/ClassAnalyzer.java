package udemy_master_class.step_1.task_1;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class ClassAnalyzer {

    public static void main(String[] args) {
        System.out.println(createPopupTypeInfoFromClass(int.class));
        System.out.println(createPopupTypeInfoFromClass(Integer.class));
        System.out.println(createPopupTypeInfoFromClass(PopupTypeInfo.class));
        System.out.println(createPopupTypeInfoFromClass(Object.class));
        System.out.println(createPopupTypeInfoFromClass(Collection.class));
    }

    private static final List<String> JDK_PACKAGE_PREFIXES =
            Arrays.asList("com.sun.", "java", "javax", "jdk", "org.w3c", "org.xml");

    public static PopupTypeInfo createPopupTypeInfoFromClass(Class<?> inputClass) {
        PopupTypeInfo popupTypeInfo = new PopupTypeInfo();

        popupTypeInfo.setPrimitive(inputClass.isPrimitive())
                .setInterface(inputClass.isInterface())
                .setEnum(inputClass.isEnum())
                .setName(inputClass.getSimpleName())
                .setJdk(isJdkClass(inputClass))
                .addAllInheritedClassNames(getAllInheritedClassNames(inputClass));

        return popupTypeInfo;
    }

    /*********** Helper Methods ***************/

    public static boolean isJdkClass(Class<?> inputClass) {
        if (inputClass.getPackage() == null) return true;

        return JDK_PACKAGE_PREFIXES.contains(inputClass.getPackageName().split("\\.")[0]);
    }

    public static String[] getAllInheritedClassNames(Class<?> inputClass) {
        if (inputClass.isInterface()) {
            return Arrays.stream(inputClass.getInterfaces())
                    .map(Class::getSimpleName)
                    .toArray(String[]::new);
        }

        return inputClass.getSuperclass() ==
                null ? null : new String[]{inputClass.getSuperclass().getSimpleName()};
    }
}
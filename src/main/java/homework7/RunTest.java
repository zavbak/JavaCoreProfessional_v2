package homework7;

import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class RunTest {

    static Method methodBefore;
    static Method methodAfter;

    public static void start(Class aClass) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {

        List<Method> methods = Arrays.asList(aClass.getDeclaredMethods());

        Method methodBefore = null;
        Method methodAfter = null;

        for (Method method : methods) {
            if (method.getAnnotation(AfterSuite.class) != null) {
                if (methodAfter == null) {
                    methodAfter = method;
                } else {
                    throw new RuntimeException("AfterSuite more than one");
                }
            }

            if (method.getAnnotation(BeforeSuite.class) != null) {
                if (methodBefore == null) {
                    methodBefore = method;
                } else {
                    throw new RuntimeException("BeforeSuite more than one");
                }
            }
        }



        Object test = aClass.newInstance();

        methodBefore.invoke(test);

        methods.stream()
                .filter(method -> {
                    return method.getAnnotation(Test.class) == null ? false : true;
                })
                .sorted((o1, o2) -> {

                    int prior1 = o1.getAnnotation(Test.class).value();
                    int prior2 = o2.getAnnotation(Test.class).value();

                    if (prior1 == prior2) {
                        return 0;
                    }
                    return prior1 > prior2 ? 1 : -1;
                })
                .forEach(method -> {
                    try {
                        method.invoke(test);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    }

                });

        methodAfter.invoke(test);


    }
}

package classLoader;

import java.lang.reflect.Method;

/**
 * User: wangjie
 * Date: 14-2-26
 */
public class ClassLoaderTest {

    public void testClassIdentity() {
        String classDataRootPath = "d:\\workspace\\scalable_cache\\out\\production\\scalable_cache\\";
        FileSystemClassLoader fscl1 = new FileSystemClassLoader(classDataRootPath);
        FileSystemClassLoader fscl2 = new FileSystemClassLoader(classDataRootPath);

        String className = "classLoader.Sample";

        try {
            Class<?> class1 = fscl1.loadClass(className);
            Object obj1 = class1.newInstance();

            Class<?> class2 = fscl2.loadClass(className);
            Object obj2 = class2.newInstance();

            Method setSampleMethod = class1.getMethod("setSample", Object.class);
            setSampleMethod.invoke(obj1, obj2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ClassLoaderTest test = new ClassLoaderTest();
        test.testClassIdentity();
    }
}

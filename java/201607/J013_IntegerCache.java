//132 = 128 + 4;
//133 = 128 + 5;
//大致原理是：Integer对小数字 -128 ~ 127进行缓存
import java.lang.reflect.Field;
public class J013_IntegerCache {
    public static void main(String[] args) throws Exception {
        Class cache = Integer.class.getDeclaredClasses()[0];
        Field c = cache.getDeclaredField("cache");
        c.setAccessible(true);
        Integer[] array = (Integer[]) c.get(cache);
        array[132] = array[133];
        int i = 2;
        System.out.printf("%d+%d=%d\n", i, i, i + i);
        System.out.printf("%d+%d=%d\n", 1, 3, 1 + 3);
        System.out.printf("array[0]=%d\n", array[0]);
        System.out.printf("array[1]=%d\n", array[1]);
        System.out.printf("array[128]=%d\n", array[128]);
        System.out.printf("array[255]=%d\n", array[255]);
        System.out.printf("array length is %d\n", array.length);

    }
}

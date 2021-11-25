package Model.SinglePattern;
/**
 * 1. 懒加载：yes
 * 2. 线程安全：no
 *
 * */


public class Singleton_Method1 {
    // 构造方法私有化，因此其他类没办法通过new来创建对象
    private Singleton_Method1() {}

    private static Singleton_Method1 instance = null;

    public static Singleton_Method1 getInstance() {
        if (instance == null)
            instance = new Singleton_Method1();
        return instance;
    }
}

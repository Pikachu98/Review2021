package Model.SinglePattern;

public class Singleton_Method2 {
    private Singleton_Method2() {}

    private static Singleton_Method2 instance = null;

    public static synchronized Singleton_Method2 getInstance() {
        if (instance == null)
            instance = new Singleton_Method2();

        return instance;
    }
}

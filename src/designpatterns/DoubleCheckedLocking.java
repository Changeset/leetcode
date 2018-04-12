package designpatterns;

/**
 * @ Author: Xuelong Liao
 * @ Description:
 * @ Date: created in 10:26 2018/4/12
 * @ ModifiedBy:
 */
public class DoubleCheckedLocking {
    private volatile static Instance instance;
    public static Instance getInstance() {
        if (instance == null) {
            synchronized(DoubleCheckedLocking.class) {
                if (instance == null)
                    instance = new Instance();
            }
        }
        return instance;
    }
}

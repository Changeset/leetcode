package designpatterns;

/**
 * @ Author: Xuelong Liao
 * @ Description:
 * @ Date: created in 10:18 2018/4/12
 * @ ModifiedBy:
 */
public class SafetyLazyInitialization {

    private static Instance instance;
    public synchronized static Instance getInstance() {
        if (instance == null)
            instance = new Instance();
        return instance;
    }
}

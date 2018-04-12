package designpatterns;

/**
 * @ Author: Xuelong Liao
 * @ Description:
 * @ Date: created in 10:29 2018/4/12
 * @ ModifiedBy:
 */
public class InstanceFactory {
    private static class InstanceHolder {
        public static Instance instance = new Instance();
    }

    public static Instance getInstance() {
        return InstanceHolder.instance;
    }
}

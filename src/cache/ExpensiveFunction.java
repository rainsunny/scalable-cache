package cache;

/**
 * User: wangjie
 * Date: 14-2-24
 */
public class ExpensiveFunction implements Computable<String, Integer> {
    @Override
    public Integer compute(String arg) throws InterruptedException {
        // computing ...
        return new Integer(arg);
    }
}

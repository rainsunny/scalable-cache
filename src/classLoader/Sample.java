package classLoader;

/**
 * User: wangjie
 * Date: 14-2-26
 */
public class Sample {

    private Sample instance;

    public void setSample(Object obj) {
        instance = (Sample) obj;
    }
}

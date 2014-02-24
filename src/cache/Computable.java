package cache;

/**
 * User: wangjie
 * Date: 14-2-24
 */
public interface Computable<A, V> {
    V compute(A arg) throws InterruptedException;
}

package cache;

import java.util.Map;
import java.util.concurrent.*;

/**
 * User: wangjie
 * Date: 14-2-24
 */
public class Memoizer3<A, V> implements Computable<A, V> {

    private final Map<A, Future<V>> cache = new ConcurrentHashMap<A, Future<V>>();

    private final Computable<A, V> c;

    public Memoizer3(Computable<A, V> c) {
        this.c = c;
    }

    @Override
    public V compute(final A arg) throws InterruptedException {
        Future<V> f = cache.get(arg);
        if (f == null) {
            FutureTask<V> ft = new FutureTask<V>(new Callable<V>() {
                @Override
                public V call() throws Exception {
                    return c.compute(arg);
                }
            });
            f = ft;
            cache.put(arg, ft);
            ft.run();
        }
        try {
            return f.get();
        } catch (ExecutionException e) {
            e.printStackTrace();
            return null;
        }
    }
}

import java.util.Collection;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

public class CollectionUtils {
    public static <T, P extends Collection<T>> P collect(
            List<T> list,
            Supplier<P> collectionFactory,
            Function<T, Boolean> condition) {

        P result = collectionFactory.get();
        for (T item : list) {
            if (condition.apply(item)) {
                result.add(item);
            }
        }
        return result;
    }
}
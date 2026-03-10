import java.util.List;
import java.util.function.BinaryOperator;

public class ReductionUtils {
    public static <T> T reduce(List<T> list, BinaryOperator<T> operator, T identity) {
        if (list.isEmpty()) {
            return identity;
        }

        T result = identity;
        for (T item : list) {
            result = operator.apply(result, item);
        }
        return result;
    }
}
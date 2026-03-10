public class LineUtils {
    public static <T extends Point2D> void shiftLineX(Line<T> line) {
        T start = line.getStart();
        start.setX(start.getX() + 10);
    }
}
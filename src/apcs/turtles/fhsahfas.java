package apcs.turtles;


import java.awt.*;

public interface Rect implements Shape {

    @Override
    default Rectangle getBounds() {
        return null;
    }

    @Override
    default Rectangle2D getBounds2D() {
        return null;
    }

    @Override
    default boolean contains(double x, double y) {
        return false;
    }

    @Override
    default boolean contains(Point2D p) {
        return false;
    }

    @Override
    default boolean intersects(double x, double y, double w, double h) {
        return false;
    }

    @Override
    default boolean intersects(Rectangle2D r) {
        return false;
    }

    @Override
    default boolean contains(double x, double y, double w, double h) {
        return false;
    }

    @Override
    default boolean contains(Rectangle2D r) {
        return false;
    }

    @Override
    default PathIterator getPathIterator(AffineTransform at) {
        return null;
    }

    @Override
    default PathIterator getPathIterator(AffineTransform at, double flatness) {
        return null;
    }
}

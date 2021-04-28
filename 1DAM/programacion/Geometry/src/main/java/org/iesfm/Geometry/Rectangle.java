package org.iesfm.Geometry;

import java.util.Objects;

/**
 * Clase que define la forma geometrica concreta del rectangulo. Extiende la clase Shape. Esta compuesta por los siguientes campos:
 *
 * <ul>
 *     <li> Campos heredados de la clase abstracta Shape (colour, position).</li>
 *     <li> width: Define la longitud del ancho del rectangulo (double).</li>
 *     <li> height: Define la longitud de la altura del rectangulo (double).</li>
 * </ul>
 *
 * Metodos: implamenta los metodos abstractos de la clase Shape: showSpecificInfo, calculateArea, calculatePerimeter.
 */
public final class Rectangle extends Shape{
    private double widht;
    private double height;

    public Rectangle(String colour, Position position, double widht, double height) {
        super(colour, position);
        this.widht = widht;
        this.height = height;
    }

    @Override
    protected final void showSpecificInfo() {
        System.out.println("Soy un rectangulo:");
        System.out.println("Mi ancho mide: " + widht + " y mi altura mide: " + height);
    }

    @Override
    public final double calculateArea() {
        return widht * height;
    }

    @Override
    public final double calculatePerimeter() {
        return (2 * widht) + (2 * height);
    }

    public double getWidht() {
        return widht;
    }

    public void setWidht(double widht) {
        this.widht = widht;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Rectangle rectangle = (Rectangle) o;
        return Double.compare(rectangle.widht, widht) == 0 && Double.compare(rectangle.height, height) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), widht, height);
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "widht=" + widht +
                ", height=" + height +
                '}';
    }
}

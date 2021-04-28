package org.iesfm.Geometry;

import java.util.Objects;

/**
 * Clase que define la forma geometrica concreta del circulo. Extiende la clase Shape. Esta compuesta por los siguientes campos:
 *
 * <ul>
 *     <li> Campos heredados de la clase abstracta Shape (colour, position).</li>
 *     <li> radius: Define la longitud del radio del circulo (double).</li>
 * </ul>
 *
 * Metodos: implamenta los metodos abstractos de la clase Shape: showSpecificInfo, calculateArea, calculatePerimeter.
 */
public final class Circle extends Shape{
    private double radius;

    public Circle(String colour, Position position, double radius) {
        super(colour, position);
        this.radius = radius;
    }

    @Override
    protected final void showSpecificInfo() {
        System.out.println("Soy un circulo:");
        System.out.println("Mi radio mide: " + radius);
    }

    @Override
    public final double calculateArea() {
        return radius * radius * Math.PI;
    }

    @Override
    public final double calculatePerimeter() {
        return 2 * Math.PI * radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Circle circle = (Circle) o;
        return Double.compare(circle.radius, radius) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), radius);
    }

    @Override
    public String toString() {
        return "Circle{" +
                "radius=" + radius +
                '}';
    }
}

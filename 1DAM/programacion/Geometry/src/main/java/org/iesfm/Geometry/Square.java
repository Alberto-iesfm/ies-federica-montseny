package org.iesfm.Geometry;

import java.util.Objects;

/**
 * Clase que define la forma geometrica concreta del cuadrado. Extiende la clase Shape. Esta compuesta por los siguientes campos:
 *
 * <ul>
 *     <li> Campos heredados de la clase abstracta Shape (colour, position).</li>
 *     <li> side: Define la longitud de cada uno de los lados del cuadrado (double).</li>
 * </ul>
 *
 * Metodos: implamenta los metodos abstractos de la clase Shape: showSpecificInfo, calculateArea, calculatePerimeter.
 */
public final class Square extends Shape{
    private double side;

    public Square(String colour, Position position, double side) {
        super(colour, position);
        this.side = side;
    }

    @Override
    protected final void showSpecificInfo() {
        System.out.println("Soy un cuadrado:");
        System.out.println("Mis lados miden: " + side + " cada uno.");
    }

    @Override
    public final double calculateArea() {
        return side * side;
    }

    @Override
    public final double calculatePerimeter() {
        return 4 * side;
    }

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Square square = (Square) o;
        return Double.compare(square.side, side) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), side);
    }

    @Override
    public String toString() {
        return "Square{" +
                "side=" + side +
                '}';
    }
}

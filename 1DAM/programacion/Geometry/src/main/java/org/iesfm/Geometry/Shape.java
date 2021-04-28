package org.iesfm.Geometry;

import java.util.Objects;

/**
 * Clase abstracta que define una forma geometrica. Esta compuesta por los campos comunes a todas las formas geometricas que son:
 *
 * <ul>
 *     <li> colour: Define el color de la forma geometrica (String).</li>
 *     <li> position: Define las coordenadas en las que se encuentra la forma geometrica (Position).</li>
 * </ul>
 *
 * Metodos: showSpecificInfo, showInfo, calculateArea, calculatePerimeter.
 */
public abstract class Shape {
    private String colour;
    private Position position;

    public Shape(String colour, Position position) {
        this.colour = colour;
        this.position = position;
    }

    /**
     * Metodo abstracto que permite mostrar la informacion especifica de las fomras geometricas.
     */
    protected abstract void showSpecificInfo();

    /**
     * Permite mostrar la informacion comun de las formas geometricas.
     */
    public final void showInfo() {
        showSpecificInfo();
        System.out.println("Soy de color: " + colour);
        System.out.println("Y me encuentro en la posicion: X:" + position.getX() + ", Y:" + position.getY());
        System.out.println();
    }

    /**
     * Metodo abstracto que permite calcular el area de la forma geometrica.
     *
     * @return El area de la forma geometrica (double).
     */
    public abstract double calculateArea();

    /**
     * Metodo abstracto que permite calcular el perimetro de la forma geometrica.
     *
     * @return El perimetro de la forma geometrica (double).
     */
    public abstract double calculatePerimeter();

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Shape shape = (Shape) o;
        return Objects.equals(colour, shape.colour) && Objects.equals(position, shape.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(colour, position);
    }

    @Override
    public String toString() {
        return "Shape{" +
                "colour='" + colour + '\'' +
                ", position=" + position +
                '}';
    }
}

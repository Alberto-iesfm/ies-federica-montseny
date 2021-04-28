import org.iesfm.Geometry.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

public class ShapeTest {
    private final double DELTA = 0.00000001;

    private List<Shape> shapes = new LinkedList<>();

    @Before
    public void setUp(){
        shapes.add(new Square("Rojo", new Position(2.5, 4.7), 5));
        shapes.add(new Rectangle("Azul", new Position(3.7, 9.8), 4, 6));
        shapes.add(new Circle("Amarillo", new Position(3.2, 7.1), 2.7));
    }

    @Test
    public void showInfoTest(){
        for (Shape shape:shapes){
            shape.showInfo();
        }
    }

    @Test
    public void calculateAreaTest(){
        Assert.assertEquals(25, shapes.get(0).calculateArea(), DELTA);
        Assert.assertEquals(24, shapes.get(1).calculateArea(), DELTA);
        Assert.assertEquals(2.7 * 2.7 * Math.PI, shapes.get(2).calculateArea(), DELTA);
    }

    @Test
    public void calculatePerimeterTest(){
        Assert.assertEquals(20, shapes.get(0).calculatePerimeter(), DELTA);
        Assert.assertEquals(20, shapes.get(1).calculatePerimeter(), DELTA);
        Assert.assertEquals(5.4 * Math.PI, shapes.get(2).calculatePerimeter(), DELTA);
    }

}

package com.chubanova.move;

import com.chubanova.StarShip;
import org.junit.Assert;
import org.junit.Test;

public class MoveStarShipTest {
    @Test
    public void moveTest(){
        StarShip starShip  = new StarShip();
        starShip.setProperty("Position", new Vector(12,5));
        starShip.setProperty("Velocity", new Vector(-7,3));
        starShip.setProperty("isBroke", false);

        MovableAdapter movableAdapter = new MovableAdapter(starShip);
        Move move = new Move(movableAdapter);
        move.execute();
        Vector v = (Vector) starShip.getProperty("Position");
        Assert.assertEquals(5.0,v.getX(), 0.0);
        Assert.assertEquals(8.0,v.getY(),0.0);
    }


    @Test(expected = RuntimeException.class)
    public void moveTest_no_position(){
        StarShip starShip  = new StarShip();
        starShip.setProperty("Velocity", new Vector(-7,3));

        MovableAdapter movableAdapter = new MovableAdapter(starShip);
        Move move = new Move(movableAdapter);
        move.execute();
    }

    @Test(expected = RuntimeException.class)
    public void moveTest_no_velocity(){
        StarShip starShip  = new StarShip();
        starShip.setProperty("Position", new Vector(12,5));

        MovableAdapter movableAdapter = new MovableAdapter(starShip);
        Move move = new Move(movableAdapter);
        move.execute();
    }

    @Test(expected = RuntimeException.class)
    public void moveTest_is_broke(){
        StarShip starShip  = new StarShip();
        starShip.setProperty("Position", new Vector(12,5));
        starShip.setProperty("Velocity", new Object());

        MovableAdapter movableAdapter = new MovableAdapter(starShip);
        Move move = new Move(movableAdapter);
        move.execute();
    }
}

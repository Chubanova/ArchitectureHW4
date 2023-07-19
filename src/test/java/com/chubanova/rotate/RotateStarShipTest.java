package com.chubanova.rotate;

import com.chubanova.StarShip;
import org.junit.Assert;
import org.junit.Test;

public class RotateStarShipTest {
    @Test
    public void rotateTest(){
        StarShip starShip  = new StarShip();
        starShip.setProperty("Direction", 1);
        starShip.setProperty("AngularVelocity", 2);
        starShip.setProperty("DirectionsNumber", 1);

        RotatableAdapter rotatableAdapter = new RotatableAdapter(starShip);
        Rotate rotate = new Rotate(rotatableAdapter);
        rotate.execute();

        Assert.assertEquals(0,starShip.getProperty("Direction"));

        

    }

    @Test
    public void rotateTest_2(){
        StarShip starShip  = new StarShip();
        starShip.setProperty("Direction", 10);
        starShip.setProperty("AngularVelocity", 1);
        starShip.setProperty("DirectionsNumber", 3);

        RotatableAdapter rotatableAdapter = new RotatableAdapter(starShip);
        Rotate rotate = new Rotate(rotatableAdapter);
        rotate.execute();

        Assert.assertEquals(2,starShip.getProperty("Direction"));



    }
}

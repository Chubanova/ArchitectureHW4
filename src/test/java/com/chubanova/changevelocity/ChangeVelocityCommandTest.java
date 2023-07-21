package com.chubanova.changevelocity;

import com.chubanova.Command;
import com.chubanova.StarShip;
import com.chubanova.fuel.BurnFuelCommand;
import com.chubanova.fuel.FuelAdapter;
import com.chubanova.move.Vector;
import org.junit.Test;

import static org.junit.Assert.*;

public class ChangeVelocityCommandTest {

    @Test
    public void execute() {

        StarShip starShip  = new StarShip();
        starShip.setProperty("Direction", 1);
        starShip.setProperty("DirectionsNumber", 3);
        starShip.setProperty("Velocity", new Vector(100,0));

        ChangeVelocityAble changeVelocityAble = new ChangeVelocityAdapter(starShip);
        Command command = new ChangeVelocityCommand(changeVelocityAble);

        command.execute();
        Vector v = (Vector) starShip.getProperty("Velocity");
        assertEquals(-49.0, v.getX(),0.0);
        assertEquals(86.0, v.getY(),0.0);


    }
}
package com.chubanova.fuel;

import com.chubanova.Command;
import com.chubanova.StarShip;
import com.chubanova.move.Vector;
import org.junit.Test;

import static org.junit.Assert.*;

public class BurnFuelCommandTest {

    @Test
    public void burn() {
        StarShip starShip  = new StarShip();
        starShip.setProperty("Fuel", 10);

        FuelAdapter fuelAdapter = new FuelAdapter(starShip);
        Command command = new BurnFuelCommand(fuelAdapter, 10);

        command.execute();

        assertEquals(0, fuelAdapter.getFuel());


    }
}
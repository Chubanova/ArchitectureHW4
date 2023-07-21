package com.chubanova.fuel;

import com.chubanova.Command;
import com.chubanova.StarShip;
import com.chubanova.exception.CommandException;
import org.junit.Test;

import static org.junit.Assert.*;

public class CheckFuelCommandTest {

    @Test
    public void fuel() {
        StarShip starShip  = new StarShip();
        starShip.setProperty("Fuel", 10);

        FuelAdapter fuelAdapter = new FuelAdapter(starShip);
        Command command = new CheckFuelCommand(fuelAdapter, 10);

        command.execute();

        assertEquals(10, fuelAdapter.getFuel());


    }

    @Test(expected = CommandException.class)
    public void fuel_exception() {
        StarShip starShip  = new StarShip();
        starShip.setProperty("Fuel", 9);

        FuelAdapter fuelAdapter = new FuelAdapter(starShip);
        Command command = new CheckFuelCommand(fuelAdapter, 10);

        command.execute();

    }

}
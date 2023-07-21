package com.chubanova;

import com.chubanova.exception.CommandException;
import com.chubanova.fuel.BurnFuelCommand;
import com.chubanova.fuel.CheckFuelCommand;
import com.chubanova.fuel.Fuel;
import com.chubanova.fuel.FuelAdapter;
import com.chubanova.move.Movable;
import com.chubanova.move.MovableAdapter;
import com.chubanova.move.Move;
import com.chubanova.move.Vector;
import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

import static org.junit.Assert.*;

public class MacroCommandTest {
    @Test
    public void moveAndBurnFuel(){
        StarShip starShip  = new StarShip();
        starShip.setProperty("Position", new Vector(12,5));
        starShip.setProperty("Velocity", new Vector(-7,3));
        starShip.setProperty("Fuel", 10);
        Fuel fuel = new FuelAdapter(starShip);
        Movable movable = new MovableAdapter(starShip);


        Command checkFuel = new CheckFuelCommand(fuel,1);
        Command move = new Move(movable);
        Command burnFuel = new BurnFuelCommand(fuel, 1);
        Queue<Command> commands = new LinkedList<>();
        commands.add(checkFuel);
        commands.add(move);
        commands.add(burnFuel);

        MacroCommand macroCommand = new MacroCommand(commands);
        macroCommand.execute();

        assertEquals(9, starShip.getProperty("Fuel"));
        Vector v = (Vector) starShip.getProperty("Position");
        Assert.assertEquals(5.0,v.getX(), 0.0);
        Assert.assertEquals(8.0,v.getY(),0.0);
    }


    @Test(expected = CommandException.class)
    public void moveAndBurnFuel_exception(){
        StarShip starShip  = new StarShip();
        starShip.setProperty("Position", new Vector(12,5));
        starShip.setProperty("Velocity", new Vector(-7,3));
        starShip.setProperty("Fuel", 3);
        Fuel fuel = new FuelAdapter(starShip);
        Movable movable = new MovableAdapter(starShip);


        Command checkFuel = new CheckFuelCommand(fuel,5);
        Command move = new Move(movable);
        Command burnFuel = new BurnFuelCommand(fuel, 5);
        Queue<Command> commands = new LinkedList<>();
        commands.add(checkFuel);
        commands.add(move);
        commands.add(burnFuel);

        MacroCommand macroCommand = new MacroCommand(commands);
        macroCommand.execute();

    }

}
package br.com.trains.model;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by manuele on 28/11/16.
 */
public class TownTest {

    @Test
    public void distanceToNeighbor()
    {
        Town townA = new Town('A');
        Town townB = new Town('B');
        int distance = 1;
        Route route = new Route(townB, distance);
        townA.addNeighbor(route);

        Assert.assertEquals(townA.distanceToNeighbor(townB), distance);
    }

    @Test
    public void equalsTown()
    {
        Town townA = new Town('A');
        Town townB = new Town('A');

        Assert.assertTrue(townA.equals(townB));
    }

    @Test
    public void notEqualsTown()
    {
        Town townA = new Town('A');
        Town townB = new Town('B');

        Assert.assertFalse(townA.equals(townB));
    }
}

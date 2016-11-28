package br.com.trains.model;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Stream;

/**
 * Created by manuele on 27/11/16.
 */
public class Town implements Comparable<Town>
{
    private char name;
    private List<Route> neighbors;
    private int minDistance = Integer.MAX_VALUE;

    public Town(char name)
    {
        this.name = name;
        this.neighbors = new ArrayList<Route>();
    }

    public int distanceToNeighbor(Town town)
    {
        for (Route route: neighbors) {
            if(route.getTownTarget().equals(town))
            {
                return route.getWeight();
            }
        }

        return -1;
    }

    public void addNeighbor(Route route)
    {
        getNeighbors().add(route);
    }

    public int compareTo(Town town) {
        int minDistanceOther = town.getMinDistance();
        return Integer.compare(minDistance, minDistanceOther);
    }

    private List<Route> getNeighbors() {
        return neighbors;
    }

    public char getName() {
        return name;
    }

    public int getMinDistance() {
        return minDistance;
    }
}

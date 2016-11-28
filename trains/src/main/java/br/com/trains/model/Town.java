package br.com.trains.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by manuele on 27/11/16.
 */
public class Town
{
    private char name;
    private List<Route> neighbors;
    private boolean visited;

    public Town(char name)
    {
        this.visited = false;
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

    @Override
    public boolean equals(Object o) {
        Town other = (Town)o;
        return this.getName() == other.getName();
    }

    public void addNeighbor(Route route)
    {
        getNeighbors().add(route);
    }

    public List<Route> getNeighbors() {
        return neighbors;
    }

    public char getName() {
        return name;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public boolean isVisited() {
        return visited;
    }
}

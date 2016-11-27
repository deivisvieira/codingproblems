package br.com.trains.model;

/**
 * Created by manuele on 27/11/16.
 */
public class Town implements Comparable<Town>
{
    private String name;
    private Edge[] neighbors;
    private int minDistance = Integer.MAX_VALUE;

    public Town(String name)
    {
        this.name = name;
    }

    public int compareTo(Town town) {
        int minDistanceOther = town.getMinDistance();
        return Integer.compare(minDistance, minDistanceOther);
    }

    public Edge[] getNeighbors() { return neighbors; }

    public int getMinDistance() {
        return minDistance;
    }
}

package br.com.trains.model;

/**
 * Created by manuele on 27/11/16.
 */
public class Route {

    public Town townTarget;
    public int weight;

    public Route(Town townTarget, int weight)
    {
        this.townTarget = townTarget;
        this.weight = weight;
    }

    public Town getTownTarget() {
        return townTarget;
    }

    public int getWeight() {
        return weight;
    }
}

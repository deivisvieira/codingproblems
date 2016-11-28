package br.com.trains.business;

import br.com.trains.model.Graph;
import br.com.trains.model.Route;
import br.com.trains.model.Town;

import java.util.List;

/**
 * Created by manuele on 28/11/16.
 */
public class FindRoute {

    private Graph graph;

    public FindRoute(Graph graph)
    {
        this.graph = graph;
    }

    public String countTrips(char source, char target, int max)
    {
        Town sourceTown = graph.findTown(source);
        Town targetTown = graph.findTown(target);

        int numRoutes = 0;
        final List<Route> neighbors = sourceTown.getNeighbors();
        for (Route neighbor: neighbors)
        {
            int weightActual = neighbor.getWeight();
            numRoutes += findNumRoutesWeight(neighbor.getTownTarget(), targetTown, weightActual, max);
        }

        return String.valueOf(numRoutes);
    }

    private int findNumRoutesWeight(Town actual, Town target, int weightActual, int max)
    {
        int numRoutes = 0;
        if( weightActual < max )
        {
            if (actual.equals(target))
            {
                numRoutes++;
            }

            List<Route> neighbors = actual.getNeighbors();
            for (Route neighbor : neighbors)
            {
                int weightUpdated = weightActual + neighbor.getWeight();
                numRoutes += findNumRoutesWeight(neighbor.getTownTarget(), target, weightUpdated, max);
            }
        }

        return numRoutes;
    }

    public String calculateShortestRoute(char source, char target)
    {
        Town sourceTown = graph.findTown(source);
        Town targetTown = graph.findTown(target);

        int shortestRote = Integer.MAX_VALUE;
        final List<Route> neighbors = sourceTown.getNeighbors();
        for (Route neighbor: neighbors)
        {
            int actualShortestRote = findShortest(neighbor, targetTown);
            if(shortestRote> actualShortestRote)
                shortestRote = actualShortestRote;
        }

        return String.valueOf(shortestRote);
    }

    public int findShortest(Route actual, Town targetTown)
    {
        int initShortestRote = actual.getWeight();
        Town actualTarget = actual.getTownTarget();
        actualTarget.setVisited(true);
        if(actualTarget.equals(targetTown))
        {
            actualTarget.setVisited(false);
            return initShortestRote;
        }

        int shortestRote = Integer.MAX_VALUE;
        final List<Route> neighbors = actualTarget.getNeighbors();
        for (Route neighbor: neighbors)
        {
            if(!neighbor.getTownTarget().isVisited())
            {
                int actualShortestRote = initShortestRote+findShortest(neighbor, targetTown);
                if(shortestRote > actualShortestRote)
                    shortestRote = actualShortestRote;
            }
        }

        actualTarget.setVisited(false);
        return shortestRote;
    }

    public String calculateNumberTrips(char source, char target, int max, boolean exact)
    {
        Town sourceTown = graph.findTown(source);
        Town targetTown = graph.findTown(target);

        int numRoutes = 0;
        final List<Route> neighbors = sourceTown.getNeighbors();
        for (Route neighbor: neighbors)
        {
            numRoutes += findNumRoutes(neighbor.getTownTarget(), targetTown, 1, max, exact);
        }

        return String.valueOf(numRoutes);
    }

    private int findNumRoutes(Town actual, Town target, int actualDistance, int max, boolean exact)
    {
        int numRoutes = 0;
        if (actual.equals(target) && (!exact || actualDistance == max))
        {
            numRoutes++;
        }

        if ( actualDistance+1 <= max)
        {
            List<Route> neighbors = actual.getNeighbors();
            if(!neighbors.isEmpty())
            {
                actualDistance++;
                for (Route neighbor : neighbors)
                {
                    numRoutes += findNumRoutes(neighbor.getTownTarget(), target, actualDistance, max, exact);
                }
            }
        }

        return numRoutes;
    }

    public String calculateDistance(String routeToCalculate)
    {
        int distace = 0;
        char[] towns = routeToCalculate.toCharArray();
        for (int i=0; i < towns.length-1;)
        {
            Town source = graph.findTown(towns[i]);
            Town target = graph.findTown(towns[++i]);

            int distaceTarget = source.distanceToNeighbor(target);
            if( distaceTarget > 0 )
                distace+=distaceTarget;
            else
                return "NO SUCH ROUTE";
        }

        return String.valueOf(distace);
    }

}

package br.com.trains.model;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

/**
 * Created by manuele on 27/11/16.
 */
public class Graph {

    final List<Town> towns;

    public Graph(String[] townsStr)
    {
        towns = new ArrayList<Town>();
        createGraph(townsStr);
    }

    public String calculateNumberTrips(char source, char target, int max, boolean exact)
    {
        Town sourceTown = findTown(source);
        Town targetTown = findTown(target);

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
            Town source = findTown(towns[i]);
            Town target = findTown(towns[++i]);

            int distaceTarget = source.distanceToNeighbor(target);
            if( distaceTarget > 0 )
                distace+=distaceTarget;
            else
                return "NO SUCH ROUTE";
        }

        return String.valueOf(distace);
    }

    public void createGraph(String[] graph)
    {
        for (String route : graph)
        {
            final char source = route.charAt(0);
            final char target = route.charAt(1);
            final int weight = Character.getNumericValue(route.charAt(2));

            Town sourceT = findTown(source);
            Town targetT = findTown(target);

            if(sourceT == null)
            {
                sourceT = new Town(source);
                towns.add(sourceT);
            }

            if(targetT == null)
            {
                targetT = new Town(target);
                towns.add(targetT);
            }

            final Route routeObj = new Route(targetT, weight);
            sourceT.addNeighbor(routeObj);
        }
    }

    public Town findTown(char town)
    {
        for (Town t : towns)
            if(t.getName() == town)
                return t;

        return null;
    }

    public List<Town> getTowns()
    {
        return towns;
    }
}

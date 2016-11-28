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

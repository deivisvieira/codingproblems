package br.com.trains.model;

import br.com.trains.model.Graph;
import br.com.trains.model.Route;
import br.com.trains.model.Town;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by manuele on 28/11/16.
 */
public class GraphTest {

    @Test
    public void findTownEmptyGraph()
    {
        Graph graph = new Graph(new String[]{});
        Assert.assertNull(graph.findTown('A'));
    }

    @Test
    public void findTownNonEmptyGraph()
    {
        Graph graph = new Graph(new String[]{"AB1"});
        Assert.assertEquals(graph.findTown('A').getName(), 'A');
        Assert.assertEquals(graph.findTown('B').getName(), 'B');
    }

    @Test
    public void createGraph()
    {
        Graph graph = new Graph(new String[]{"AB1"});
        Assert.assertEquals(graph.getTowns().size(), 2);

        Town townA = graph.findTown('A');
        Assert.assertEquals(townA.getName(), 'A');

        Route neighbor = townA.getNeighbors().get(0);
        Assert.assertEquals(neighbor.getTownTarget().getName(), 'B');
        Assert.assertEquals(neighbor.getWeight(), 1);
    }
}

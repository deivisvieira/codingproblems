package br.com.trains;

import br.com.trains.business.FindRoute;
import br.com.trains.model.Graph;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by manuele on 27/11/16.
 */
public class Main {

    public static void main(String[] args)
    {
        final String fileName = "/home/manuele/workspace/codingproblems/trains/src/main/resources/input.txt";

        try (Stream<String> stream = Files.lines(Paths.get(fileName)))
        {
            List graphs = stream.map(line -> line.split(", ")).collect(Collectors.toList());
            for (Object graphObj : graphs)
            {
                final String[] graph = (String[]) graphObj;
                Graph graphTrain = new Graph(graph);
                FindRoute findRoute = graphTrain.getFindRoute();

                printOutput( 1, findRoute.calculateDistance("ABC") );
                printOutput( 2, findRoute.calculateDistance("AD") );
                printOutput( 3, findRoute.calculateDistance("ADC") );
                printOutput( 4, findRoute.calculateDistance("AEBCD") );
                printOutput( 5, findRoute.calculateDistance("AED") );

                printOutput( 6, findRoute.calculateNumberTrips('C', 'C', 3, false) );
                printOutput( 7, findRoute.calculateNumberTrips('A', 'C', 4, true) );

                printOutput( 8, findRoute.calculateShortestRoute('A', 'C') );
                printOutput( 9, findRoute.calculateShortestRoute('B', 'B') );

                printOutput( 10, findRoute.countTrips('C', 'C', 30) );
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    private static void printOutput(int position, String value)
    {
        final String output = String.format("Output #%s: %s", position, value);
        System.out.println(output);
    }
}

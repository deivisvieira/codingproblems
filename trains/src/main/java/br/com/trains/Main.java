package br.com.trains;

import br.com.trains.model.Graph;
import br.com.trains.model.Route;
import br.com.trains.model.Town;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
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

                printOutput( 1, graphTrain.calculateDistance("ABC") );
                printOutput( 2, graphTrain.calculateDistance("AD") );
                printOutput( 3, graphTrain.calculateDistance("ADC") );
                printOutput( 4, graphTrain.calculateDistance("AEBCD") );
                printOutput( 5, graphTrain.calculateDistance("AED") );

                //output 6

                //output 7

                //output 8

                //output 9

                //output 10
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

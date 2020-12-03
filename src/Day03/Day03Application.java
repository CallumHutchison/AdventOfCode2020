import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Day03Application {
    private static final char TREE_CHARACTER = '#';
    
    public static void main(String[] args) throws IOException{
        boolean[][] terrain = LoadInput("input.txt");
        TobogganPathfinder pathFinder = new TobogganPathfinder(terrain);

        long trees = pathFinder.CountTreesInPath(3, 1);
        System.out.println(String.format("Encountered %d trees in the toboggan path for part one", trees));

        trees *= pathFinder.CountTreesInPath(1, 1);
        trees *= pathFinder.CountTreesInPath(5, 1);
        trees *= pathFinder.CountTreesInPath(7, 1);
        trees *= pathFinder.CountTreesInPath(1, 2);
        System.out.println(String.format("Multiplying all paths for part two gives a total of %d", trees));
    }

    private static boolean[][] LoadInput(String filePath) throws IOException{
        BufferedReader reader = new BufferedReader(new FileReader(new File(filePath)));
        List<boolean[]> terrain = new ArrayList<>();

        while(reader.ready()) {
            String line = reader.readLine();

            if(line.length() == 0) {
                continue;
            }

            boolean[] lineTerrain = new boolean[line.length()];
            
            for(int i = 0; i < line.length(); i++) {
                lineTerrain[i] = line.charAt(i) == TREE_CHARACTER;
            }

            terrain.add(lineTerrain);
        }

        return terrain.toArray(new boolean[0][]);
    }
}
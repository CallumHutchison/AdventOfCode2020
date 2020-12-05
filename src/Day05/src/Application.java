import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Application {

    public static void main(String[] args) throws IOException {
        List<String> inputs = getInputs("input.txt");
        int highestId = 0;
        BoardingPassScanner scanner = new BoardingPassScanner(7,3);
        for(String input : inputs) {
            int id = scanner.getSeatId(input);
            if(id > highestId) {
                highestId = id;
            }
        }

        System.out.printf("The highest id found in the input file was %d%n", highestId);

        Set<Integer> ids = new HashSet<>();
        for(String input : inputs) {
            ids.add(scanner.getSeatId(input));
        }

        List<Integer> missingSeats = new ArrayList<>();
        for(int row = 0; row < 128; row++) {
            for(int col = 0; col < 8; col++) {
                int id = row * 8 + col;
                if(!ids.contains(id)) {
                    missingSeats.add(id);
                }
            }
        }

        for(int i = 1; i < missingSeats.size() - 1; i++) {
            int id = missingSeats.get(i);
            int left = missingSeats.get(i-1);
            int right = missingSeats.get(i+1);
            if(left != id - 1 && right != id + 1) {
                System.out.printf("Your seat is %d%n", id);
            }
        }
    }

    public static List<String> getInputs(String filePath) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(new File(filePath)));
        List<String> lines = new ArrayList<>();

        while(reader.ready()) {
            lines.add(reader.readLine());
        }

        return lines;
    }
}

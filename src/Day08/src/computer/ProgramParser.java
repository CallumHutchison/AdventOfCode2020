package computer;

import computer.operations.Operation;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ProgramParser {

    public static List<Operation> parseFromFile(File file) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(file));

        List<Operation> operations = new ArrayList<>();
        while (reader.ready()) {
            operations.add(Operation.parse(reader.readLine()));
        }

        reader.close();

        return operations;
    }
}

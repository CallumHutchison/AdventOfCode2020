import computer.Computer;
import computer.ComputerState;
import computer.ProgramParser;
import computer.operations.AccumulatorOperation;
import computer.operations.JumpOperation;
import computer.operations.NoOperation;
import computer.operations.Operation;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class Application {

    public static void main(String[] args) throws IOException {
        partOne();
        partTwo();
    }

    public static void partOne() throws IOException {
        Computer computer = new Computer(new File("input.txt"));

        int accumulator = computer.run();

        System.out.printf("Part1: Final value of accumulator before infinite loop was %d%n", accumulator);
    }

    public static void partTwo() throws IOException {
        List<Operation> operations = ProgramParser.parseFromFile(new File("input.txt"));

        for (int i = 0; i < operations.size(); i++) {
            Operation original = operations.get(i);
            if (!(original instanceof AccumulatorOperation)) {
                operations.set(i, original instanceof JumpOperation ?
                        new NoOperation(original.getArgument()) : new JumpOperation(original.getArgument()));
                Computer computer = new Computer(operations);
                if (computer.willTerminate()) {
                    System.out.printf("Accumulator's final value when running fixed program: %d%n", computer.run());
                    break;
                } else {
                    operations.set(i, original);
                }

            }
        }
    }
}

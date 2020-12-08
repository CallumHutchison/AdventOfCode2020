package computer;


import computer.operations.Operation;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Computer {
    private final List<Operation> operations;
    private ComputerState state;

    public Computer(File file) throws IOException {
        this(ProgramParser.parseFromFile(file));
    }

    public Computer(List<Operation> operations) {
        this.operations = operations;
        this.state = new ComputerState(0, 0);
    }

    public boolean willTerminate() {
        run();
        return hasTerminated();
    }

    public int run() {
        Set<Integer> visitedOperations = new HashSet<>();
        state = new ComputerState(0, 0);
        int accumulator = 0;
        while (!(visitedOperations.contains(state.getCurrentInstruction()) || hasTerminated())) {
            accumulator = state.getAccumulator();

            visitedOperations.add(state.getCurrentInstruction());
            state = step();
        }

        if (hasTerminated()) {
            return state.getAccumulator();
        } else {
            return accumulator;
        }
    }

    public ComputerState step() {
        state = operations.get(state.getCurrentInstruction()).perform(state);
        return state;
    }

    public ComputerState getState() {
        return state;
    }

    public boolean hasTerminated() {
        return state.getCurrentInstruction() >= operations.size();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Operation operation : operations) {
            sb.append(operation.toString());
            sb.append("\n");
        }
        return sb.toString();
    }
}

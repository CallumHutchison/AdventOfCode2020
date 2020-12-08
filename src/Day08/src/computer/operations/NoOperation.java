package computer.operations;

import computer.ComputerState;

public class NoOperation implements Operation {

    private final int argument;

    public NoOperation(final int argument) {
        this.argument = argument;
    }

    @Override
    public ComputerState perform(ComputerState currentState) {
        return new ComputerState(currentState.getAccumulator(), currentState.getCurrentInstruction() + 1);
    }

    @Override
    public int getArgument() {
        return argument;
    }

    @Override
    public String toString() {
        return "nop " + argument;
    }
}

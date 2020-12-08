package computer.operations;

import computer.ComputerState;

public class AccumulatorOperation implements Operation{

    private final int argument;

    public AccumulatorOperation(final int argument) {
        this.argument = argument;
    }

    @Override
    public ComputerState perform(ComputerState currentState) {
        return new ComputerState(currentState.getAccumulator() + argument, currentState.getCurrentInstruction() + 1);
    }

    @Override
    public int getArgument() {
        return argument;
    }

    @Override
    public String toString() {
        return "acc " + argument;
    }

}

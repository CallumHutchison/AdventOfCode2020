package computer.operations;

import computer.ComputerState;

public class JumpOperation implements Operation {

    private final int argument;

    public JumpOperation(final int argument) {
        this.argument = argument;
    }

    @Override
    public ComputerState perform(ComputerState currentState) {
        return new ComputerState(currentState.getAccumulator(), currentState.getCurrentInstruction() + argument);
    }

    @Override
    public int getArgument() {
        return argument;
    }

    @Override
    public String toString() {
        return "jmp " + argument;
    }

}

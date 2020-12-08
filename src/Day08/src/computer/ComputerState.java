package computer;

public class ComputerState {

    private final int accumulator;
    private final int currentInstruction;

    public ComputerState(final int accumulator, final int currentInstruction) {
        this.accumulator = accumulator;
        this.currentInstruction = currentInstruction;
    }

    public int getAccumulator() {
        return accumulator;
    }

    public int getCurrentInstruction() {
        return currentInstruction;
    }
}

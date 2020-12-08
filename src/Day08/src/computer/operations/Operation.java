package computer.operations;

import computer.ComputerState;

public interface Operation {

    ComputerState perform(ComputerState currentState);

    int getArgument();

    static Operation parse(String line) {
        String[] split = line.split(" ");
        switch (split[0]) {
            case "nop" : {
                return new NoOperation(Integer.parseInt(split[1]));
            }
            case "jmp" : {
                return new JumpOperation(Integer.parseInt(split[1]));
            }
            case "acc" : {
                return new AccumulatorOperation(Integer.parseInt(split[1]));
            }
            default: {
                throw new RuntimeException("Operation " + split[0] + " does not exist");
            }
        }
    }
}

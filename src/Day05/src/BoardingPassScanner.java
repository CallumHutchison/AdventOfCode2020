public class BoardingPassScanner {

    private int rowPower;
    private int colPower;

    public BoardingPassScanner(int rowPower, int colPower) {
        this.rowPower = rowPower;
        this.colPower = colPower;
    }

    public int getSeatId(String line) {
        return (getRow(line.substring(0,rowPower)) * 8) + getColumn(line.substring(line.length() - colPower));
    }

    public int getRow(String line) {
        int row = 0;
        for(int i = 0; i < rowPower; i++) {
            row += (int)Math.pow(2,rowPower - i) * (line.charAt(i) == 'F' ? 0 : 0.5f);
        }
        return row;
    }

    public int getColumn(String line) {
        int column = 0;
        for(int i = 0; i < colPower; i++) {
            column += (int)Math.pow(2,colPower - i) * (line.charAt(i) == 'L' ? 0 : 0.5f);
        }
        return column;
    }
}

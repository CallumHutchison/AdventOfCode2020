import org.junit.Test;

public class BoardingPassScannerTest {

    @Test
    public void seatIdTwoRowsTwoColumnsTestZero() {
        BoardingPassScanner scanner = new BoardingPassScanner(1,1);
        assert(scanner.getSeatId("FL") == 0);
    }

    @Test
    public void seatIdTwoRowsTwoColumnsTest() {
        BoardingPassScanner scanner = new BoardingPassScanner(1,1);
        assert(scanner.getSeatId("BL") == 8);
    }

    @Test
    public void seatIdSevenRowsThreeColumnsTest() {
        BoardingPassScanner scanner = new BoardingPassScanner(7,3);
        assert(scanner.getSeatId("FBFBBFFRLR") == 357);
    }

    @Test
    public void columnSevenRowsThreeColumnsTest() {
        BoardingPassScanner scanner = new BoardingPassScanner(7,3);
        assert(scanner.getColumn("RLR") == 5);
    }

    @Test
    public void rowSevenRowsThreeColumnsTest() {
        BoardingPassScanner scanner = new BoardingPassScanner(7,3);
        assert(scanner.getRow("FBFBBFF") == 44);
    }
}

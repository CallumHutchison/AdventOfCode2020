public class BagCount {
    private final String bagType;
    private final int count;

    public BagCount(final String bagType, final int count) {
        this.bagType = bagType;
        this.count = count;
    }

    public String getBagType() {
        return bagType;
    }

    public int getCount() {
        return count;
    }
}


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LuggageHandler {

    private HashMap<String, List<BagCount>> bags;

    public LuggageHandler(String filePath) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(new File(filePath)));
        bags = new HashMap<>();

        while(reader.ready()) {
            String[] line = reader.readLine().split(" bags contain ");
            if(line.length < 2) {
                continue;
            }

            String bag = line[0].replace("bags", "").trim();
            String[] subBags = line[1].split(", ");

            List<BagCount> containedBags = new ArrayList<>();
            for(String subBag : subBags) {
                if(subBag.contains("no other")) {
                    continue;
                }

                String[] split = subBag.trim().split(" ");
                int count = Integer.parseInt(split[0]);
                String bagType = split[1] + " " + split[2];
                containedBags.add(new BagCount(bagType, count));
            }

            bags.put(bag, containedBags);
        }
    }

    public LuggageHandler(HashMap<String, List<BagCount>> bags) {
        this.bags = bags;
    }

    public List<String> findBagsWhichCanContain(String bag) {
        List<String> bagTypes = new ArrayList<>();
        for(String bagType : bags.keySet()) {
            if(canBagContain(bagType, bag)) {
                bagTypes.add(bagType);
            }
        }

        return bagTypes;
    }

    public boolean canBagContain(String bag, String containedBag) {
        for(BagCount subBag : bags.get(bag)) {
            if(subBag.getBagType().equals(containedBag) || canBagContain(subBag.getBagType(), containedBag)) {
                return true;
            }
        }

        return false;
    }

    public int countSubBags(String bag) {
        int count = 0;
        for(BagCount subBag : bags.get(bag)) {
            count += subBag.getCount() + countSubBags(subBag.getBagType()) * subBag.getCount();
        }

        return count;
    }

    public String getBags() {
        StringBuilder sb = new StringBuilder();
        for(String bagKey : bags.keySet()) {
            sb.append(bagKey).append(" bags contain ");

            List<BagCount> containedBags = bags.get(bagKey);
            if(containedBags.size() == 0) {
                sb.append("no other bags.");
            } else {
                for(BagCount count : containedBags) {
                    sb.append(count.getCount());
                    sb.append(" ");
                    sb.append(count.getBagType());
                    sb.append(",");
                }
            }

            sb.append("\n");
        }

        return sb.toString();
    }
}

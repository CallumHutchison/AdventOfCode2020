import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class Application {

    public static void main(String[] args) throws IOException {
        LuggageHandler handler = new LuggageHandler("input.txt");
        System.out.println(handler.getBags());
        List<String> bagTypes = handler.findBagsWhichCanContain("shiny gold");
        for(String s : bagTypes) {
            System.out.println(s);
        }
        System.out.println(bagTypes.size() + " bags can eventually contain a shiny gold bag");
        System.out.printf("Shiny gold sub-bags %d%n", handler.countSubBags("shiny gold"));
    }
}

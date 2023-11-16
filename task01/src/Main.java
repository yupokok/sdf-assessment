import java.io.BufferedReader;
import java.io.FileReader;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.Map;
import java.util.Locale.Category;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {
        
        if (args.length <= 0){
            System.err.println("No CSV file detected.");
            System.exit(1);
        } else {

            System.out.printf("Processing %s", args[0]);

            try {
                FileReader fr = new FileReader(args[0]);
                BufferedReader br = new BufferedReader(fr);

                Map<String, CategoryStats> data = new HashMap<>();
                br.lines()
                    .skip(1)
                    .filter(line -> !line.contains("NaN"))
                    .map(line -> line.split(","))
                    .map(columns -> new App(columns[0],columns[1].toUpperCase(), Float.parseFloat(columns[2])))
                    .collect(Collectors.groupingBy(app -> app.appCat()))

                    .forEach((String catName, List<App> apps) -> {
                        CategoryStats stat = new CategoryStats(catName);
                        for(App a: apps)
                            stat.highlow(a);
                            data.put(catName, stat);
                        });
                    
                for(String c: data.keySet()) {
                    CategoryStats d = data.get(c);

                    List<String> allCats = new LinkedList<>();

                    

            

                    System.out.printf("\n Category: %s \n\t Highest: %s, %f \n\t Lowest: %s, %f \n\t Average: %f \n\t Count: %d" ,
                                    d.getCatName(), d.getHighName(), d.getHighRating(), d.getLowName(), d.getLowRating(), d.getAverage(), d.count());

                }

            } finally {
                //
            } 
        }
    }
}
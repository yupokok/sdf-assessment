import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.sound.sampled.FloatControl;

public class CategoryStats {
    
    private String catName;
    private float average;
    private float highRating = -10;
    private float lowRating = 50;
    private String highName;
    private String lowName;
    private int discarded;
    public int count;



       // Add hashmap into constructor how?
    public CategoryStats(String catName){
        this.catName = catName;
    }

    public List<Float> allRatings = new LinkedList<>();
    public List<String> allCats = new LinkedList<>();


  

    public void highlow(App app){
        allRatings.add(app.appRating());
        allCats.add(app.appCat());


        
         if(app.appRating() > getHighRating()){
            setHighRating(app.appRating());
            setHighName(app.appName());
        }

        if(app.appRating() < getLowRating()){
            setLowRating(app.appRating());
            setLowName(app.appName());
        }

    }

   public float getAverage(){

for(int i=0; i < allCats.size(); i++){
            String value = allCats.get(i);
            int count = 0;
            if((allCats.contains(value))) {
                count =+ 1;
                Map<String, Integer> catCount = new HashMap<>();
                catCount.put(allCats.get(i), count);
            } 

        for(int j =0; j <allRatings.size(); j++){
            float rating = allRatings.get(j);
            float sum = 0 ;
            sum =+ allRatings.get(j);

            
            this.average = sum / count;
            

        }
        

    } return average;


}

public int count(){

            int countCat = Collections.frequency(allCats, getCatName()); // number of items in categorys
            return countCat;

}

            //     Counting...
            // Map<String, Integer> countMap = new HashMap<>();
            //     for (String item: allCats) {

            //         if (countMap.containsKey(item))
            //             countMap.put(item, countMap.get(item) + 1);
            //         else
            //             countMap.put(item, 1);
            //     } return count;
            // }
    




    // public void average(){
        
    //     for(int i=0; i < allCats.size(); i++){
    //         String value = allCats.get(i);
    //         int count = 0;
    //         if((allCats.contains(value))) {
    //             count =+ 1;
    //             Map<String, Integer> catCount = new HashMap<>();
    //             catCount.put(allCats.get(i), count);
    //         } 

    //     for(int j =0; j <allRatings.size(); j++){
    //         float rating = allRatings.get(j);
    //         float sum = 0 ;
    //         sum =+ allRatings.get(j);

    //         float average = sum / count;
    //         this.average = average;

    //     }

        
    // }
// }


    // public void highest(App app) {
    //      if(app.appRating() > getHighRating()){
    //         setHighRating(app.appRating());
    //         setHighName(app.appName());
    //     }
    // }
    // public void lowest(App app) {
    //     if(app.appRating() < getLowRating()){
    //         setLowRating(app.appRating());
    //         setLowName(app.appName());
    //     }
    
    // }



    public String getCatName() {
        return catName;
    }

    public void setCatName() {
        this.catName = catName;
    }

    public float getHighRating() {
        return highRating;
    }

    public void setHighRating(float highRating) {
        this.highRating = highRating;
    }

    public float getLowRating() {
        return lowRating;
    }

    public void setLowRating(float lowRating) {
        this.lowRating = lowRating;
    }

    public String getHighName() {
        return highName;
    }

    public void setHighName(String highName) {
        this.highName = highName;
    }

    public String getLowName() {
        return lowName;
    }

    public void setLowName(String lowName) {
        this.lowName = lowName;
    }

    public int getDiscarded() {
        return discarded;
    }

    public void setDiscarded(int discarded) {
        this.discarded = discarded;
    }

    
}










import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Console;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class ProductManager {

    private final Map<String, Product> products = new HashMap<>();
    private final Socket socket;
    
    private void saveProduct(Product product) { 
        products.put(product.getId(), product); 
    }

   public ProductManager(Socket socket) {
      this.socket = socket;
   }

   public void start() throws Exception {

      InputStream is = socket.getInputStream();
      InputStreamReader isr = new InputStreamReader(is);
      BufferedReader br = new BufferedReader(isr);
      OutputStream os = socket.getOutputStream();
      OutputStreamWriter ows = new OutputStreamWriter(os);
      BufferedWriter bw = new BufferedWriter(ows);

      boolean stop = false;
      Console cons = System.console();
      while (!stop) {
         String line = cons.readLine("Please enter any input: ");
         line = line.trim() + "\n";

         bw.write(line);
         bw.flush();


         while (true) {
            String result = br.readLine();
            result = result.trim();
            //System.out.println(">>> " + result);
            if ("end".equals(result))
               break;
            System.out.println(result);


            // br.lines()
            //     .filter(result -> result.contains(":"))
            //     .map(result -> result.split(":"))
            //     .map(columns -> new Product(column[0], column[1]))
            //     .
            
            
               // processing info (creating products?)
                result.trim();
                if(result.contains(":")){
                String[] terms = result.trim().split(":");
                Product product = null;

                switch (terms[0]) {
                    case "prod_id":
                        product = new Product(terms[1]);
                        products.put(product.getId(), product);
                        break;
    
                    case "title":
                         product.setTitle(terms[1]);
                        break;
    
                    case "price":
                        product.setPrice(Integer.parseInt(terms[1]));
                        break;
                    
                    case "rating":
                        product.setRating(Integer.parseInt(terms[1]));
                        break;
                        
                }
            } else{
               
            }



         
         



         
      }
   }
   
   }

}

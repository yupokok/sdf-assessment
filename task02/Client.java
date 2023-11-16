package task02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Console;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {


    public static void main(String[] args) throws Exception {


        int port = 3000;
        if (args.length > 0)
         port = Integer.parseInt(args[0]);

        Socket socket = new Socket("localhost", port);
        ProductManager sess = new ProductManager(socket);
        sess.start();


       
   }


    
        
}

package Controller;

import java.io.File;
import java.io.OutputStream;
import java.time.Instant;
import java.util.Scanner;
import com.sun.net.httpserver.*;


public class SystemPage implements HttpHandler {
    public void handle(HttpExchange exchange) {
        try {
            String response = this.response();
            exchange.sendResponseHeaders(200, response.length());
            OutputStream os = exchange.getResponseBody();
            os.write(response.getBytes());
            os.close();
        } catch (Throwable e) {
            System.err.print("Cannot Handle SystemPage: " + e);
        }
    }

    protected String response() {
        try {
            
            File file = new File("View/System.html");
            Scanner scan = new Scanner(file);
            String content = scan.useDelimiter("\\Z").next();
            scan.close();
            
            Instant instant = Instant.now();
            return content.replace("$clock", instant.toString());
        
        } catch (Throwable e) {
            System.err.print("Cannot find file: " + e);
        }
        return null;
    }
}

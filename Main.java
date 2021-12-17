import com.sun.net.httpserver.*;
import java.net.InetSocketAddress;

public class Main {

    public static void main(String[] args) {
        try {
            HttpServer server = HttpServer.create(new InetSocketAddress(8000), 0);
            server.createContext("/", new Controller.HomePage());
            server.createContext("/system/", new Controller.SystemPage());
            server.setExecutor(null); // creates a default executor
            server.start();
        } catch (Throwable e) {
            System.err.print("Cannot Start Server: " + e);
        }
    }
}
import com.sun.net.httpserver.*;
import java.io.*;
import java.net.InetSocketAddress;
import java.nio.file.*;
import java.util.List;

public class MoodTrackerServer {
    private static final int PORT = 8000;
    private static MoodDAO moodDAO = new MoodDAO();

    public static void main(String[] args) throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(PORT), 0);
        System.out.println("🚀 Server started at http://localhost:" + PORT);

        // Serve static files
        server.createContext("/", exchange -> {
            String path = exchange.getRequestURI().getPath();
            if (path.equals("/")) path = "/index.html";
            File file = new File("public" + path);
            if (!file.exists()) {
                exchange.sendResponseHeaders(404, 0);
                return;
            }

            byte[] response = Files.readAllBytes(file.toPath());
            exchange.sendResponseHeaders(200, response.length);
            OutputStream os = exchange.getResponseBody();
            os.write(response);
            os.close();
        });

        // API endpoint: /api/save-mood
        server.createContext("/api/save-mood", exchange -> {
            if ("POST".equals(exchange.getRequestMethod())) {
                InputStream is = exchange.getRequestBody();
                String body = new String(is.readAllBytes());
                moodDAO.saveMood(body);
                exchange.sendResponseHeaders(200, 0);
                exchange.getResponseBody().close();
            }
        });

        // API endpoint: /api/get-moods
        server.createContext("/api/get-moods", exchange -> {
            if ("GET".equals(exchange.getRequestMethod())) {
                List<String> moods = moodDAO.getAllMoods();
                String response = String.join("\n", moods);
                exchange.sendResponseHeaders(200, response.length());
                OutputStream os = exchange.getResponseBody();
                os.write(response.getBytes());
                os.close();
            }
        });

        server.setExecutor(null);
        server.start();
    }
}

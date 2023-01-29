package services.uniFinder.v1;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import org.json.JSONObject;

public class App {

    private static final int PORT = 50051;
//    private final String  apiKey = "QVt5P61BxWdzDPdPwZH0xHUifcy041RmiMU4YNIh";

    public static void main(String[] args) throws Exception {
        // Create a new server
        Server server = ServerBuilder.forPort(PORT)
                .addService(new UniFinderService())
                .build();

        // Start the server
        server.start();
        System.out.println("Server started at port " + PORT);
        // Wait until server is terminated
        server.awaitTermination();



    }
}



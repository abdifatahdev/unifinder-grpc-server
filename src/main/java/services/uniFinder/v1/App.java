package services.uniFinder.v1;

import io.grpc.Server;
import io.grpc.ServerBuilder;

public class App {

    private static final int PORT = 50051;

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



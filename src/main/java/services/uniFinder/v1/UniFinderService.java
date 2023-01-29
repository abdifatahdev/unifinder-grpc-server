package services.uniFinder.v1;

import io.grpc.stub.StreamObserver;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import org.json.JSONException;
import org.json.JSONObject;
import io.grpc.stub.StreamObserver;

public class UniFinderService extends UniFinderServiceGrpc.UniFinderServiceImplBase {
    @Override
    public void getUniFinderInfo(UniFinder.UniFinderRequest request,
                                 StreamObserver<UniFinder.UniFinderResponse> responseObserver) {
        System.out.println("Request: " + request);
        UniFinder.UniFinderResponse response = UniFinder.UniFinderResponse.newBuilder()
                .setStudentName("Welcome " + request.getStudentName())
                .setInstitutionName("Harvard University")
                .build();

        final JSONObject jsonObject;
        try {
            jsonObject = getUniversityDetails(String.valueOf(request.getInstitutionId()));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        try {
            System.out.println(jsonObject);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    private JSONObject getUniversityDetails(String universityId)
            throws IOException, InterruptedException, JSONException {

        String APIKey = "weIg6spfiKIk0fC3wg5omar71jNfWG44FbgK5ghN";
        String URL = "https://api.data.gov/ed/collegescorecard/v1/schools.json?id=" + universityId + "&fields=school.name,2020.student.size&api_key=" + APIKey;

        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(URI.create(URL))
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> httpResponse = HttpClient.newHttpClient()
                .send(httpRequest, HttpResponse.BodyHandlers.ofString());

        return new JSONObject(httpResponse.body().toString());

        /**
         * call the api using the institition_id
         * - figure out the avg_gpa
         * - SAT, ACT SCORES
         * - see if the student can get into that university
         * - if they user can't get to that university, find 3 alternative colleges
         *
         * - if the user can get to his dream college, also return more information
         *   about the university, like the tuition, best majors at that university
         *   and starting salaries, and population
         */
    }
}

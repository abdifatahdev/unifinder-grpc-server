package services.uniFinder.v1;

import io.grpc.stub.StreamObserver;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.logging.Logger;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class UniFinderService extends UniFinderServiceGrpc.UniFinderServiceImplBase {
    private final String  apiKey = "QVt5P61BxWdzDPdPwZH0xHUifcy041RmiMU4YNIh";
    Logger logger = Logger.getLogger(String.valueOf(this.getClass()));
    @Override
    public void getUniFinderInfo(UniFinder.UniFinderRequest request,
                                 StreamObserver<UniFinder.UniFinderResponse> responseObserver) throws JSONException, IOException, InterruptedException {
        System.out.println("Request: " + request);
        UniFinder.UniFinderResponse response = UniFinder.UniFinderResponse.newBuilder()
                .setStudentName("Welcome " + request.getStudentName())
                .setInstitutionName("Harvard University")
                .build();

        System.out.println( getAdmissionInfo(request.getInstitutionId()));;






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

    private Record getAdmissionInfo(int institutionId) throws IOException, InterruptedException, JSONException {

        String scoreCardApi = "https://api.data.gov/ed/collegescorecard/v1/schools.json?id="+ institutionId + "&_fields=latest.admissions&keys_nested=true&api_key=" + apiKey;


        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(URI.create(scoreCardApi))
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> httpResponse = HttpClient.newHttpClient()
                .send(httpRequest, HttpResponse.BodyHandlers.ofString());
        System.out.println(httpResponse.body().toString());
        JSONObject res = new JSONObject(httpResponse.body().toString());
        JSONArray admission = res.getJSONArray("results");
        JSONObject  arr1  = (JSONObject) admission.get(0);
        JSONObject latest = arr1.getJSONObject("latest");
        JSONObject admissions = latest.getJSONObject("admissions");

        //SAT SCORES
        JSONObject sat_score = admissions.getJSONObject("sat_scores");
        JSONObject per25th = sat_score.getJSONObject("25th_percentile");
        System.out.println(per25th);
        int sat_critical_reading = per25th.getInt("critical_reading");
        int sat_writing =  per25th.getInt("writing");
        int sat_math = per25th.getInt("math");
        SatRecord satRecord = new SatRecord(sat_critical_reading, sat_writing, sat_math);
        // ACT SCORES
        JSONObject act_scores = admissions.getJSONObject("act_scores");
        JSONObject act_per25th = act_scores.getJSONObject("25th_percentile");
        System.out.println(per25th);
        int english = act_per25th.getInt("english");
        int writing =  act_per25th.getInt("writing");
        int math = act_per25th.getInt("math");

        ActRecord actRecord = new ActRecord(english, writing, math);
        System.out.println( actRecord.toString());;
        Record record = new Record(satRecord, actRecord);
        return record;

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

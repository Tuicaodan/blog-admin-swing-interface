package ictgradschool.adminApp.swingclient.web;

import ictgradschool.adminApp.swingclient.model.User;
import ictgradschool.adminApp.swingclient.util.JSONUtils;

import java.io.IOException;
import java.net.*;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.*;

public class API {
    private static API instance;

    private static final String BASE_URL = "http://localhost:3000/api";

    public static API getInstance() {
        if (instance == null) {
            instance = new API();
        }
        return instance;
    }

    private final CookieManager cookieManager;
    private final HttpClient client;

    private API() {
        this.cookieManager = new CookieManager();

        this.client = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_1_1)
                .followRedirects(HttpClient.Redirect.NEVER)
                .connectTimeout(Duration.ofSeconds(1))
                .cookieHandler(this.cookieManager)
                .build();
    }

    //check user login status and return the status code
    public int userLogin(String username, String password) throws IOException, InterruptedException {

        Map<String, String> loginInfo = new HashMap<>();
        loginInfo.put("username", username);
        loginInfo.put("password", password);

        String json = JSONUtils.toJSON(loginInfo);

        HttpRequest.Builder builder = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URL + "/login"))
                .setHeader("Content-Type", "application/json")
                .setHeader("Accept", "application/json")
                .method("POST", HttpRequest.BodyPublishers.ofString(json));

        HttpRequest request = builder.build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        return response.statusCode();
    }

    //check user logout status and return the status code
    public Integer userLogout() throws  IOException, InterruptedException {

        HttpRequest.Builder builder = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URL + "/logout"))
                .setHeader("Accept", "application/json")
                .method("GET", HttpRequest.BodyPublishers.noBody());

        HttpRequest request = builder.build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        return response.statusCode();
    }

    public String getAuthToken() {
        List<HttpCookie> cookies = this.cookieManager.getCookieStore().get(URI.create(BASE_URL));
        System.out.println(cookies);
        for (HttpCookie cookie : cookies) {
            if (cookie.getName().equals("authToken")) {
                return cookie.getValue();
            }
        }
        return "";
    }

    //get user report, return list of user depends on the status code
    public List<User> retrieveUserReport() throws IOException, InterruptedException {
        int responseStatusCode;
        List<User> userList;
        HttpRequest.Builder builder = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URL + "/users"))
                .setHeader("Accept", "application/json")
                .method("GET", HttpRequest.BodyPublishers.noBody());
        HttpRequest request = builder.build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        responseStatusCode = response.statusCode();
        if(responseStatusCode==401){
            userList= new ArrayList<>();
        } else {
            String responseJson = response.body();
            userList = JSONUtils.toList(responseJson, User.class);
        }
        return userList;
    }

    //delete user and return status code
    public Integer deleteUser(int targetUserID) throws IOException, InterruptedException {

        HttpRequest.Builder builder = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URL + "/users/"+targetUserID))
                .setHeader("Accept", "application/json")
                .method("DELETE", HttpRequest.BodyPublishers.noBody());

        HttpRequest request = builder.build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        return response.statusCode();
    }
}

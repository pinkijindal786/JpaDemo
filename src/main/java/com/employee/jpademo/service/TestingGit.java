package com.employee.jpademo.service;

import com.employee.jpademo.JpaExeptionHandler.GlobalExceptionHandler;
import com.employee.jpademo.model.RootJsonConvertor;
import com.employee.jpademo.model.Translator;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import javax.xml.crypto.dsig.TransformService;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Optional;

@Service
public class TestingGit {
    public RootJsonConvertor translator(String body) throws Exception {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://google-translate1.p.rapidapi.com/language/translate/v2"))
                .header("content-type", "application/x-www-form-urlencoded")
                .header("accept-encoding", "application/gzip")
                .header("x-rapidapi-key", "5c66813222msh48aa7e4ebf2d58fp1cb8f4jsn10c49a03ee66")
                .header("x-rapidapi-host", "google-translate1.p.rapidapi.com")
                .method("POST", HttpRequest.BodyPublishers.ofString(body))
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        if(response==null) throw new Exception("getting" + response+ "response from API");
        return new ObjectMapper().readValue(response.body(),RootJsonConvertor.class);
    }
}

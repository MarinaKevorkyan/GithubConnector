package com.mulesoft.connector.github.internal.Converters;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import com.mulesoft.connector.github.internal.Domain.Issue;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class IssueConverter {
    public List<Issue> convertInputStreamToIssue (InputStream inputStream) throws IOException {
        if(inputStream != null){
            Gson gson = new Gson();
            JsonReader jsonReader = new JsonReader(new InputStreamReader(inputStream, "UTF-8"));
            List<Issue> issues = new ArrayList<>();
            jsonReader.beginArray();
            while(jsonReader.hasNext()){
                Issue issue = gson.fromJson(jsonReader, Issue.class);
                issues.add(issue);
            }
            jsonReader.endArray();
            jsonReader.close();
            return issues;
        }
        else{
            return null;
        }
    }
}

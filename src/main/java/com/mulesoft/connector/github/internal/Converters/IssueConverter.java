package com.mulesoft.connector.github.internal.Converters;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import com.mulesoft.connector.github.api.Domain.IssueAnswer;
import com.mulesoft.connector.github.internal.Domain.Issue;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class IssueConverter {

    public IssueAnswer convertInputStreamToIssue (InputStream inputStream) throws IOException {
        if(inputStream != null){
            Gson gson = new Gson();
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            for(int data = inputStream.read(); data != -1; data = inputStream.read()){
                byteArrayOutputStream.write(data);
            }
            String issueString = byteArrayOutputStream.toString("UTF-8");
            IssueAnswer issue = gson.fromJson(issueString, IssueAnswer.class);

//            Reader reader = new InputStreamReader(inputStream);
//            StringBuilder result = new StringBuilder();
//
//            for (int data = reader.read(); data != -1; data = reader.read()) {
//                result.append((char)data);
//            }
//
//            IssueAnswer issue = gson.fromJson(result.toString(), IssueAnswer.class);
            return issue;
        }
        else{
            return null;
        }
    }

    public List<Issue> convertInputStreamToIssues (InputStream inputStream) throws IOException {
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

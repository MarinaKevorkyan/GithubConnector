package com.mulesoft.connector.github.internal.Converters;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import com.mulesoft.connector.github.api.Domain.IssueList;
import com.mulesoft.connector.github.api.Domain.IssueResponse;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class IssueConverter {

    public IssueResponse convertInputStreamToIssue (InputStream inputStream) throws IOException {
        if(inputStream != null){
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            for(int data = inputStream.read(); data != -1; data = inputStream.read()){
                byteArrayOutputStream.write(data);
            }
            String issueString = byteArrayOutputStream.toString("UTF-8");
            IssueResponse issue = objectMapper.readValue(issueString, IssueResponse.class);
            return issue;
        }
        else{
            return null;
        }
    }

    public List<IssueList> convertInputStreamToIssues (InputStream inputStream) throws IOException {
        if(inputStream != null){
            Gson gson = new Gson();
            JsonReader jsonReader = new JsonReader(new InputStreamReader(inputStream, "UTF-8"));
            List<IssueList> issues = new ArrayList<>();
            jsonReader.beginArray();
            while(jsonReader.hasNext()){
                IssueList issue = gson.fromJson(jsonReader, IssueList.class);
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

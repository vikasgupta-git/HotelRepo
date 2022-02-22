package org.tcs.DataLoads;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

public class DataReader {
    public List<HashMap<String, String>> getJsonData(String JsonFilePath) throws IOException {
    //Add Jackson core and Jackson databind api
        //convert json file to json string
        //add apache-commons-io to use FileUtils class
        //
        ObjectMapper mapper=new ObjectMapper();
        String jsonContent=FileUtils.readFileToString(new File(JsonFilePath), StandardCharsets.UTF_8);
        //TypeReference is used to convert the jsonContent into the provided format.
        //ObjectMapper will automatically convert the json into the list of hashmaps
       List<HashMap<String,String>> data= mapper.readValue(jsonContent, new TypeReference<List< HashMap<String,String>>>(){} );
       return data;
    }
}

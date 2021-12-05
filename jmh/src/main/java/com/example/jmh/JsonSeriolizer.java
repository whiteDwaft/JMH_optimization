package com.example.jmh;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

public class JsonSeriolizer {
    public static <T> String toJson(T testDto) throws IOException {
        StringWriter writer = new StringWriter();
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(writer, testDto);
        return writer.toString();
    }

    public static <T> T fromJson(String jsonString, Class<T> clazz) throws IOException {
        StringReader reader = new StringReader(jsonString);
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(reader, clazz);
    }
}

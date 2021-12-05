package com.example.jmh;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@JsonAutoDetect
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class TestDto {
    public String name;
    public int age;
    public int weight;
//    @JsonIgnore
//    public int setupTrialMutex;
//    @JsonIgnore
//    public int tearTrialMutex;
//    @JsonIgnore
//    public int setupIterationMutex;
//    @JsonIgnore
//    public int tearIterationMutex;
//    @JsonIgnore
//    public int setupInvocationMutex;
//    @JsonIgnore
//    public int tearInvocationMutex;
}

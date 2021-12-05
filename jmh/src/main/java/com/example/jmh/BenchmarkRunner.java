package com.example.jmh;

import org.openjdk.jmh.annotations.*;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class BenchmarkRunner {

    @State(Scope.Thread)
    public static class MyState {
        TestDto dto;

        @Setup(Level.Iteration)
        public void init() {
            dto = TestDto.builder()
                    .name("Anton")
                    .age(23)
                    .weight(77)
                    .build();
        }
    }

//    @Fork(value = 1, warmups = 1)
//    @Benchmark
//    @BenchmarkMode(Mode.AverageTime) //меняю режим на Throughput, при проверке на пропускную способность
//    @OutputTimeUnit(TimeUnit.MICROSECONDS)
//    public void benchmark1(MyState dto) throws IOException {
//        String json = JsonSeriolizer.toJson(dto.dto);
//        TestDto res = JsonSeriolizer.fromJson(json, TestDto.class);
//    }


    @Fork(value = 1, warmups = 1)
    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    public void benchmark2(MyState dto) throws IOException {
       byte[] bites = ProtobuffSeriolizer.serialize(dto.dto, TestDto.class);
       TestDto res = ProtobuffSeriolizer.deSerialize(bites,TestDto.class);
    }


    public static void main(String[] args) throws Exception {
        org.openjdk.jmh.Main.main(args);
    }
}

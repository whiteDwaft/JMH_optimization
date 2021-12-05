#### Общая конфигурация
```
# JMH version: 1.33
# VM version: JDK 11.0.5, OpenJDK 64-Bit Server VM, 11.0.5+10-b520.17
# VM invoker: C:\Program Files\JetBrains\IntelliJ IDEA 2019.3.1\jbr\bin\java.exe
# VM options: -javaagent:C:\Program Files\JetBrains\IntelliJ IDEA 2019.3.1\lib\idea_rt.jar=53400:C:\Program Files\JetBrains\IntelliJ IDEA 2019.3.1\bin -Dfile.encoding=UTF-8
```
####Начнем с Throughput
+ JSON
```
# Blackhole mode: full + dont-inline hint (default, use -Djmh.blackhole.autoDetect=true to auto-detect)
# Warmup: 5 iterations, 10 s each
# Measurement: 5 iterations, 10 s each
# Timeout: 10 min per iteration
# Threads: 1 thread, will synchronize iterations
# Benchmark mode: Throughput, ops/time
# Benchmark: com.example.jmh.BenchmarkRunner.benchmark1

# Run progress: 0,00% complete, ETA 00:03:20
# Warmup Fork: 1 of 1
# Warmup Iteration   1: 31056,425 ops/s
# Warmup Iteration   2: 48752,664 ops/s
# Warmup Iteration   3: 49625,794 ops/s
# Warmup Iteration   4: 49356,784 ops/s
# Warmup Iteration   5: 49486,200 ops/s
Iteration   1: 37470,593 ops/s
Iteration   2: 47566,443 ops/s
Iteration   3: 45333,579 ops/s
Iteration   4: 46921,682 ops/s
Iteration   5: 47751,165 ops/s

# Run progress: 50,00% complete, ETA 00:01:41
# Fork: 1 of 1
# Warmup Iteration   1: 25459,405 ops/s
# Warmup Iteration   2: 49248,160 ops/s
# Warmup Iteration   3: 50475,086 ops/s
# Warmup Iteration   4: 44588,817 ops/s
# Warmup Iteration   5: 45521,059 ops/s
Iteration   1: 51378,202 ops/s
Iteration   2: 52016,826 ops/s
Iteration   3: 51257,458 ops/s
Iteration   4: 48048,003 ops/s
Iteration   5: 47022,775 ops/s


Result "com.example.jmh.BenchmarkRunner.benchmark1":
  49944,653 ±(99.9%) 8654,761 ops/s [Average]
  (min, avg, max) = (47022,775, 49944,653, 52016,826), stdev = 2247,614
  CI (99.9%): [41289,892, 58599,414] (assumes normal distribution)


# Run complete. Total time: 00:03:22

Benchmark                    Mode  Cnt      Score      Error  Units
BenchmarkRunner.benchmark1  thrpt    5  49944,653 ± 8654,761  ops/s
```
+ Protobuff
```
# Blackhole mode: full + dont-inline hint (default, use -Djmh.blackhole.autoDetect=true to auto-detect)
# Warmup: 5 iterations, 10 s each
# Measurement: 5 iterations, 10 s each
# Timeout: 10 min per iteration
# Threads: 1 thread, will synchronize iterations
# Benchmark mode: Throughput, ops/time
# Benchmark: com.example.jmh.BenchmarkRunner.benchmark2

# Run progress: 0,00% complete, ETA 00:03:20
# Warmup Fork: 1 of 1
# Warmup Iteration   1: 826679,040 ops/s
# Warmup Iteration   2: 881511,150 ops/s
# Warmup Iteration   3: 896699,048 ops/s
# Warmup Iteration   4: 876623,467 ops/s
# Warmup Iteration   5: 844381,360 ops/s
Iteration   1: 705421,759 ops/s
Iteration   2: 858141,465 ops/s
Iteration   3: 869430,374 ops/s
Iteration   4: 881591,692 ops/s
Iteration   5: 878225,118 ops/s

# Run progress: 50,00% complete, ETA 00:01:41
# Fork: 1 of 1
# Warmup Iteration   1: 784239,137 ops/s
# Warmup Iteration   2: 861557,153 ops/s
# Warmup Iteration   3: 872799,442 ops/s
# Warmup Iteration   4: 867874,300 ops/s
# Warmup Iteration   5: 864607,082 ops/s
Iteration   1: 856916,212 ops/s
Iteration   2: 859114,172 ops/s
Iteration   3: 851136,960 ops/s
Iteration   4: 854073,319 ops/s
Iteration   5: 849954,743 ops/s


Result "com.example.jmh.BenchmarkRunner.benchmark2":
  854239,081 ±(99.9%) 14781,123 ops/s [Average]
  (min, avg, max) = (849954,743, 854239,081, 859114,172), stdev = 3838,611
  CI (99.9%): [839457,958, 869020,205] (assumes normal distribution)


# Run complete. Total time: 00:03:22

Benchmark                    Mode  Cnt       Score       Error  Units
BenchmarkRunner.benchmark2  thrpt    5  854239,081 ± 14781,123  ops/s
```
___Итог:___ Разница в Throughput в 17 раз (в пользу Protobuff)
```
# Blackhole mode: full + dont-inline hint (default, use -Djmh.blackhole.autoDetect=true to auto-detect)
# Warmup: 5 iterations, 10 s each
# Measurement: 5 iterations, 10 s each
# Timeout: 10 min per iteration
# Threads: 1 thread, will synchronize iterations
# Benchmark mode: Average time, time/op
# Benchmark: com.example.jmh.BenchmarkRunner.benchmark1

# Run progress: 0,00% complete, ETA 00:03:20
# Warmup Fork: 1 of 1
# Warmup Iteration   1: 35,355 us/op
# Warmup Iteration   2: 20,961 us/op
# Warmup Iteration   3: 20,039 us/op
# Warmup Iteration   4: 21,366 us/op
# Warmup Iteration   5: 19,924 us/op
Iteration   1: 19,777 us/op
Iteration   2: 19,929 us/op
Iteration   3: 19,917 us/op
Iteration   4: 19,768 us/op
Iteration   5: 19,684 us/op

# Run progress: 50,00% complete, ETA 00:01:40
# Fork: 1 of 1
# Warmup Iteration   1: 29,478 us/op
# Warmup Iteration   2: 20,875 us/op
# Warmup Iteration   3: 19,960 us/op
# Warmup Iteration   4: 19,971 us/op
# Warmup Iteration   5: 19,798 us/op
Iteration   1: 19,890 us/op
Iteration   2: 19,856 us/op
Iteration   3: 22,751 us/op
Iteration   4: 22,560 us/op
Iteration   5: 22,315 us/op


Result "com.example.jmh.BenchmarkRunner.benchmark1":
  21,474 ±(99.9%) 5,661 us/op [Average]
  (min, avg, max) = (19,856, 21,474, 22,751), stdev = 1,470
  CI (99.9%): [15,814, 27,135] (assumes normal distribution)


# Run complete. Total time: 00:03:21

Benchmark                   Mode  Cnt   Score   Error  Units
BenchmarkRunner.benchmark1  avgt    5  21,474 ± 5,661  us/op
```
Protobuff
```
# Blackhole mode: full + dont-inline hint (default, use -Djmh.blackhole.autoDetect=true to auto-detect)
# Warmup: 5 iterations, 10 s each
# Measurement: 5 iterations, 10 s each
# Timeout: 10 min per iteration
# Threads: 1 thread, will synchronize iterations
# Benchmark mode: Average time, time/op
# Benchmark: com.example.jmh.BenchmarkRunner.benchmark2

# Run progress: 0,00% complete, ETA 00:03:20
# Warmup Fork: 1 of 1
# Warmup Iteration   1: 1,275 us/op
# Warmup Iteration   2: 1,205 us/op
# Warmup Iteration   3: 1,216 us/op
# Warmup Iteration   4: 1,304 us/op
# Warmup Iteration   5: 1,182 us/op
Iteration   1: 1,192 us/op
Iteration   2: 1,205 us/op
Iteration   3: 1,199 us/op
Iteration   4: 1,236 us/op
Iteration   5: 1,229 us/op

# Run progress: 50,00% complete, ETA 00:01:41
# Fork: 1 of 1
# Warmup Iteration   1: 1,284 us/op
# Warmup Iteration   2: 1,258 us/op
# Warmup Iteration   3: 1,198 us/op
# Warmup Iteration   4: 1,210 us/op
# Warmup Iteration   5: 1,220 us/op
Iteration   1: 1,229 us/op
Iteration   2: 1,219 us/op
Iteration   3: 1,214 us/op
Iteration   4: 1,211 us/op
Iteration   5: 1,234 us/op


Result "com.example.jmh.BenchmarkRunner.benchmark2":
  1,221 ±(99.9%) 0,038 us/op [Average]
  (min, avg, max) = (1,211, 1,221, 1,234), stdev = 0,010
  CI (99.9%): [1,184, 1,259] (assumes normal distribution)


# Run complete. Total time: 00:03:22

Benchmark                   Mode  Cnt  Score   Error  Units
BenchmarkRunner.benchmark2  avgt    5  1,221 ± 0,038  us/op
```
___Итог:___ Разница по Latency в 17 раз (в пользу Protobuff) что логично
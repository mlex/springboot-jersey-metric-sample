Example for https://github.com/spring-projects/spring-boot/issues/5875

To simulate, just build the project with
```
mvn clean install
```

Then start the app with
```
java -jar target/spring-boot-jersey-metrics-1.4.2.RELEASE.jar
```


Now every request to `/jersey/echo/SOME_STRING` with different SOME_STRING values will create a new count-metric.

```
$ curl localhost:8080/jersey/echo/foo
ECHO: foo

$ curl localhost:8080/jersey/echo/bar
ECHO: bar

$ curl localhost:8080/metrics
{
  "mem": 780620,
  "mem.free": 185218,
  "processors": 8,
  "instance.uptime": 30817,
  "uptime": 34516,
  "systemload.average": 2.62353515625,
  "heap.committed": 716800,
  "heap.init": 262144,
  "heap.used": 531581,
  "heap": 3728384,
  "nonheap.committed": 68224,
  "nonheap.init": 2496,
  "nonheap.used": 63820,
  "nonheap": 0,
  "threads.peak": 34,
  "threads.daemon": 32,
  "threads.totalStarted": 40,
  "threads": 34,
  "classes": 8936,
  "classes.loaded": 8936,
  "classes.unloaded": 0,
  "gc.ps_scavenge.count": 10,
  "gc.ps_scavenge.time": 72,
  "gc.ps_marksweep.count": 2,
  "gc.ps_marksweep.time": 97,
  "httpsessions.max": -1,
  "httpsessions.active": 0,
  "gauge.response.metrics": 1,
  "gauge.response.jersey.echo.foo": 80,
  "gauge.response.jersey.echo.bar": 3,
  "counter.status.200.metrics": 1,
  "counter.status.200.jersey.echo.foo": 1,
  "counter.status.200.jersey.echo.bar": 1
}
```

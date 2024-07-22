# LEAK Project

Sample application for test memory consumption by app

| URI | Description | Result Example |  
|---|---|---|
| /check | Check how much memory already allocated |  Total 1 dishes, 1.0 MB | 
| /eat | Allocate memory with default chunk size that can be configure by environment variable APP_DISHSIZE ( Default value is 1 MB) | Added 1048576 bytes |  
| /eat/{numberOfDishes} | Allocate multiples chunk | | 
| /kill | Exit 9 (SIGKILL) | Application Log&nbsp;<br>&nbsp;<br>2024-07-22 17:37:54,296 INFO  [com.exa.HungryResource] (executor-thread-1) Exit with SIGKILL (9) &nbsp;<br>2024-07-22 17:37:59,312 INFO  [io.qua.thread-pool] (Shutdown thread) Awaiting thread pool shutdown; 1 thread(s) running with 0 task(s) waiting&nbsp;<br>...&nbsp;<br>2024-07-22 17:38:19,339 WARN  [io.qua.thread-pool] (Shutdown thread) Thread pool shutdown failed: -1 threads still running&nbsp;<br>2024-07-22 17:38:19,340 INFO  [io.quarkus] (Shutdown thread) leak stopped in 25.041s | 
| /openapi | OpenAPI doc |  | 
| /q/swagger-ui | Swagger UI ( only included in dev mode  ) |  | 




Container images can be found at
- JVM: quay.io/voravitl/leak:v1
- Native Binary: quay.io/voravitl/leak:native
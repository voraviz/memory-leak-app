# LEAK Project

Sample application for test memory consumption by app

| URI | Description | Result Example |  
|---|---|---|
| /check | Check how much memory already allocated |  Total 1 dishes, 1.0 MB | 
| /eat | Allocate memory with default chunk size that can be configure by environment variable APP_DISHSIZE ( Default value is 1 MB) | Added 1048576 bytes |  
| /eat/{numberOfDishes} | Allocate multiples chunk | | 
| /openapi | OpenAPI doc |  | 
| /q/swagger-ui | Swagger UI ( only included in dev mode  ) |  | 


Container images can be found at
- JVM: quay.io/voravitl/leak:v1
- Native Binary: quay.io/voravitl/leak:native
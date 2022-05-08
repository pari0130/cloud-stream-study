# Getting Started

### 서비스 시작

1. eureka start
2. zuul start
3. product start
4. booking start

### url

1. zuul url: http://localhost:8761
2. products get : http://192.168.0.4:8082/products/1
   1. then return : [product id = 1 at 1652000308197]
3. bookings get : http://192.168.0.4:8081/bookings/1
   1. then return [bookingsId = 1 at 1652001033932 [product id = 12345 at 1652001033920] ]
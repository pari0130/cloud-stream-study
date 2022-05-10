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

### kafka note
1. 디펜던시
   1. implementation("org.springframework.cloud:spring-cloud-stream-binder-kafka")
2. 버전 별 구성 차이
   1. 2.x 버전의 경우 "spring.cloud.stream.bindings.input / output" 구조로 설정
   2. 3.x 버전의 경우 아래와 같이 in, out 에 대한 규칙이 정해저 있음
      1. spring.cloud.stream.kafka.binding.producer-out-o
      2. spring.cloud.stream.kafka.binding.consumer-in-o
      3. e.g.
         1. consumer : <functionName> + -in- + <index>
         2. producer : <functionName> + -out- + <index>
         3. https://refactorfirst.com/spring-cloud-stream-with-kafka-communication.html
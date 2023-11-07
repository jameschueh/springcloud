# springcloud
practice spring cloud

練習時遇到的問題：
1. http://localhost:6001/hystrix.stream 卡loading 測有設定的api就不會loading了

2. 分支master/main

3. rabbitmq下載後，先執行service-start後，再啟動rabbitmq-plugins enable rabbitmq_management

4. Stream分組，分A/B組 兩組都會收到訊息，若同為A組，則輪流收到訊息

5. zipkin+rabbitmq => java -jar zipkin-server-2.24.3-exec.jar --RABBIT_ADDRESSES=localhost --RABBIT_USER=guest --RABBIT_PASSWORD=guest

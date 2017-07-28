This project extends the example by https://github.com/thomasdarimont/spring-boot-prometheus-example/ by adding a selfmade counter.

I deleted the grafana/prometheus files since this is an example for the jvm prometheus client only


Build:

mvn clean package

Run:

mvn spring-boot:run


Collect metrics :

curl localhost:8080/prometheus

you should find the "Hello_Worlds" metric along with the system metrics in the output, the value should be 0.0.

type
curl localhost:8080/greet

to invoke the method and then curl the metrics again, it should now be at 1!

see also https://github.com/prometheus/client_java for further information and more options!
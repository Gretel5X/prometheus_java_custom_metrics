package de.tdlabs.training;

import io.prometheus.client.Counter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@RestController
@Service
class GreetingController {
    //register a new counter to the default PublicMetrics defined in the MonitoringConfig file
    static final Counter requests = Counter.build().name("hello_worlds").help("Counts the number of requested Hello Worlds.").register();

    @GetMapping("/greet")
    String greet(@RequestParam(defaultValue = "World") String name) {
        requests.inc(1);
        return "Hello: " + name + " " + LocalDateTime.now();
    }
}

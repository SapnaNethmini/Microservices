package com.heli.microservices.client;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.GetExchange;

//@Slf4j
public interface InventoryClient {

    //Logger log = ILoggerFactory.getLogger(InventoryClient.class);

    @GetExchange("/api/inventory")
    @CircuitBreaker(name = "inventory", fallbackMethod = "fallbackMethod")
    @Retry(name = "inventory")
    boolean isInStock(@RequestParam String skuCode, @RequestParam Integer quantity);

//    default boolean fallbackMethod(String code, Integer quantity, Throwable throwable){
//        log.info("Cannot get inventory for skucode {}, failure reason: {}", code, throwable.getMessage());
//        return false;
//    }



}


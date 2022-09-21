package cn.insolu.ipaddress;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class IpAddressApplication {

    public static void main(String[] args) {
        SpringApplication.run(IpAddressApplication.class,args);
    }
}

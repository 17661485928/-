package com.coffee.kafeisummary;

import com.coffee.kafeisummary.config.CloseListener;
import com.coffee.kafeisummary.config.StartListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class KafeiSummaryApplication {

    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(KafeiSummaryApplication.class);
        springApplication.addListeners(new StartListener());
        springApplication.addListeners(new CloseListener());
        springApplication.run(args);
    }

}

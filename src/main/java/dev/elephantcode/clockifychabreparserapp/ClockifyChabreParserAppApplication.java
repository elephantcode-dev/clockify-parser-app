package dev.elephantcode.clockifychabreparserapp;

import dev.elephantcode.clockifychabreparserapp.parser.Parser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ClockifyChabreParserAppApplication implements CommandLineRunner {

    @Autowired
    private Parser parser;

    public static void main(String[] args) {
        SpringApplication.run(ClockifyChabreParserAppApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        parser.parse();
        System.exit(1);
    }
}

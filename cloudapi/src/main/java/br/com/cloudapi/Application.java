package br.com.cloudapi;

import br.com.cloudapi.model.RunInstance;
import br.com.cloudapi.service.RunInstanceRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by manuele on 28/11/16.
 */

@SpringBootApplication
public class Application {

    private static final Logger log = LoggerFactory.getLogger(Application.class);


    public static void main(String[] args)
    {
        SpringApplication.run(Application.class, args);
    }

}

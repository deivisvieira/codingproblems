package br.com.cloudapi.controller;

import br.com.cloudapi.model.RunInstance;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by manuele on 28/11/16.
 */
@RestController
public class RunInstanceController {

    private final AtomicLong counter = new AtomicLong();

    @RequestMapping(method = RequestMethod.GET, value = "/runinstance")
    public RunInstance runInstance(@RequestParam(value = "name", defaultValue = "World") String name)
    {
        return new RunInstance(counter.incrementAndGet(), name);
    }
}

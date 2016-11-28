package br.com.cloudapi.controller;

import br.com.cloudapi.model.RunInstance;
import br.com.cloudapi.service.RunInstanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by manuele on 28/11/16.
 */
@RestController
public class RunInstanceController {

    @Autowired
    private RunInstanceService runInstanceService;

    @RequestMapping(method = RequestMethod.GET, value = "/runinstance")
    public RunInstance runInstance(@RequestParam(value = "name", defaultValue = "exo") String name)
    {
        return runInstanceService.getRunInstanceByName(name);
    }
}

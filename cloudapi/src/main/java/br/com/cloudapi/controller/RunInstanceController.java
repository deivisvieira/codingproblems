package br.com.cloudapi.controller;

import br.com.cloudapi.model.RunInstance;
import br.com.cloudapi.service.RunInstanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by manuele on 28/11/16.
 */
@RestController
public class RunInstanceController {

    @Autowired
    private RunInstanceService runInstanceService;

    @RequestMapping(method = RequestMethod.GET, value = "/api/runinstancebyname")
    public RunInstance runInstanceByName(@RequestParam(value = "name", defaultValue = "exo") String name)
    {
        return runInstanceService.getRunInstanceByName(name);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/api/createruninstance")
    public void createRunInstance(@RequestParam(value = "name") String name)
    {
        try
        {
            RunInstance runInstance = new RunInstance();
            runInstance.setName(name);
            runInstanceService.addRunInstance(runInstance);
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }

    @RequestMapping(method = RequestMethod.GET, value = "/api/runinstance")
    public List<RunInstance> listAllRunInstance()
    {
        return runInstanceService.getAllRunInstance();
    }
}

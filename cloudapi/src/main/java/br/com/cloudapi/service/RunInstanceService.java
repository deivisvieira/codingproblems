package br.com.cloudapi.service;

import br.com.cloudapi.model.RunInstance;

import java.util.List;

/**
 * Created by manuele on 28/11/16.
 */
public interface RunInstanceService {

    RunInstance getRunInstanceByName(String name);

    void addRunInstance(RunInstance runInstance);

    List<RunInstance> getAllRunInstance();
}

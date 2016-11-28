package br.com.cloudapi.service;

import br.com.cloudapi.model.RunInstance;

/**
 * Created by manuele on 28/11/16.
 */
public interface RunInstanceService {

    RunInstance getRunInstanceByName(String name);
}

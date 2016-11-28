package br.com.cloudapi.service;

import br.com.cloudapi.model.RunInstance;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by manuele on 28/11/16.
 */
public interface RunInstanceRepository extends CrudRepository<RunInstance, Long> {

    RunInstance findByName(String name);
}

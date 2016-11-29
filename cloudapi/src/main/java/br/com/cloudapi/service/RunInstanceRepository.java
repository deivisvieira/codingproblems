package br.com.cloudapi.service;

import br.com.cloudapi.model.RunInstance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by manuele on 28/11/16.
 */
public interface RunInstanceRepository extends JpaRepository<RunInstance, Long> {

    RunInstance findByName(String name);

}

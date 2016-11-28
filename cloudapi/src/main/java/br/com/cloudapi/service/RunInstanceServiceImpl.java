package br.com.cloudapi.service;

import br.com.cloudapi.model.RunInstance;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by manuele on 28/11/16.
 */
@Component("runInstanceService")
@Transactional
public class RunInstanceServiceImpl implements RunInstanceService {

    private final RunInstanceRepository runInstanceRepository;

    public RunInstanceServiceImpl(RunInstanceRepository runInstanceRepository){
        this.runInstanceRepository = runInstanceRepository;
    }

    @Override
    public RunInstance getRunInstanceByName(String name)
    {
        return this.runInstanceRepository.findByName(name);
    }
}

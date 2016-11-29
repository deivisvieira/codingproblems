package br.com.cloudapi.service;

import br.com.cloudapi.model.RunInstance;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

    @Override
    public void addRunInstance(RunInstance runInstance)
    {
        this.runInstanceRepository.save(runInstance);
    }

    @Transactional(readOnly = true)
    public List<RunInstance> getAllRunInstance()
    {
        return this.runInstanceRepository.findAll();
    }
}

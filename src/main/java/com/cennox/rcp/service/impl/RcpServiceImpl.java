package com.cennox.rcp.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.cennox.rcp.entity.Acquirer;
import com.cennox.rcp.repository.AcquirerRepository;
import com.cennox.rcp.service.RcpService;

@Service
public class RcpServiceImpl implements RcpService{

    private Logger logger = LoggerFactory.getLogger(RcpServiceImpl.class);

    private final AcquirerRepository acquirerRepository;

    public RcpServiceImpl(AcquirerRepository acquirerRepository) {
        this.acquirerRepository = acquirerRepository;
    }

    @Override
    public Acquirer createAcquirer(Acquirer acquirer) {
        if(acquirer.getAcquirerName() == null || acquirer.getAcquirerName().isEmpty()) {
            logger.info("Acquirer name is required");
        }
        return acquirerRepository.save(acquirer);
    }

    @Override
    public Acquirer updateAcquirer(Acquirer acquirer) {
        Optional<Acquirer> existingAcquirer = acquirerRepository.findByAcquirerId(acquirer.getAcquirerId());
        if(existingAcquirer.isEmpty()) {
           logger.info("Acquirer not found");
           return null;
        }
        existingAcquirer.get().setAcquirerName(acquirer.getAcquirerName());
        existingAcquirer.get().setCode(acquirer.getCode());
        existingAcquirer.get().setCountry(acquirer.getCountry());
        existingAcquirer.get().setCurrency(acquirer.getCurrency());
        return acquirerRepository.save(existingAcquirer.get());
        
    }

    @Override
    public Acquirer getAcquirerById(UUID acquirerId) {
        Optional<Acquirer> acquirer = acquirerRepository.findByAcquirerId(acquirerId);
        if(acquirer.isEmpty()) {
            logger.info("Acquirer not found");
            return null;
        }
        return acquirer.get();  
    }

    @Override
    public List<Acquirer> getAllAcquirers() {
        return acquirerRepository.findAll();
    }

    @Override
    public void deleteAcquirer(UUID acquirerId) {
        Optional<Acquirer> acquirer = acquirerRepository.findByAcquirerId(acquirerId);
        if(acquirer.isEmpty()) {
            logger.info("Acquirer not found");
        } else {
            acquirerRepository.delete(acquirer.get());
        }
    }

}

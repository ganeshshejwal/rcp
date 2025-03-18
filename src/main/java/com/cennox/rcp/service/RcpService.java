package com.cennox.rcp.service;

import java.util.List;
import java.util.UUID;

import com.cennox.rcp.entity.Acquirer;

public interface RcpService {

    public Acquirer createAcquirer(Acquirer acquirer);

    public Acquirer updateAcquirer(Acquirer acquirer);
    
    public Acquirer getAcquirerById(UUID acquirerId);

    public List<Acquirer> getAllAcquirers();

    public void deleteAcquirer(UUID acquirerId);
} 

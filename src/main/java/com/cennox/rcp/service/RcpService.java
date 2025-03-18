package com.cennox.rcp.service;

import com.cennox.rcp.entity.Device;

import java.util.List;
import java.util.UUID;

public interface RcpService {

    Device createDevice(Device device);

    Device getDeviceById(UUID id);

    List<Device> getAllDevices();

    Device updateDevice(UUID id, Device device);

    String deleteDevice(UUID id);
    
} 

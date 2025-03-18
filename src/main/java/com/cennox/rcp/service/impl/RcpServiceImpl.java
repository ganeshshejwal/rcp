package com.cennox.rcp.service.impl;

import com.cennox.rcp.entity.Device;
import com.cennox.rcp.repository.DeviceRepository;
import com.cennox.rcp.service.RcpService;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class RcpServiceImpl implements RcpService {

    private DeviceRepository deviceRepository;

    public RcpServiceImpl(DeviceRepository deviceRepository) {
        this.deviceRepository = deviceRepository;
    }

    @Override
    public Device createDevice(Device device) {
        return deviceRepository.save(device);
    }

    @Override
    public Device getDeviceById(UUID id) {
        Optional<Device> exisitingOptional = deviceRepository.findById(id);
        return exisitingOptional.get();
    }

    @Override
    public List<Device> getAllDevices() {
        return deviceRepository.findAll();
    }

    @Override
    public Device updateDevice(UUID id, Device device) {
        Device existingDevice = getDeviceById(id);
        existingDevice.setTerminalId(device.getTerminalId());
        existingDevice.setMerchantId(device.getMerchantId());
        existingDevice.setDeviceType(device.getDeviceType());
        existingDevice.setLocation(device.getLocation());
        return deviceRepository.save(existingDevice);
    }

    @Override
    public String deleteDevice(UUID id) {
        deviceRepository.deleteById(id);
        return "Device Deleted Sucessfully";
    }

}

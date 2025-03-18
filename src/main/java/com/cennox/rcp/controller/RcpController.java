package com.cennox.rcp.controller;

import com.cennox.rcp.entity.Device;
import com.cennox.rcp.service.RcpService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/rcp")
public class RcpController {

    private RcpService rcpService;

    public RcpController(RcpService rcpService) {
        this.rcpService = rcpService;
    }

    @PostMapping
    public ResponseEntity<Device> createDevice(@RequestBody Device device) {
        return ResponseEntity.ok(rcpService.createDevice(device));
    }

    @GetMapping("/device/{id}")
    public ResponseEntity<Device> getDeviceById(@PathVariable UUID id) {
        Device device = rcpService.getDeviceById(id);
        return ResponseEntity.ok(device);
    }

    @GetMapping("/device")
    public ResponseEntity<List<Device>> getAllDevices() {
        return ResponseEntity.ok(rcpService.getAllDevices());
    }

    @PutMapping("/device/{id}")
    public ResponseEntity<Device> updateDevice(@PathVariable UUID id, @RequestBody Device device) {
        return ResponseEntity.ok(rcpService.updateDevice(id, device));
    }

    @DeleteMapping("/device/{id}")
    public ResponseEntity<String> deleteDevice(@PathVariable UUID id) {
        return ResponseEntity.ok(rcpService.deleteDevice(id));
    }

}

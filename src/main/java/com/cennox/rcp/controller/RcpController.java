package com.cennox.rcp.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cennox.rcp.entity.Acquirer;
import com.cennox.rcp.entity.Device;
import com.cennox.rcp.service.RcpService;

@RestController
@RequestMapping("/api/rcp")
public class RcpController {

    private final RcpService rcpService;

    public RcpController(RcpService rcpService) {
        this.rcpService = rcpService;
    }

    @PostMapping
    public ResponseEntity<Device> createDevice(@RequestBody Device device) {
        return ResponseEntity.ok(rcpService.createDevice(device));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Device> getDeviceById(@PathVariable UUID id) {
        Device device = rcpService.getDeviceById(id);
        return ResponseEntity.ok(device);
    }

    @GetMapping
    public ResponseEntity<List<Device>> getAllDevices() {
        return ResponseEntity.ok(rcpService.getAllDevices());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Device> updateDevice(@PathVariable UUID id, @RequestBody Device device) {
        return ResponseEntity.ok(rcpService.updateDevice(id, device));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDevice(@PathVariable UUID id) {
        return ResponseEntity.ok(rcpService.deleteDevice(id));
    }

    @PostMapping("/acquirer/create")
    public Acquirer createAcquirer(@RequestBody Acquirer acquirer) {
        return rcpService.createAcquirer(acquirer);
         
    }

    @GetMapping("/acquirer/get")
    public Acquirer getAcquirerById(@RequestParam("acquirerId") UUID acquirerId) {
        return rcpService.getAcquirerById(acquirerId);
       
    }

    @GetMapping("/acquirer/getAll")
    public List<Acquirer> getAllAcquirers() {
        return rcpService.getAllAcquirers();
    }

    @PutMapping("/acquirer/update")
    public Acquirer updateAcquirer(@RequestBody Acquirer acquirer) {
        return rcpService.updateAcquirer(acquirer);
    }

    @DeleteMapping("/acquirer/delete/{acquirerId}")   
    public void deleteAcquirer(@PathVariable UUID acquirerId) {
        rcpService.deleteAcquirer(acquirerId);
    }

}

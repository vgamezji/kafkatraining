package com.vgj.training.kafa.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KeepAliveController {

    @GetMapping("/keepalive")
    public ResponseEntity keepalive() {
        return ResponseEntity.ok("OK");
    }


}

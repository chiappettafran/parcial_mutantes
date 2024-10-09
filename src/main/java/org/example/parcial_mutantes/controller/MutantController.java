package org.example.parcial_mutantes.controller;

import org.example.parcial_mutantes.dto.DnaRequest;
import org.example.parcial_mutantes.service.MutantService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mutant")
public class MutantController {
    private final MutantService mutantService;

    public MutantController(MutantService mutantService) {
        this.mutantService = mutantService;
    }

    @PostMapping("/")
    public ResponseEntity<?> checkMutant(@RequestBody DnaRequest dnaRequest) {
        boolean isMutant = mutantService.isMutant(dnaRequest.getDna());
        if (isMutant) {
            return ResponseEntity.ok().build(); // HTTP 200-OK
        } else {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build(); // HTTP 403-Forbidden
        }
    }

    @GetMapping("/stats")
    public ResponseEntity<?> getStats() {
        return ResponseEntity.ok(mutantService.getStats());
    }
}

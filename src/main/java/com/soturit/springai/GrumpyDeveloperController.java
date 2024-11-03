package com.soturit.springai;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ai")
public class GrumpyDeveloperController {
    private final GrumpyDeveloperService grumpyDeveloperService;

    public GrumpyDeveloperController(GrumpyDeveloperService grumpyDeveloperService) {
        this.grumpyDeveloperService = grumpyDeveloperService;
    }

    @GetMapping("/excuse")
    public ResponseEntity<String> excuse(){
        return ResponseEntity.ok(grumpyDeveloperService.getExcuse());
    }

    @GetMapping("/excusefor")
    public ExcuseResponse excusefor(@RequestParam(value = "reason", defaultValue = "missing a deadline") String reason) {
        return new ExcuseResponse(grumpyDeveloperService.getExcuseFor(reason));
    } 
}

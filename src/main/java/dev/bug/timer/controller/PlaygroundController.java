package dev.bug.timer.controller;

import dev.bug.timer.services.PlaygroundService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/timer")
public class PlaygroundController {

    private final PlaygroundService playgroundService;

    public PlaygroundController(PlaygroundService playgroundService) {
        this.playgroundService = playgroundService;
    }

    @PostMapping("/run")
    public ResponseEntity<Void> runHelloWorld() {
        playgroundService.runHelloWorldJob();
        return ResponseEntity.ok().build();
    }
}

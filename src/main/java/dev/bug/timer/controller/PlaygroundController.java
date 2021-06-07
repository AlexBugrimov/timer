package dev.bug.timer.controller;

import dev.bug.timer.info.TimerInfo;
import dev.bug.timer.services.PlaygroundService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping
    public ResponseEntity<List<TimerInfo>> getAllRunningTimers() {
        return ResponseEntity.ok(playgroundService.getAllRunningTimers());
    }

    @GetMapping("/{timerId}")
    public ResponseEntity<TimerInfo> getRunningTimer(@PathVariable String timerId) {
        return ResponseEntity.ok(playgroundService.getRunningTimer(timerId));
    }
}

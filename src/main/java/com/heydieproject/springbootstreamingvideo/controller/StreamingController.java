package com.heydieproject.springbootstreamingvideo.controller;

import com.heydieproject.springbootstreamingvideo.service.StreamingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("videos/")
public class StreamingController {
    Logger log = LoggerFactory.getLogger(StreamingController.class);

    @Autowired
    private StreamingService service;

    @GetMapping(value = "{title}", produces = "video/mp4")
    public Mono<Resource> getVideos(@PathVariable("title") String title, @RequestHeader("Range") String range) {
        log.info("Streaming Byte =>> "+ range);
        return service.getVideo(title);
    }
}

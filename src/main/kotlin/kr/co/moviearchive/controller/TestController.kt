package kr.co.moviearchive.controller

import lombok.extern.slf4j.Slf4j
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@Slf4j
@RestController
class TestController {

    private val log = LoggerFactory.getLogger(this::class.java)

    @GetMapping("/info-test")
    fun info(): String {
        log.info("info")
        return "info"
    }

    @GetMapping("/debug-test")
    fun debug(): String {
        log.debug("debug")
        return "debug"
    }

    @GetMapping("/warn-test")
    fun warn(): String {
        log.warn("warn")
        return "warn"
    }

    @GetMapping("/error-test")
    fun error(): String {
        log.error("error")
        return "error"
    }
}
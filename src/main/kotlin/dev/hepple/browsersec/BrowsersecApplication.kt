package dev.hepple.browsersec

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class BrowsersecApplication

fun main(args: Array<String>) {
    runApplication<BrowsersecApplication>(*args)
}

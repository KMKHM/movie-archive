package kr.co.moviearchive

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class MovieArchiveApplication

fun main(args: Array<String>) {
    runApplication<MovieArchiveApplication>(*args)
}

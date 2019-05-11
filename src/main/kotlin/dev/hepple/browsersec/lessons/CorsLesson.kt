package dev.hepple.browsersec.lessons

import dev.hepple.browsersec.common.LessonScripts
import dev.hepple.browsersec.common.Properties
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.util.MultiValueMap
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import java.util.*

@RequestMapping("/cors")
@Controller
class CorsLesson(val properties: Properties, val scripts : LessonScripts) {

    @GetMapping
    fun index(model: Model): String {
        model.addAllAttributes(properties.as_map())

        model.addAttribute("lesson1_script",
                scripts.as_text(scripts.cors_lesson1_js))
        model.addAttribute("lesson2_script",
                scripts.as_text(scripts.cors_lesson2_js))
        model.addAttribute("lesson2_google_script",
                scripts.as_text(scripts.cors_lesson2_google_js))
        model.addAttribute("lesson2_asterisk_script",
                scripts.as_text(scripts.cors_lesson2_asterisk_js))



        model.addAttribute("domainMatches",
                if (properties.primaryDomain == properties.secondaryDomain) "✅" else "❌")
        model.addAttribute("protocolMatches",
                if (properties.primaryProtocol == properties.secondaryProtocol) "✅" else "❌")
        model.addAttribute("portMatches",
                if (properties.primaryPort == properties.secondaryPort) "✅" else "❌")


        return "lessons/cors"
    }

    @GetMapping("/the_date")
    fun response_no_cors(): ResponseEntity<String> {
        return ResponseEntity(Date().toString(), HttpStatus.OK)
    }

    @GetMapping("/the_date_cors")
    fun response_cors(): ResponseEntity<String> {
        var headers = HttpHeaders()
        headers["Access-Control-Allow-Origin"] = properties.primaryFullHost()
        return ResponseEntity(Date().toString(), headers, HttpStatus.OK)
    }

    @GetMapping("/the_date_cors_google")
    fun response_cors_google(): ResponseEntity<String> {
        var headers = HttpHeaders()
        headers["Access-Control-Allow-Origin"] = "https://www.google.com"
        return ResponseEntity(Date().toString(), headers, HttpStatus.OK)
    }

    @GetMapping("/the_date_cors_asterisk")
    fun response_cors_asterisk(): ResponseEntity<String> {
        var headers = HttpHeaders()
        headers["Access-Control-Allow-Origin"] = "*"
        return ResponseEntity(Date().toString(), headers, HttpStatus.OK)
    }



}
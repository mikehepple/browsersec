package dev.hepple.browsersec.common

import com.samskivert.mustache.Mustache
import com.samskivert.mustache.Template
import org.springframework.beans.factory.annotation.Value
import org.springframework.core.io.Resource
import org.springframework.stereotype.Component
import java.nio.file.Files

@Component
class LessonScripts(var properties: Properties) {

    @Value("classpath:lesson_scripts/cors/lesson1.js")
    lateinit var cors_lesson1_js : Resource

    @Value("classpath:lesson_scripts/cors/lesson2.js")
    lateinit var cors_lesson2_js : Resource

    @Value("classpath:lesson_scripts/cors/lesson2_google.js")
    lateinit var cors_lesson2_google_js : Resource

    @Value("classpath:lesson_scripts/cors/lesson2_asterisk.js")
    lateinit var cors_lesson2_asterisk_js : Resource

    fun as_text(resource : Resource) : String {
        val script_template = Files.readString(resource.file.toPath())
        // TODO - cache results
        return Mustache.compiler().compile(script_template).execute(this.properties.as_map())

    }

}
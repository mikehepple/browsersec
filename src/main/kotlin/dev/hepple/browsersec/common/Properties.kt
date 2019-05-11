package dev.hepple.browsersec.common

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component


@Component
class Properties {

    @Value("\${browsersec.targets.primary.protocol}")
    lateinit var primaryProtocol : String

    @Value("\${browsersec.targets.primary.domain}")
    lateinit var primaryDomain : String

    @Value("\${browsersec.targets.primary.port}")
    lateinit var primaryPort : String

    fun primaryFullHost() : String {
        return "${primaryProtocol}://${primaryDomain}:${primaryPort}"
    }

    @Value("\${browsersec.targets.secondary.protocol}")
    lateinit var secondaryProtocol : String

    @Value("\${browsersec.targets.secondary.domain}")
    lateinit var secondaryDomain : String

    @Value("\${browsersec.targets.secondary.port}")
    lateinit var secondaryPort : String

    fun secondaryFullHost() : String {
        return "${secondaryProtocol}://${secondaryDomain}:${secondaryPort}"
    }

    fun as_map() : Map<String, String> {
        return mapOf(
                "primaryProtocol" to primaryProtocol,
                "primaryDomain" to primaryDomain,
                "primaryPort" to primaryPort,
                "primaryFullHost" to primaryFullHost(),
                "secondaryProtocol" to secondaryProtocol,
                "secondaryDomain" to secondaryDomain,
                "secondaryPort" to secondaryPort,
                "secondaryFullHost" to secondaryFullHost()
        )
    }


}
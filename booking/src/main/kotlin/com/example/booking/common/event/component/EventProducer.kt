package com.example.booking.common.event.component

import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.messaging.MessageChannel
import org.springframework.messaging.handler.annotation.Payload
import org.springframework.messaging.support.MessageBuilder
import org.springframework.stereotype.Component

@Component
class EventProducer {

    private val logger = LoggerFactory.getLogger(this::class.java)

    @Autowired
    lateinit var output: MessageChannel

    fun producerJobWithHeader(@Payload eventMessage: String, eventCode: String){
        logger.info("[EVENT] producerJobWithHeader eventMessage : $eventMessage")
        output.send(
            MessageBuilder.withPayload(eventMessage)
            .setHeader("eventCode", eventCode)
            .build()
        )
    }
}
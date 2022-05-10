package com.example.booking.common.event.component

import com.example.booking.common.event.channel.EventChannel
import com.example.booking.common.event.message.Message
import org.slf4j.LoggerFactory
import org.springframework.cloud.stream.annotation.StreamListener
import org.springframework.cloud.stream.messaging.Processor
import org.springframework.messaging.handler.annotation.SendTo
import org.springframework.stereotype.Component

@Component
class EventConsumer {

    private val log = LoggerFactory.getLogger(this::class.java)

    @StreamListener(Processor.INPUT)
    @SendTo(Processor.OUTPUT)
    fun consumer(person: Message): Message {
        log.info("Received : $person")

        // Thread.sleep(5000)

        return person
    }

//    @StreamListener(target = Processor.INPUT, condition = "headers['type']='statics'")
//    fun consumerByHeader(person: Message) {
//        log.info("Received : $person")
//    }
}
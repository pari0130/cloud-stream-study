package com.example.booking.common.event.component

import org.slf4j.LoggerFactory
import org.springframework.cloud.stream.annotation.StreamListener
import org.springframework.cloud.stream.messaging.Sink
import org.springframework.messaging.handler.annotation.Payload
import org.springframework.stereotype.Component

@Component
class EventConsumer {

    private val log = LoggerFactory.getLogger(this::class.java)

//    @StreamListener(Processor.INPUT)
//    @SendTo(Processor.OUTPUT)
//    fun consumer(person: Message): Message {
//        log.info("Received : $person")
//
//        // Thread.sleep(5000)
//
//        return person
//    }

    @StreamListener(target = Sink.INPUT, condition = "headers['eventCode']=='1001'")
    fun consumerWithHeader1001(@Payload eventMessage: String) {
        log.info("[EVENT] consumerWithHeader1001 Received : $eventMessage")
    }

    @StreamListener(target = Sink.INPUT, condition = "headers['eventCode']=='1002'")
    fun consumerWithHeader1002(@Payload eventMessage: String) {
        log.info("[EVENT] consumerWithHeader1002 Received : $eventMessage")
    }
}
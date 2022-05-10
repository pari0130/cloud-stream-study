package com.example.booking.common.event.channel

import org.springframework.cloud.stream.annotation.Input
import org.springframework.cloud.stream.annotation.Output
import org.springframework.messaging.MessageChannel
import org.springframework.messaging.SubscribableChannel

interface EventChannel {
    @Input(INPUT)
    fun inbound(): SubscribableChannel?

    @Output(OUTPUT)
    fun outbound(): MessageChannel?

    companion object {
        const val INPUT = "booking-in"
        const val OUTPUT = "booking-out"
    }
}
package com.example.booking.common.event.message

import com.fasterxml.jackson.databind.ObjectMapper
import org.apache.kafka.common.errors.SerializationException
import org.apache.kafka.common.serialization.Serializer
import org.slf4j.LoggerFactory

class MessageSerializer : Serializer<Message> {

    private val objectMapper = ObjectMapper()
    private val log = LoggerFactory.getLogger(javaClass)

    override fun serialize(topic: String?, data: Message?): ByteArray? {

        log.info("Serializing...")

        return objectMapper.writeValueAsBytes(
            data ?: throw SerializationException("Error when serializing Message to ByteArray[]")
        )
    }

    override fun close() {}
    override fun configure(configs: MutableMap<String, *>?, isKey: Boolean) {}
}
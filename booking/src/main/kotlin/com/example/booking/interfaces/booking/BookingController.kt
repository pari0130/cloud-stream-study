package com.example.booking.interfaces.booking

import com.example.booking.common.event.component.EventProducer
import com.example.booking.common.event.message.Event
import com.example.booking.common.event.message.Message
import com.example.booking.infrastructure.product.FeignProductRemoteService
import com.google.gson.Gson
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(path = ["/bookings"])
class DisplayController(
    val feignProductRemoteService: FeignProductRemoteService,
    val eventProducer: EventProducer
) {

    @GetMapping(path = ["/{bookingsId}"])
    fun getDisplayDetail(@PathVariable bookingsId: String?): String {
        val productInfo = feignProductRemoteService.getProductInfo("12345")
        return String.format("[bookingsId = %s at %s %s ]", bookingsId, System.currentTimeMillis(), productInfo)
    }

    @GetMapping(path = ["/event/{code}"])
    fun sendEvent(@PathVariable code: String?): Event {
        val event = Event(code = code, name = "test event", value = "test value")
        eventProducer.producerJobWithHeader(Gson().toJson(event), code ?: "1001")
        return event
    }
}
package com.example.booking.api

import com.example.booking.service.FeignProductRemoteService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(path = ["/bookings"])
class DisplayController(
    val feignProductRemoteService: FeignProductRemoteService
) {

    @GetMapping(path = ["/{bookingsId}"])
    fun getDisplayDetail(@PathVariable bookingsId: String?): String {
        val productInfo = productInfo
        return String.format("[bookingsId = %s at %s %s ]", bookingsId, System.currentTimeMillis(), productInfo)
    }

    private val productInfo: String?
        get() = feignProductRemoteService.getProductInfo("12345")
}
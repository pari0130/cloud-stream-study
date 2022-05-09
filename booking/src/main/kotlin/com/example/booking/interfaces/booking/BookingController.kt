package com.example.booking.interfaces.booking

import com.example.booking.infrastructure.product.FeignProductRemoteService
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
        val productInfo = feignProductRemoteService.getProductInfo("12345")
        return String.format("[bookingsId = %s at %s %s ]", bookingsId, System.currentTimeMillis(), productInfo)
    }
}
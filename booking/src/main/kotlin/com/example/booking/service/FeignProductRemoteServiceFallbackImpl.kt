package com.example.booking.service

import com.example.booking.service.FeignProductRemoteService
import org.springframework.stereotype.Component

@Component
class FeignProductRemoteServiceFallbackImpl : FeignProductRemoteService {
    override fun getProductInfo(productId: String?): String {
        return "[ this product is sold out ]"
    }
}
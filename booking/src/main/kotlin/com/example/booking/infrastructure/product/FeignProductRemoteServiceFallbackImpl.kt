package com.example.booking.infrastructure.product

import org.springframework.stereotype.Component

@Component
class FeignProductRemoteServiceFallbackImpl : FeignProductRemoteService {
    override fun getProductInfo(productId: String?): String {
        return "[ this product is sold out ]"
    }
}
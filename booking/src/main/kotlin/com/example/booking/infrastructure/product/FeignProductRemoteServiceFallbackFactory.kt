package com.example.booking.infrastructure.product

import feign.hystrix.FallbackFactory
import org.springframework.stereotype.Component

@Component
class FeignProductRemoteServiceFallbackFactory : FallbackFactory<FeignProductRemoteService> {
    override fun create(cause: Throwable): FeignProductRemoteService {
        println("t = $cause")
        return object : FeignProductRemoteService {
            override fun getProductInfo(productId: String?): String? {
                return "[ this product is sold out ]"
            }
        }
    }
}
package com.example.booking.service

import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping

@FeignClient(name = "product", fallbackFactory = FeignProductRemoteServiceFallbackFactory::class)
interface FeignProductRemoteService {
    @RequestMapping(path = ["/products/{productId}"])
    fun getProductInfo(@PathVariable("productId") productId: String?): String?
}
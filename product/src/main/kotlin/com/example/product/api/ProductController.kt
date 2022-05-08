package com.example.product.api

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/products")
class ProductController {
    @GetMapping(path = ["{productId}"])
    fun getProductInfo(@PathVariable productId: String): String? {
        return "[product id = " + productId + " at " + System.currentTimeMillis() + "]"
    }
}
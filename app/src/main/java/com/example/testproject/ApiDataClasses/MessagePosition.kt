package com.example.testproject.ApiDataClasses

data class MessagePosition(
    val adminId: String,
    val amount: String,
    val balance: String,
    val module: String,
    val `operator`: String,
    val position_id: String,
    val quantity: String,
    val retailer_no: String,
    val stockFrom: String,
    val transactionId: String
)
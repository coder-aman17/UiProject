package com.example.testproject.network

data class AdminHomeResponse(
    val status: String,
    val message: String,
    val data: AdminHomeData?
)

data class AdminHomeData(
    val totalUsers: Int,
    val totalOrders: Int,
    val revenue: Double,
    val recentActivity: List<Activity>
)

data class Activity(
    val id: Int,
    val description: String,
    val timestamp: String
)
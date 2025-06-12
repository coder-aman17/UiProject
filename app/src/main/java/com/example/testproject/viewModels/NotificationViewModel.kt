package com.example.testproject.viewModels

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class NotificationViewModel : ViewModel() {
    private val _showNotification = MutableStateFlow<Boolean>(true)
    val showNotification = _showNotification.asStateFlow()

    fun hideNotification() {
        _showNotification.value = false
    }

    fun showNotificationAgain() {
        _showNotification.value = true
    }

}

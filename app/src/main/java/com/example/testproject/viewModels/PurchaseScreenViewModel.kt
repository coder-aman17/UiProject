package com.example.testproject.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testproject.ApiDataClasses.DataClass
import com.example.testproject.network.ApiService
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class PurchaseScreenViewModel @Inject constructor(
    private val apiService: ApiService
) : ViewModel() {

    private val _apiData = MutableStateFlow<DataClass?>(null)
    val apiData: StateFlow<DataClass?> = _apiData.asStateFlow()

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading.asStateFlow()

    private val _errorMessage = MutableStateFlow<String?>(null)
    val errorMessage: StateFlow<String?> = _errorMessage.asStateFlow()

    private val _rawResponse = MutableStateFlow<String?>(null)
    val rawResponse: StateFlow<String?> = _rawResponse.asStateFlow()

    fun fetchAdminHomeData(
        distributorUserId: String = "8289",
        distributorId: String = "10279",
        result:(Response<DataClass>) -> Unit
    ) {
        viewModelScope.launch {
            try {

                _isLoading.value = true
                _errorMessage.value = null
                _rawResponse.value = null

                val response = apiService.getAdminHome(distributorUserId, distributorId)

                result(response)
                // Get raw response string
                val rawResponseString = if (response.isSuccessful) {
                    response.body()?.toString() ?: "Empty response body"
                } else {
                    response.errorBody()?.string() ?: "No error body"
                }

                _rawResponse.value =
                    "Response Code: ${response.code()}\nRaw Response: $rawResponseString"

                if (response.isSuccessful) {
                    val responseBody = response.body()
                    _apiData.value = responseBody
                } else {
                    val errorMsg = "Error: ${response.code()} ${response.message()}"
                    _errorMessage.value = errorMsg
                }
            } catch (e: Exception) {
                val errorMsg = "Network error: ${e.message}"
                _errorMessage.value = errorMsg
                _rawResponse.value =
                    "Exception: ${e.message}\nStackTrace: ${e.stackTraceToString()}"
            } finally {
                _isLoading.value = false
            }
        }
    }
}

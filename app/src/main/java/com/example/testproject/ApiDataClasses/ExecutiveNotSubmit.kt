package com.example.testproject.ApiDataClasses

data class ExecutiveNotSubmit(
    val cash_detail: String,
    val cheque_detail: String,
    val dsr_date: String,
    val dsr_id: String,
    val dsr_time: String,
    val fse_id: String,
    val fse_name: String,
    val fse_phone: String,
    val status: String,
    val submit_date: String,
    val submit_time: String,
    val total_amount: String
)
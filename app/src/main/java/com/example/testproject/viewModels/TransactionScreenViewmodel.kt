package com.example.testproject.viewModels

import androidx.lifecycle.ViewModel
import com.example.testproject.DataClass.Item
import com.example.testproject.R
import com.example.testproject.DataClass.Section
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow


class TransactionScreenViewmodel : ViewModel() {


    private val _isBottomSheetVisible = MutableStateFlow(false)
    val isBottomSheetVisible : StateFlow<Boolean> = _isBottomSheetVisible.asStateFlow()

    private val _bottomSheetData = MutableStateFlow<List<Section>>(emptyList())
    val bottomSheetData: StateFlow<List<Section>> = _bottomSheetData.asStateFlow()

    fun showBottomSheet(){
        _isBottomSheetVisible.value = true
    }

    fun hideBottomSheet(){
        _isBottomSheetVisible.value = false
    }
    fun showBottomSheetData(){
        val sections = listOf(
            Section(
                title = "Sale Transaction",
                items = listOf(
                    Item("Register", R.drawable.register),
                    Item("Monthly invoices", R.drawable.mi),
                    Item("Party Ledger", R.drawable.partyledger),
                    Item("Payment in", R.drawable.payin),
                    Item("Credit Note", R.drawable.creditnotice),
                    Item("E-Way", R.drawable.eway),
                    Item("E Transaction", R.drawable.etrans),
                    Item("MultiRecharge", R.drawable.multi)
                )
            ),
            Section(
                title = "Purchase Transaction",
                items = listOf(
                    Item("Register", R.drawable.debit),
                    Item("Debit Note", R.drawable.debit),
                    Item("Part Ledger", R.drawable.partyledger),
                    Item("Payment Out", R.drawable.payout)
                )
            ),
            Section(
                title = "Stock Monitoring",
                items = listOf(
                    Item("Stock Register", R.drawable.stockreg),
                    Item("FSE", R.drawable.fse),
                    Item("DSR Collection", R.drawable.dcr)
                )
            )
        )
        _bottomSheetData.value = sections
    }
}

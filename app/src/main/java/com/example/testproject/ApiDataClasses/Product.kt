package com.example.testproject.ApiDataClasses

data class Product(
    val CGST: String,
    val IGST: String,
    val SGST: String,
    val alias: String,
    val batch_detail: List<Any>,
    val category_id: String,
    val category_name: String,
    val cess_amt: String,
    val cess_app: String,
    val cess_percentage: String,
    val consumable_raw_product: String,
    val consume_detail: List<Any>,
    val conversion_detail: List<ConversionDetail>,
    val data_type: String,
    val dealer_price: String,
    val decimal_category: String,
    val disc_percentage: String,
    val disc_percentage_amt: String,
    val discount: String,
    val free_stock: String,
    val hsn_code: String,
    val item_type: String,
    val low_stock_quantity: String,
    val maintain_inventory: String,
    val mrp: String,
    val product_category: String,
    val product_id: String,
    val product_name: String,
    val product_price: String,
    val product_price_exc: String,
    val product_type: String,
    val purchase_price: String,
    val purchase_price_exc: String,
    val secondary_unit: String,
    val serial_type: String,
    val stock_quantity: String,
    val subcategory_id: String,
    val subcategory_name: String,
    val tcs_tds_applicable: String,
    val unit: String
)
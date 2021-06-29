package nastya.shymanovich.casher.domain.db.entity

data class CashEntity (
    val category: String,
    val currency: String,
    val comment: String,
    val date: String,
    val income: Boolean,
    val timestamp: Long
)
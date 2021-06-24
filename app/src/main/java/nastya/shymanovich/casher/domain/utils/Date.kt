package nastya.shymanovich.casher.domain.utils

data class Date(
    val year: Int = 0,
    val monthOfYear: Int = 0,
    val dayOfMonth:Int = 0
) {
    override fun toString(): String {
        return "$dayOfMonth/$monthOfYear/$year"
    }
}

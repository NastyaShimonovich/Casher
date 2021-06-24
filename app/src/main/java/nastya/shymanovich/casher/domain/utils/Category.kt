package nastya.shymanovich.casher.domain.utils

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

enum class Category (@DrawableRes val resId: Int? = null, @StringRes val nameCategory: Int? = null) {
    PETS,
    SALARY,
    BONUS,
    GIFT,
    CINEMA,
    CAFE,
    TRAVEL,
    REPAIR,
    TRANSACTIONS,
    DRINK,
    EAT,
    SPORT,
    OTHERS,
    FASTFOOD,
    HOTEL,
    SHOPPING;

    companion object {
        fun getList(): List<Category> {
            return values().toList()
        }
    }
}
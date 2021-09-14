package ru.sber.functional

object PowFactory {
    /**
     * Возвращает функцию, которая всегда возводит аргумент в нужную степень, указанную при создании функции.
     */
    fun buildPowFunction(pow: Int): (Any) -> Any {
        return { x: Any ->
            if (pow == 0) {
                when (x) {
                    is String, is Char -> x
                    is Double, is Float -> 1.0
                    else -> 1
                }
            } else if (x is String || x is Char) {
                var ans = ""
                val value = x.toString()
                repeat(pow) { ans += value }
                ans
            } else {
                var ans = 1.0
                val value = (x).toString().toDouble()
                repeat(pow) { ans *= value }
                if (x is Double || x is Float) ans else ans.toInt()
            }
        }
    }
}
package ru.sber.functional

object PowFactory {
    /**
     * Возвращает функцию, которая всегда возводит аргумент в нужную степень, указанную при создании функции.
     */
    fun buildPowFunction(pow: Int): (Int) -> Int {
        return { x: Int ->
            if (pow == 0)
                1
            else {
                var ans = 1
                repeat(pow) { ans *= x }
                ans
            }
        }
    }
}
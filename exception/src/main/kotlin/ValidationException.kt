class ValidationException(val errorCode: Array<ErrorCode>) : RuntimeException(errorCode.joinToString(",") { it.msg })

enum class ErrorCode(val code: Int, val msg: String) {
    INVALID_CHARACTER(100, "Недопустимый символ"),
    TOO_LONG(101, "Слишком длинный"),
    NOT_BE_EMPTY(102, "Значение не может быть null"),
    INVALID_SNILS(103, "Неверный номер СНИЛС")
}
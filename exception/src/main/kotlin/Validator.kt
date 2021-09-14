import kotlin.math.exp

abstract class Validator<T> {
    abstract fun validate(value: T?): List<ErrorCode>
}

class NameValidator : Validator<String>() {
    override fun validate(value: String?): List<ErrorCode> {
        val pattern = "[А-Я][а-я]+".toRegex()

        value?.let {
            if (!it.matches(pattern))
                return listOf(ErrorCode.INVALID_CHARACTER)
            if (it.length > 16)
                return listOf(ErrorCode.TOO_LONG)
        } ?: return listOf(ErrorCode.NOT_BE_EMPTY)
        return emptyList()
    }
}

class PhoneValidator : Validator<String>() {
    override fun validate(value: String?): List<ErrorCode> {
        val pattern = "(7|8)[0-9]{10}$".toRegex()

        value?.let {
            if (!it.matches(pattern))
                return listOf(ErrorCode.INVALID_CHARACTER)
            if (it.length > 11)
                return listOf(ErrorCode.TOO_LONG)
        } ?: return listOf(ErrorCode.NOT_BE_EMPTY)
        return emptyList()
    }
}

class EmailValidator : Validator<String>() {
    override fun validate(value: String?): List<ErrorCode> {
        val pattern = "[\\w_\\.]+@\\w+(\\.[A-Za-z]{2,3})$".toRegex()

        value?.let {
            if (!it.matches(pattern))
                return listOf(ErrorCode.INVALID_CHARACTER)
            if (it.length > 32)
                return listOf(ErrorCode.TOO_LONG)
        } ?: return listOf(ErrorCode.NOT_BE_EMPTY)
        return emptyList()
    }
}

class SnilsValidator : Validator<String>() {
    override fun validate(value: String?): List<ErrorCode> {
        val pattern = "\\d{11}".toRegex()

        value?.let {
            if (!it.matches(pattern)) {
                println("VALUE = $value")
                return listOf(ErrorCode.INVALID_CHARACTER)
            }
            if (it.length > 11)
                return listOf(ErrorCode.TOO_LONG)
            var sum = 0
            for (i in 0..it.lastIndex - 2) {
                sum += (it[i] - '0') * (9 - i)
            }
            val controlNumber = it.substring(9, 11)
            var expectedControlNumber = "00"
            if (sum < 100)
                expectedControlNumber = if (sum.toString().length < 2) "0${sum}" else sum.toString()
            else if (sum > 101) {
                val mod = sum % 101
                expectedControlNumber = if (mod.toString().length < 2) "0${mod}" else mod.toString()
            }
            if (expectedControlNumber != controlNumber)
                return listOf(ErrorCode.INVALID_SNILS)
        } ?: return listOf(ErrorCode.NOT_BE_EMPTY)
        return emptyList()
    }
}

class VersionValidator : Validator<String>() {
    override fun validate(value: String?): List<ErrorCode> {
        val pattern = "\\d+".toRegex()

        if (value == null || !value.matches(pattern))
            return listOf(ErrorCode.INVALID_CHARACTER)
        return emptyList()
    }
}
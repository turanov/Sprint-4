abstract class Validator<T> {
    abstract fun validate(value: T?): List<ErrorCode>
}

class NameValidator : Validator<String>() {
    override fun validate(value: String?): List<ErrorCode> {
        val pattern = "[a-zA-zа-яА-я]+".toRegex()

        if (value == null || !value.matches(pattern))
            return listOf(ErrorCode.INVALID_CHARACTER)
        return emptyList()
    }
}

class PhoneValidator : Validator<String>() {
    override fun validate(value: String?): List<ErrorCode> {
        val pattern = "(\\+7|8)[0-9]{10}$".toRegex()

        if (value == null || !value.matches(pattern))
            return listOf(ErrorCode.INVALID_CHARACTER)
        return emptyList()
    }
}

class EmailValidator : Validator<String>() {
    override fun validate(value: String?): List<ErrorCode> {
        val pattern = "[\\w_\\.]+@\\w+(\\.[A-Za-z]{2,3})$".toRegex()

        if (value == null || !value.matches(pattern))
            return listOf(ErrorCode.INVALID_CHARACTER)
        return emptyList()
    }
}

class SnilsValidator : Validator<String>() {
    override fun validate(value: String?): List<ErrorCode> {
        val pattern = "\\d{11}".toRegex()

        if (value == null || !value.matches(pattern))
            return listOf(ErrorCode.INVALID_CHARACTER)
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
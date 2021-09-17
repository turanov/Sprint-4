package ru.sber.functional

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test


class PowFactoryTest {
    @Test
    fun `buildPowFunction should return lambda It should calculate to second power`() {
        assertEquals(1, PowFactory.buildPowFunction(0)(0))
        assertEquals(2, PowFactory.buildPowFunction(1)(2))
        assertEquals(25, PowFactory.buildPowFunction(2)(5))
        assertEquals(1024, PowFactory.buildPowFunction(10)(2))
        assertEquals(100000, PowFactory.buildPowFunction(5)(10))
        assertEquals(16, PowFactory.buildPowFunction(4)(2))
    }

    @Test
    fun `filterByPredicate should return filtered by predicate`() {
        val studentsGroup = StudentsGroup()
        studentsGroup.initStudents(
            listOf(
                Student(firstName = "Ruslan", lastName = "Agaev", averageRate = 3.1),
                Student(firstName = "Vladislav", lastName = "Yakupov", averageRate = 3.2),
                Student(firstName = "Dmitriy", lastName = "Dzhalgin", averageRate = 3.3),
                Student(firstName = "Igor", lastName = "Ariskin", averageRate = 3.3),
                Student(firstName = "Elvina", lastName = "Ganieva", averageRate = 3.3),
                Student(firstName = "Alexey", lastName = "Knyazhev", averageRate = 3.6),
                Student(firstName = "Ruslan", lastName = "Masgutov", averageRate = 3.7),
                Student(firstName = "Igor", lastName = "Bostan", averageRate = 3.7),
                Student(firstName = "Ruslan", lastName = "Masgutov", averageRate = 3.7),
                Student(firstName = "Igor", lastName = "Pupkin", averageRate = 3.7)
            )
        )
        fun predicate1(student: Student) = student.firstName == "Igor"
        fun predicate2(student: Student) = student.averageRate > 3.3
        fun predicate3(student: Student) = student.age == 20

        assertEquals(3, studentsGroup.filterByPredicate(::predicate1).size)
        assertEquals(5, studentsGroup.filterByPredicate(::predicate2).size)
        assertEquals(studentsGroup.students.size, studentsGroup.filterByPredicate(::predicate3).size)

    }
}

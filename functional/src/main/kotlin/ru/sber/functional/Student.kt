package ru.sber.functional

data class Student(
    val firstName: String,
    val lastName: String,
    val middleName: String = "Unknown",
    val age: Int = 20,
    val averageRate: Double,
    val city: String = "Not specified",
    val specialization: String = "No specialization",
    val prevEducation: String? = null,
)


package array.algo_company.kotlin_practice


data class Student(val name: String, val surName: String, val year: String, val group: String) {
    companion object {
        val COMPARE_BY_NAME = compareBy<Student>({ it.name }, { it.surName })
        val COMPARE_BY_GROUP = compareByDescending<Student> { it.year }.thenBy { it.group }
    }
}

fun main() {
    val students = listOf(
        Student("Aman", "Verma", "1990", "A"),
        Student("Naman", "Sharma", "1993", "D"),
        Student("Raman", "Gupta", "1991", "C"),
        Student("Shyam", "Panwar", "1997", "B"),
        Student("Ram", "Lahoty", "1995", "E"),
    )
    students.sortedWith(
        compareBy(
            { it.surName }, { it.group })
    ).forEach(::println)
    println("=================")
    students.sortedWith(Student.COMPARE_BY_NAME).forEach(::println)
}

class Intern(val weeklyWorkload: Int) {
    val baseWorkload = 20

    class Salary {
        val basePay = 50
        val extraHoursPay = 2.8
    }

    val weeklySalary = if (this.weeklyWorkload <= this.baseWorkload) {
        Salary().basePay.toDouble()
    } else {
        Salary().basePay + (this.weeklyWorkload - this.baseWorkload) * Salary().extraHoursPay
    }
}

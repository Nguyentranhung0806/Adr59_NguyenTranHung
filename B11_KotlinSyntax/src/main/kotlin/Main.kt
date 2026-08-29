
fun main() {


    // BÀI 1: NAMED PARAMETER

    println("===== BÀI 1: NAMED PARAMETER =====")

    fun printInfo(name: String, age: Int) {
        println("Tên: $name")
        println("Tuổi: $age")
    }


    printInfo(name = "Nguyen Hung", age = 20)

    // BÀI 2: DEFAULT PARAM

    println()
    println("===== BÀI 2: DEFAULT PARAM =====")

    fun introduce(name: String, age: Int = 20) {
        println("Tên: $name")
        println("Tuổi: $age")
    }


    introduce("Nguyen Hung")


    // BÀI 3: LAMBDA

    println()
    println("===== BÀI 3: LAMBDA =====")


    val sum = { a: Int, b: Int -> a + b }

    println("Tổng = ${sum(10, 20)}")

    // BÀI 4: TRAILING LAMBDA SYNTAX
    
    println()
    println("===== BÀI 4: TRAILING LAMBDA SYNTAX =====")

    fun buildString(builderAction: StringBuilder.() -> Unit): String {
        val sb = StringBuilder()
        sb.builderAction()
        return sb.toString()
    }


    val result = buildString {
        append("Hello")
        append(" World")
    }

    println(result)

}
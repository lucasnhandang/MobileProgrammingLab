data class Product(val id: Int, val name: String, val price: Double)

// Extension function: check if string is short
fun String.isShortName(): Boolean = this.length < 5

// Extension function: reverse string (method 1)
fun String.reverseString1(): String = this.reversed()

// Extension function: reverse string (method 2)
fun String.reverseString2(): String {
    var reversed = ""
    for (i in this.length - 1 downTo 0) {
        reversed += this[i]
    }
    return reversed
}

// Extension function: sort string (method 1)
fun String.sortString1(): String = this.toCharArray().sorted().joinToString("")

// Extension function: sort string (method 2)
fun String.sortString2(): String {
    val chars = this.toCharArray()
    for (i in chars.indices) {
        for (j in i + 1 until chars.size) {
            if (chars[i] > chars[j]) {
                val temp = chars[i]
                chars[i] = chars[j]
                chars[j] = temp
            }
        }
    }
    return String(chars)
}

fun main() {
    val product = Product(1, "Phone", 999.99)
    val s = "dacb"
    println("isShortName: ${s.isShortName()}")
    println("reverseString1: ${s.reverseString1()}")
    println("reverseString2: ${s.reverseString2()}")
    println("sortString1: ${s.sortString1()}")
    println("sortString2: ${s.sortString2()}")
}

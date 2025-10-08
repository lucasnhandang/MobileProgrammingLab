class Book(val title: String, val pages: Int)

fun main() {
    val myBook = Book("The Kotlin Handbook", 350)
    println(myBook.title)
}

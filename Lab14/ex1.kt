  

fun sumUp(num: Int): Int = if (num == 0) num else sumUp(num/10)+num%10

fun main()
{
    println("Введите число")
    val x = readLine()!!.toInt() 
    print("Сумма цифр:" )
    println(sumUp(x))
}

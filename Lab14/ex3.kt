fun proizUp(num: Int): Int = if (num < 10) num else proizUp(num/10)*(num%10)
fun proizDown(num: Int): Int = proizDown(num, 1)
tailrec fun proizDown(num: Int, p: Int): Int = if (num <10) p*num else proizDown(num/10,p*(num%10))

fun sumUp(num: Int): Int = if (num == 0) num else sumUp(num/10)+num%10
fun sumDown(num: Int): Int = sumDown(num, 0)
tailrec fun sumDown(num: Int, sum: Int): Int = if(num == 0) sum else sumDown(num/10,sum+num%10)


fun main01()
{
    println("Введите число")

    val x = readLine()!!.toInt() // тоно будет введен не null
    print("Произведение цифр 1:" )
    println(proizUp(x))
    print("Произведение цифр 2:" )
    println(proizDown(x))
    print("Сумма цифр 1:" )
    println(sumUp(x))
    print("Сумма цифр  2:" )
    println(sumDown(x))
}
}

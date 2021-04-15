fun proizUp(num: Int): Int = if (num < 10) num else proizUp(num/10)*(num%10)
fun proizDown(num: Int): Int = proizDown(num, 1)
tailrec fun proizDown(num: Int, p: Int): Int = if (num <10) p*num else proizDown(num/10,p*(num%10))

fun maxUp(num:Int):Int = if (num < 10) num else if (num%10 > maxUp(num/10)) num%10 else maxUp(num/10)

tailrec fun digitsDown(num : Int, accum : Int, f : (Int, Int) -> Int, pr : (Int) -> Boolean) : Int =
    if ( num == 0) accum else
        digitsDown(num/10, if (pr(num % 10)) f(num % 10, accum) else accum, f, pr)

fun maxDown(num: Int) : Int = digitsDown(num, 0, {a,b -> if (a>b) a else b}, {x -> true})
fun main01()
{
    println("Введите число")

    val x = readLine()!!.toInt() // тоно будет введен не null
    print("Произведение цифр 1:" )
    println(proizUp(x))
    print("Произведение цифр 2:" )
    println(proizDown(x))
    print("Сумма цифр 1:" )
    println(maxUp(x))
    print("Сумма цифр  2:" )
    println(maxDown(x))
}
}

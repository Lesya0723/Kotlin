tailrec fun digitsD(num : Int, acum : Int, f : (Int, Int) -> Int, pr : (Int) -> Boolean) : Int =
    if ( num == 0) acum else
        digitsD(num/10, if (pr(num % 10)) f (num % 10, acum) else acum, f, pr)


fun summa(num: Int) : Int = digitsD(num, 0, {a,b -> a + b},
    {x -> x % 2!= 0 && x>5}) 
fun prv(num: Int) : Int = digitsD(num, 1, {a,b -> a * b},
    {x ->  x>1}) 
fun maxim(num: Int) : Int = digitsD(num, 0, {a,b -> if (a > b) a else b},
    {x -> x % 2 != 0}) 
fun minim(num: Int) : Int = digitsD(num, 9, {a,b -> if (a < b) a else b},
    {x -> x % 2 == 0 }) 

fun main() {
    println("Введите число")
    val x = readLine()!!.toInt()
    println("Сумма цифр числа: ${summa(x)}") 
    println("Произведение цифр числа: ${prv(x)}") 
    println("Минимальная  цифра числа: ${minim(x)}") 
    println("Максимальная  цифра числа: ${maxim(x)}") 
}

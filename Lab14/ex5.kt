tailrec fun digitsD(num : Int, acum : Int, f : (Int, Int) -> Int, pr : (Int) -> Boolean) : Int =
    if ( num == 0) acum else
        digitsD(num/10, if (pr(num % 10)) f (num % 10, acum) else acum, f, pr)
//хвостовой рекурсией после спуска на "дно",возвращаясь наверх, проверяет каждую цифру числа, если она удовлетворяет условию pr, то над ней производится действие f

fun summa(num: Int) : Int = digitsD(num, 0, {a,b -> a + b},
    {x -> x % 2!= 0 && x>5}) // считает сумму нечетных цифр больше 5,в начале summa равна 0
fun prv(num: Int) : Int = digitsD(num, 1, {a,b -> a * b},
    {x ->  x>1}) // считает произведение цифр  больше 1 , в начале prv равно 1
fun maxim(num: Int) : Int = digitsD(num, 0, {a,b -> if (a > b) a else b},
    {x -> x % 2 != 0}) // считает максимальную нечетную цифру, в начале maxim равно 0
fun minim(num: Int) : Int = digitsD(num, 9, {a,b -> if (a < b) a else b},
    {x -> x % 2 == 0 }) // считает минимальеую четную цифру, в начале minim равно 9

fun main() {
    println("Введите число")
    val x = readLine()!!.toInt()
    println("Сумма цифр числа: ${summa(x)}") //выводит сумму нечетных цифр больше 5
    println("Произведение цифр числа: ${prv(x)}") //выводит произведение цифр числа больше 1
    println("Минимальная  цифра числа: ${minim(x)}") //выводит минимальную нечетную цифру числа
    println("Максимальная  цифра числа: ${maxim(x)}") //выводит максимальную четную  цифр числа
}

tailrec fun digitsDownNew(num : Int, acum : Int, f : (Int, Int) -> Int) : Int =
    if ( num == 0) acum else
        digitsDownNew(num / 10, f(num % 10, acum), f)

fun sum(num: Int) : Int = digitsDownNew(num, 0, {a,b -> a + b})
fun pr(num: Int) : Int = digitsDownNew(num, 1, {a,b -> a * b})
fun min(num: Int) : Int = digitsDownNew(num, 9, {a,b -> if (a < b) a else b})
fun max(num: Int) : Int = digitsDownNew(num, 0, {a,b -> if (a > b) a else b})

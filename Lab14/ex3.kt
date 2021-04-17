fun prUp(num: Int): Int = if (num < 10) num else prUp(num / 10) * (num % 10)
fun prDown(num : Int): Int = prDown(num, 1)
tailrec fun prDown(num: Int, p: Int): Int = if (num < 10) p * num else prDown(num/10,p * (num % 10))

fun maxUp(num:Int):Int = if (num < 10) num else if (num % 10 > maxUp(num / 10)) num % 10 else maxUp(num / 10)
fun maxDown(num: Int) : Int = digitsDown(num, 0, {a,b -> if (a > b) a else b}, {x -> true})

fun minUp(num:Int):Int = if (num < 10) num else if (num % 10 < minUp(num / 10)) num % 10 else minUp(num / 10)
fun minDown(num: Int) : Int = digitsDown(num, 9, {a,b -> if (a < b) a else b}, {x -> true})

tailrec fun digitsDown(num : Int, acum : Int, f : (Int, Int) -> Int, pr : (Int) -> Boolean) : Int =
    if ( num == 0) acum else
        digitsDown(num/10, if (pr(num % 10)) f (num % 10, acum) else acum, f, pr)

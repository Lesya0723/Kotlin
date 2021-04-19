fun vzSNumb(x: Int, y: Int): Boolean = if (y == 1) true else (if (x % y == 0) false else vzSNumb(x, y, x / 2 + 1, true))
tailrec fun vzSNumb(x: Int, y: Int, counter: Int, result: Boolean): Boolean = if (counter  == 1) result else {
    if (y % counter == 0 && x % counter == 0) {
        val result1 = false
        vzSNumb(x, y, counter - 1, result1)
    }
    else vzSNumb(x, y, counter - 1, result)
}

fun kolNumbVzS(x: Int, y: Int) : Int = kolNumbVzS(x, y, 0)
fun kolNumbVzS(x: Int, y: Int, counter: Int) : Int = if (y == 0) counter else {
    if (vzSNumb(x, y))
        kolNumbVzS(x, y - 1, counter + 1) else
        kolNumbVzS(x, y - 1, counter)
}


fun sum3(x: Int): Int = sum3(x,0)
tailrec fun sum3(x: Int, sum: Int ): Int = if (x < 10) (if (x % 10 % 3 == 0) sum + x % 10 else sum)
else (if (x % 10 % 3 == 0) sum3(x/10,sum + x % 10)
else sum3(x/10,sum))

fun kol(x: Int, y: Int): Int = kol(x, y, 0)
tailrec fun kol(x: Int, y: Int, counter: Int): Int = if (x == 0) counter else                        //количество взаимно простых цифр числа с заданным
    (if (vzSNumb(x % 10, y)) kol(x / 10, y, counter + 1) else
        kol(x / 10, y, counter))

fun delNumders(x: Int): Int = delNumders(x, x / 2 + 1, x, kol(x, x))
tailrec fun delNumders(x: Int, counter: Int, del: Int, kolNumb: Int): Int = if (counter == 1) del else {    // 1 не включительно, потому что тогда везде будет 1
    if (x % counter == 0)
    {
        if (kol(x, counter, 0) > kolNumb)
            delNumders(x, counter - 1, counter, kol(x, counter)) else
            delNumders(x, counter - 1, counter, kolNumb)
    }
    else
        delNumders(x, counter - 1, del, kolNumb)
}

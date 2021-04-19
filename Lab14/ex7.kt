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

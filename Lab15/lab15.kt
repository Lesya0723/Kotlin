fun arrayInput () : Array <Int>  { println("Введите size")
    val size = readLine()!!.toInt()
    println("Введите элементы")
    val array: Array<Int> = Array<Int>(size, {0})
    arrayInput(array,size)
    return array
}

fun arrayInput (array: Array<Int>, size: Int) : Array <Int> = arrayInput (array, 0, size)

tailrec fun arrayInput (array: Array<Int>, count: Int, size: Int) : Array<Int> = if (count == size) array else
{
    array[count] = readLine()!!.toInt()
    arrayInput(array, count + 1, size)
}

tailrec fun arrayOp(array: Iterator <Int>, f : (Int, Int)-> Int, accum: Int): Int = if (array.hasNext() == false)
    accum else {arrayOp(array, f, f(array.next(),accum))}

fun ex7(a: List<Int>): List<Int>
{
    val num1 = a.drop(2)
    val num2 = a.dropLast(2)
    val aNew = num1 + num2
    return num3
}

fun ind2minElements(a: MutableList<Int>) {
    val list = a.toCollection(mutableListOf<Int>())  
    val min1 = list.min()                           
    val ind1 = a.indexOf(min1)
    while (list.contains(min1) == true)
        list.remove(min1)
    val min2 = list.min()
    val ind2 = a.indexOf(min2)

    println("ind1 = ${ind1 + 1} ")
    println("ind2 = ${ind2 + 1}")
}

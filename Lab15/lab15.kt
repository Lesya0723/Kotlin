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

fun elBMin(a: MutableList<Int>) {
    val min = a.min()
    val ind = a.indexOf(min)
    val elBMin = a.dropLast(a.size - ind)
    for (el in elementsBeforeMin)
        print("$el  ")
}


fun missN(max: Int, l: List<Int>, counter: Int, lNew: List<Int>): List<Int> = if (counter == max) lNew else
    if (l.contains(counter) == false){
        missgN(max, l, counter + 1,lNew.plus(counter))
    }
    else missN(max, l, counter + 1, lNew)

fun missN(l: List<Int>, missN: List<Int>): List<Int> {
    val min = l.min()!!.toInt()
    val max = l.max()!!.toInt()

    return missN(max,l,min + 1,missN)
}

fun printList(l: List<Int>) = printList(l, 0)
fun printList(l: List<Int>, counter: Int): List<Int> = if (counter + 1 > l.size) l else
    if (l.size > counter) { print("${l[counter]}  ")
        printList(l, counter + 1) }
else
        printList(l, counter + 1)

        
        fun kolLoc(l: List<Int>): Int = kolLoc(l,1,0)
fun kolLoc(l: List<Int>, counter: Int, kol: Int): Int = if (counter + 1 > l.size - 1) kol else
    if (l[counter - 1] < l[counter] && l[counter + 1] < l[counter]) kolLoc(l,counter + 2, kol + 1)
    else kolLoc(l,counter + 1, kol)

    fun nearestNumber(l: List<Double>, r: Double) = nearestNumber(l, l[0],r,0)
fun nearestNumber(l: List<Double>, nearestNumber: Double, r: Double, counter: Int): Double = if (l.size - 1 < counter) nearestNumber else
    if (abs(l[counter] - r) < abs(nearestNumber - r)) nearestNumber(l, l[counter], r, counter + 1)
    else nearestNumber(l,nearestNumber,r,counter + 1)

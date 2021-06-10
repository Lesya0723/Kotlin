fun maxNumberInString(s: String, indexSt: Int, indexEnd: Int, numb: Int): Int = if (indexEnd == s.length) numb else
    if (s.codePointAt(indexEnd) == 32)
    {
        if (numb < s.subSequence(indexSt,indexEnd).toString().toInt())
            maxNumberInString(s, indexEnd + 1,indexEnd + 1, s.subSequence(indexSt,indexEnd).toString().toInt())
        else maxNumberInString(s, indexEnd + 1,indexEnd + 1, numb)
    }
    else
    {
        if (indexEnd == s.length - 1 && numb < s.drop(indexSt).toInt())
            maxNumberInString(s, indexSt,indexEnd + 1,s.drop(indexSt).toInt())
        else maxNumberInString(s, indexSt,indexEnd + 1, numb)
    }
    
    fun ex1() {
    print("Input string: ")
    val s = readLine()

    try {
        val listNumbers = s!!.split(" ").map { it.toInt() }
        println("Max number: ${listNumbers.maxOrNull()}")

    }
    catch(e: NumberFormatException) {
        println("Error: ${e.message}. Try again!\n")
        task1()
    }
}


fun ex2(s: String): String {
    fun replace(list: MutableList<String>, i: Int, j: Int) {
        val temp = list[i]
        list[i] = list[j]
        list[j] = temp
    }

    val listOfWords = s.split(" ").toMutableList()
    listOfWords.mapIndexed { i, _ ->  replace(listOfWords, i, Random.nextInt(0, listOfWords.size)) }

    return listOfWords.joinToString(" ")
}


fun ex2_8(s: String): Int {
    val listOfWords = s.split(" ")
    return if (s == "") 0
    else listOfWords.count { it -> it.count() % 2 == 0 }
}

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

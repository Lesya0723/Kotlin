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


fun findDates(s: String): List<String> {
  
    fun numberOfDays(month: String, year: Int): Int =
        when {
            (month == "января") -> 31
            (month == "февраля") && (year % 4 == 0) && ((year % 100 != 0) || (year % 400 == 0)) -> 29
            (month == "февраля") -> 28
            (month == "марта") -> 31
            (month == "апреля") -> 30
            (month == "мая") -> 31
            (month == "июня") -> 30
            (month == "июля") -> 31
            (month == "августа") -> 31
            (month == "сентября") -> 30
            (month == "октября") -> 31
            (month == "ноября") -> 30
            (month == "декабря") -> 31
            else -> throw DataFormatException("Month isn't in range from 1 to 12")
        }
    val text = " $s "

    val checkingDay = "(([1-9])|([1-2][0-9])|(3[0-1]))"

    val months = listOf(
        "декабря", "января", "февраля",
        "марта", "апреля", "мая",
        "июня", "июля", "августа",
        "сентября", "октября", "ноября"
    )
    val checkingMonth = "(${months.joinToString("|")})"


    val checkingYear = "((1[0-9]{3})|(20[0-1][0-9])|(202[0-1]))"

  
    val regexDates = """\s${checkingDay}\s${checkingMonth}\s${checkingYear}\s""".toRegex()

    val listOfDates1 = regexDates.findAll(text).map { it.value.drop(1).dropLast(1).split(" ") }.toList()

  
    val listOfDates2 = listOfDates1.filter { it[0].toInt() <= numberOfDays(it[1], it[2].toInt())}


   
    return listOfDates2.map { it.joinToString(" ") }
}


fun findRussianCharacters(s: String): Int {
    val charactersCode = s.toCharArray().map { it.toInt() }
    return charactersCode.count { ((it >= 1040) && (it <= 1103)) || (it == 1025) || (it == 1105) }
}

fun findLowercaseEnglishCharacters(s: String): Set<Char> {
    val lowercaseCharacters = s.toCharArray().filter { (it.toInt() >= 97) && (it.toInt() <= 122) }
    return lowercaseCharacters.toSet()
}

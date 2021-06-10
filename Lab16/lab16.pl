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
fun findMinNumber(s: String): Int {
    val regexNumbers = "\\d+".toRegex()
    val listOfNumbers = regexNumbers.findAll(s).map { it.value.toInt() }.toList()

    return listOfNumbers.minOrNull() ?: throw IllegalArgumentException("String doesn't contain numbers")
}


fun ex4_launchMenu() {
    println("What task do you want to complete?\n")
    println("0. exit")
    println("1. find number of russian characters")
    println("2. find lowercase english characters")
    println("3. find min number of string\n")
    print(">: ")

    val listTaskNumbers = listOf("1", "2", "3")
    val choice = readLine()

    val s = if (listTaskNumbers.contains(choice)) {
        print("\nInput string: ")
        readLine()!!.toString()
    }
    else ""

    when(choice) {
        "0" -> return
        "1" -> println("Number of russian characters: ${findRussianCharacters(s)}")
        "2" -> println("Lowercase english characters: ${findLowercaseEnglishCharacters(s)}")
        "3" -> {
            try {
                println("Min number of string: ${findMinNumber(s)}")
            }
            catch(e: IllegalArgumentException) {
                println("Error: ${e.message}. Try again!")
            }
        }
        else -> println("Error: there's no such task. Try again!")
    }

    println()
    task4_launchMenu()
}

fun sortStringsByLength(listOfStrings: List<String>): List<String> {
    return listOfStrings.sortedBy { it -> it.length }
}

fun sortStringsByNumberOfWords(listOfStrings: List<String>): List<String> {
 
    val regexSpaces = "\\s{2,}".toRegex()

  
    val listOfStrings2 = listOfStrings.map { it ->
        regexSpaces.replace(it, " ").dropWhile { it == ' ' }.dropLastWhile { it == ' ' } }

  

    val result = listOfStrings.withIndex().sortedBy { it -> listOfStrings2[it.index].split(" ").size }
    return result.map { it -> it.value }
}


fun ex7(listOfStrings: List<String>): List<String> {
    fun findMaxQuantity(it: Iterator<String>, currentQ: Int = 0, max: Int = 0): Int {
        return if (it.hasNext()) {
            val value = it.next()
            if ((value as? Int) != null) {
                if (currentQ > max)
                    findMaxQuantity(it, 0, currentQ)
                else
                    findMaxQuantity(it, 0, max)
            }
            else findMaxQuantity(it, currentQ + 1, max)
        }
        else {
            if (currentQ > max)
                currentQ
            else max
        }
    }

   
    val regexSpaces = "\\s{2,}".toRegex()

    val listOfStrings2 = listOfStrings.map { it ->
        regexSpaces.replace(it, " ").dropWhile { it == ' ' }.dropLastWhile { it == ' ' }.split(" ") }

    val result = listOfStrings.withIndex().sortedBy { it -> findMaxQuantity(listOfStrings2[it.index].iterator()) }
    return result.map { it -> it.value }
}
fun task8_3(listOfStrings: List<String>): List<String> {
    fun getLetterFrequency(letter: Char): Double =
        when(letter) {
            'E' -> 0.1286
            'T' -> 0.0972
            'A' -> 0.0796
            'I' -> 0.0777
            'N' -> 0.0751
            'R' -> 0.0683
            'O' -> 0.0662
            'S' -> 0.0662
            'H' -> 0.0539
            'D' -> 0.0401
            'L' -> 0.0351
            'C' -> 0.0284
            'F' -> 0.0262
            'U' -> 0.0248
            'M' -> 0.0243
            'G' -> 0.0199
            'P' -> 0.0181
            'W' -> 0.018
            'B' -> 0.016
            'Y' -> 0.0152
            'V' -> 0.0115
            'K' -> 0.0041
            'Q' -> 0.0017
            'X' -> 0.0017
            'J' -> 0.0016
            'Z' -> 0.0005
            else -> 0.0
        }

  
    val englishStringsLetters = listOfStrings.map { it1 ->
        it1.filter { it2 -> (it2.toInt() in 65..90) || (it2.toInt() in 97..122) }.toUpperCase() }

 
    val mostCommonLetters = Array(listOfStrings.size) { ' ' }

  
    val frequency = Array(listOfStrings.size) { 0.0 }

    englishStringsLetters.mapIndexed { i, string ->
        
        val letters = string.toSet()
        val counts = Array(letters.size) { 0 }

        
        string.map { letter -> counts[letters.indexOf(letter)] += 1 }

        val indexOfMaxLetter = counts.indexOf(counts.maxOrNull())
        val maxLetter = letters.elementAt(indexOfMaxLetter)

        mostCommonLetters[i] = maxLetter
        frequency[i] = counts[indexOfMaxLetter] / (listOfStrings[i].count() * 1.0)
    }

    val result = listOfStrings.withIndex().sortedBy { it ->
        abs(frequency[it.index] - getLetterFrequency(mostCommonLetters[it.index]))}

    return result.map { it -> it.value }
}

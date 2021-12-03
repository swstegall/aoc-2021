import java.lang.Long.parseLong

class Solver {
  fun readFileAsLinesUsingGetResourceAsStream(fileName: String) =
    this::class.java.getResourceAsStream(fileName).bufferedReader().readLines()

  fun printFile(fileName: String) {
    val lines = readFileAsLinesUsingGetResourceAsStream(fileName)
    for (line in lines) {
      println(line)
    }
  }

  fun solve(fileName: String) {
    val lines = readFileAsLinesUsingGetResourceAsStream(fileName)
    val digits = ArrayList<ArrayList<Int>>()
    for (line in lines) {
      val letters = line.split("")
      val digitsInLine = ArrayList<Int>()
      for (letter in letters) {
        if (letter != "") {
          digitsInLine.add(letter.toInt())
        }
      }
      digits.add(digitsInLine)
    }
    traverse(digits)
  }

  fun traverse(vectors: List<List<Int>>) {
    val rowLength = vectors.get(0).size
    val counters = ArrayList<Int>()
    for (values in vectors.get(0)) {
      counters.add(0)
    }
    for (row in vectors) {
      var counter = 0;
      while (counter < rowLength) {
        if (row.get(counter) == 1) {
          counters[counter]++
        } else {
          counters[counter]--
        }
        counter++
      }
    }
    var gammaString = ""
    var epsilonString = ""
    for (counter in counters) {
      if (counter > 0) {
        gammaString += 1
        epsilonString += 0
      } else {
        gammaString += 0
        epsilonString += 1
      }
    }
    println(parseLong(gammaString, 2) * parseLong(epsilonString, 2))
  }
}
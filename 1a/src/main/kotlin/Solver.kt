class Solver {
  fun readFileAsLinesUsingGetResourceAsStream(fileName: String) =
    this::class.java.getResourceAsStream(fileName).bufferedReader().readLines()

  fun printFile(fileName: String) {
    val lines = readFileAsLinesUsingGetResourceAsStream(fileName)
    for (line in lines) {
      println(line)
    }
  }

  fun traverse(fileName: String) {
    val lines = readFileAsLinesUsingGetResourceAsStream(fileName)
    var i = 0
    var currentValue = 0
    var timesIncreased = 0
    while (i < lines.size) {
      if (i != 0 && currentValue < lines.get(i).toInt()) {
        timesIncreased++
      }
      currentValue = lines.get(i).toInt()
      i++
    }
    println(timesIncreased)
  }
}
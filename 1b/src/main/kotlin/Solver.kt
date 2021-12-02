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

  fun solve2(fileName: String) {
    val lines = readFileAsLinesUsingGetResourceAsStream(fileName)
    val numbers = lines.map { it.toInt() }
    val sums = generateSums(numbers)
    traverse(sums)
  }

  fun generateSums(numbers: List<Int>): List<Int> {
    val sums = ArrayList<Int>()
    var i = 0
    while (i < numbers.size - 2) {
      sums.add(numbers.get(i) + numbers.get(i + 1) + numbers.get(i + 2))
      i++
    }

    return sums
  }

  fun traverse(numbers: List<Int>) {
    var i = 0
    var currentValue = 0
    var timesIncreased = 0
    while (i < numbers.size) {
      if (i != 0 && currentValue < numbers.get(i)) {
        timesIncreased++
      }
      currentValue = numbers.get(i)
      i++
    }
    println(timesIncreased)
  }
}
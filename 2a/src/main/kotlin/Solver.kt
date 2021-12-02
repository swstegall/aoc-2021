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
    val vectors = ArrayList<Pair<String, Int>>()
    for (line in lines) {
      val words = line.split(" ")
      vectors.add(Pair(words[0], words[1].toInt()))
    }
    traverse(vectors)
  }

  fun traverse(vectors: List<Pair<String, Int>>) {
    var down = 0
    var forward = 0
    var i = 0
    for (vector in vectors) {
      when {
        vector.first == "forward" -> {
          forward += vector.second
        }
        vector.first == "down" -> {
          down += vector.second
        }
        vector.first == "up" -> {
          down -= vector.second
        }
      }
    }
    println(down * forward)
  }
}
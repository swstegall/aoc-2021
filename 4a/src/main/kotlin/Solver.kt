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

  fun generateBingoItems(lines: List<String>): Pair<ArrayList<Int>, ArrayList<ArrayList<ArrayList<Int>>>> {
    val calls = ArrayList<Int>()
    val boards = ArrayList<ArrayList<ArrayList<Int>>>()
    var counter = 0
    while (counter < lines.size) {
      if (counter == 0) {
        val preformattedCalls = lines.get(counter).split(",")
        for (call in preformattedCalls) {
          calls.add(call.toInt())
        }
        counter++
      } else if (lines.get(counter) != "") {
        val board = ArrayList<ArrayList<Int>>()
        var rowCounter = 0
        while (rowCounter < 5) {
          val row = ArrayList<Int>()
          var rowIndex = 0
          val preformattedRow = lines.get(counter + rowCounter).trim().replace("  ", " ").split(" ")
          while (rowIndex < 5) {
            row.add(preformattedRow.get(rowIndex).toInt())
            rowIndex++
          }
          board.add(row)
          rowCounter++
        }
        boards.add(board)
        counter += 5
      } else {
        counter++
      }
    }
    return Pair(calls, boards)
  }

  fun solve(fileName: String) {
    val lines = readFileAsLinesUsingGetResourceAsStream(fileName)
    val bingoItems = generateBingoItems(lines)
    println(bingoItems)
  }
}
fun pairDistance(pair: Pair<Int, Int>): Int =
    if(pair.component1() > pair.component2())
        pair.component1() - pair.component2()
    else
        pair.component2() - pair.component1()


fun main() {
    fun part1(input: List<String>): Int {
        val (leftList, rightList) = input.map{it.split("   ")}.map{it[0].toInt() to it[1].toInt()}.toList().unzip()

        var sum = 0
        leftList.sorted().zip(rightList.sorted()).forEach {
            sum += pairDistance(it)
        }
        return sum
    }

    fun part2(input: List<String>): Int {
        val (leftList, rightList) = input.map{it.split("   ")}.map{it[0].toInt() to it[1].toInt()}.toList().unzip()

        var sum = 0
        for (value in leftList) {
            sum += value * rightList.filter{it == value}.size
        }
        return sum
    }

    // Test if implementation meets criteria from the description, like:
    //check(part1(listOf("Day01_test")) == 11)
    //check(part2(listOf("Day01_test")) == 31)

    // Or read a large test input from the `src/Day01_test.txt` file:
    val testInput = readInput("Day01_test")
    check(part1(testInput) == 11)
    check(part2(testInput) == 31)

    // Read the input from the `src/Day01.txt` file.
    val input = readInput("Day01")
    part1(input).println()
    part2(input).println()
}

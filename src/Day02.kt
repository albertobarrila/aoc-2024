

fun countSafe(list: List<Int>): Int{
    val sortedUp = list.zipWithNext { a, b -> a <= b }.all { it }
    val sortedDown = list.zipWithNext { a, b -> a >= b }.all { it }
    if(!sortedUp && !sortedDown) return 0

    val diffs = list.sorted().zipWithNext {a, b -> b - a}
    val safe = diffs.all { i -> i >= 1 && i <= 3  }
    return if(safe) 1 else 0
}

fun countSafeImproved(list: List<Int>): Int{
    val ret = countSafe(list)
    if(ret == 1) return 1

    list.forEachIndexed { i, element ->
        val ret = countSafe(list.filterIndexed { j, e -> j != i })
        if(ret == 1) return 1
    }

    return 0

}

fun main() {
    fun part1(input: List<String>): Int {

        var sum = 0
        input.forEach { t -> sum += countSafe(t.split(" ").map{ t -> t.toInt() })}
        return sum
    }

    fun part2(input: List<String>): Int {
        var sum = 0
        input.forEach { t -> sum += countSafeImproved(t.split(" ").map{ t -> t.toInt() })}
        return sum
    }

    // Test if implementation meets criteria from the description, like:
    //check(part1(listOf("Day01_test")) == 11)
    //check(part2(listOf("Day01_test")) == 31)

    // Or read a large test input from the `src/Day01_test.txt` file:
//    val testInput = readInput("Day02_test")
//    check(part1(testInput) == 1)
//    check(part2(testInput) == 1)

    // Read the input from the `src/Day01.txt` file.
    val input = readInput("Day02")
    part1(input).println()
    part2(input).println()
}
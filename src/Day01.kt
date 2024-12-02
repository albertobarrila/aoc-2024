import kotlin.math.abs

fun main() {
    fun part1(input: List<String>): Int {
        val (leftList, rightList) = input.map{it.split("   ")}.map{it[0].toInt() to it[1].toInt()}.unzip()
        return leftList.sorted().zip(rightList.sorted()).sumOf { (left, right) ->
            abs(left - right)
        }
    }

    fun part2(input: List<String>): Int {
        val (leftList, rightList) = input.map{it.split("   ")}.map{it[0].toInt() to it[1].toInt()}.unzip()
        val frequencies = rightList.groupingBy {it}.eachCount()
        return leftList.sumOf { value -> value * frequencies.getOrDefault(value, 0)}
    }


    val testInput = readInput("Day01_test")
    check(part1(testInput) == 11)
    check(part2(testInput) == 31)

    val input = readInput("Day01")
    part1(input).println()
    part2(input).println()
}

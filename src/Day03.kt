import kotlin.math.abs

fun main() {
    fun part1(input: List<String>): Int {
        val regex = "mul\\(\\d{1,3},\\d{1,3}\\)".toRegex()
        return input
            .flatMap {line -> regex.findAll(line)}
            .map { match -> match.value.replace("mul(", "").replace(")", "") }
            .map {line -> line.split(",")}
            .sumOf {line -> line[0].toInt() * line[1].toInt()}
    }

    fun part2(input: List<String>): Int {
        val regex = "mul\\(\\d{1,3},\\d{1,3}\\)|do\\(\\)|don't\\(\\)".toRegex()
        var enabled = true
        return regex.findAll(input.joinToString()).map { match ->
            if(match.value == "do()") enabled = true
            else if(match.value == "don't()") enabled = false
            else if (enabled) return@map match.value
            ""
        }.filter { string -> string.isNotEmpty() }
            .map { match -> match.replace("mul(", "").replace(")", "") }
            .map {line -> line.split(",")}
            .sumOf {line -> line[0].toInt() * line[1].toInt()}
    }


    val testInput = readInput("Day03_test")
    check(part1(testInput) == 161)
    check(part2(testInput) == 48)

    val input = readInput("Day03")
    part1(input).println()
    part2(input).println()
}

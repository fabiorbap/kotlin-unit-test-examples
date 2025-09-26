package com.fabio.kotlin.unittesting

// Mathematical Functions
object MathUtils {
    /**
     * Calculates the factorial of a given number
     */
    fun factorial(n: Int): Int {
        if (n < 0) throw IllegalArgumentException("Factorial is not defined for negative numbers")
        if (n <= 1) return 1
        return n * factorial(n - 1)
    }

    /**
     * Checks if a number is prime
     */
    fun isPrime(n: Int): Boolean {
        if (n < 2) return false
        if (n == 2) return true
        if (n % 2 == 0) return false

        for (i in 3..kotlin.math.sqrt(n.toDouble()).toInt() step 2) {
            if (n % i == 0) return false
        }
        return true
    }
}

// String Processing Functions
object StringUtils {
    /**
     * Checks if a string is a palindrome (case-insensitive)
     */
    fun isPalindrome(text: String): Boolean {
        val cleaned = text.lowercase().replace(Regex("[^a-z0-9]"), "")
        return cleaned == cleaned.reversed()
    }

    /**
     * Counts the frequency of each character in a string
     */
    fun characterFrequency(text: String): Map<Char, Int> {
        return text.groupingBy { it }.eachCount()
    }

    /**
     * Converts a string to title case
     */
    fun toTitleCase(text: String): String {
        return text.split(" ").joinToString(" ") { word ->
            word.lowercase().replaceFirstChar { it.uppercase() }
        }
    }

    /**
     * Removes duplicate characters while preserving order
     */
    fun removeDuplicateChars(text: String): String {
        val seen = mutableSetOf<Char>()
        return text.filter { seen.add(it) }
    }

    /**
     * Counts the number of words in a text
     */
    fun wordCount(text: String): Int {
        return text.trim().split(Regex("\\s+")).filter { it.isNotEmpty() }.size
    }
}

// List Processing Functions
object ListUtils {
    /**
     * Finds the second largest element in a list
     */
    fun secondLargest(list: List<Int>): Int? {
        if (list.size < 2) return null
        val sorted = list.distinct().sortedDescending()
        return if (sorted.size >= 2) sorted[1] else null
    }

    /**
     * Checks if a list is sorted in ascending order
     */
    fun isSorted(list: List<Int>): Boolean {
        return list.zipWithNext().all { (a, b) -> a <= b }
    }

    /**
     * Rotates a list to the left by n positions
     */
    fun <T> rotateLeft(list: List<T>, positions: Int): List<T> {
        if (list.isEmpty()) return list
        val n = positions % list.size
        return list.drop(n) + list.take(n)
    }

    /**
     * Finds the intersection of two lists
     */
    fun <T> intersection(list1: List<T>, list2: List<T>): List<T> {
        return list1.filter { it in list2 }.distinct()
    }

    /**
     * Groups consecutive elements that satisfy a predicate
     */
    fun <T> groupConsecutive(list: List<T>, predicate: (T) -> Boolean): List<List<T>> {
        val result = mutableListOf<List<T>>()
        var current = mutableListOf<T>()

        for (item in list) {
            if (predicate(item)) {
                current.add(item)
            } else {
                if (current.isNotEmpty()) {
                    result.add(current.toList())
                    current = mutableListOf()
                }
            }
        }

        if (current.isNotEmpty()) {
            result.add(current.toList())
        }

        return result
    }
}

// Date and Time Functions
object DateUtils {
    /**
     * Checks if a year is a leap year
     */
    fun isLeapYear(year: Int): Boolean {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)
    }

    /**
     * Gets the number of days in a given month and year
     */
    fun daysInMonth(month: Int, year: Int): Int {
        return when (month) {
            1, 3, 5, 7, 8, 10, 12 -> 31
            4, 6, 9, 11 -> 30
            2 -> if (isLeapYear(year)) 29 else 28
            else -> throw IllegalArgumentException("Invalid month: $month")
        }
    }

    /**
     * Calculates age in years given a birth year and current year
     */
    fun calculateAge(birthYear: Int, currentYear: Int): Int {
        if (birthYear > currentYear) throw IllegalArgumentException("Birth year cannot be in the future")
        return currentYear - birthYear
    }
}

// Validation Functions
object ValidationUtils {
    /**
     * Validates if an email address has a basic valid format
     */
    fun isValidEmail(email: String): Boolean {
        val emailRegex = Regex("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$")
        return emailRegex.matches(email)
    }

    /**
     * Checks if a password meets basic security requirements
     */
    fun isStrongPassword(password: String): Boolean {
        return password.length >= 8 &&
                password.any { it.isUpperCase() } &&
                password.any { it.isLowerCase() } &&
                password.any { it.isDigit() } &&
                password.any { !it.isLetterOrDigit() }
    }

    /**
     * Validates if a string represents a valid positive integer
     */
    fun isPositiveInteger(input: String): Boolean {
        return input.toIntOrNull()?.let { it > 0 } ?: false
    }

    /**
     * Checks if a phone number has a valid format (simplified)
     */
    fun isValidPhoneNumber(phone: String): Boolean {
        val cleaned = phone.replace(Regex("[^\\d]"), "")
        return cleaned.length in 10..15
    }
}

// Data Processing Functions
object DataUtils {
    /**
     * Calculates the median of a list of numbers
     */
    fun median(numbers: List<Double>): Double? {
        if (numbers.isEmpty()) return null
        val sorted = numbers.sorted()
        val middle = sorted.size / 2

        return if (sorted.size % 2 == 0) {
            (sorted[middle - 1] + sorted[middle]) / 2.0
        } else {
            sorted[middle]
        }
    }

    /**
     * Calculates the mode (most frequent value) of a list
     */
    fun <T> mode(items: List<T>): T? {
        return items.groupingBy { it }
            .eachCount()
            .maxByOrNull { it.value }
            ?.key
    }

    /**
     * Normalizes a list of numbers to a 0-1 range
     */
    fun normalize(numbers: List<Double>): List<Double> {
        if (numbers.isEmpty()) return emptyList()
        val min = numbers.minOrNull() ?: 0.0
        val max = numbers.maxOrNull() ?: 0.0

        return if (min == max) {
            numbers.map { 0.5 } // All values are the same
        } else {
            numbers.map { (it - min) / (max - min) }
        }
    }

    /**
     * Calculates the standard deviation of a list of numbers
     */
    fun standardDeviation(numbers: List<Double>): Double? {
        if (numbers.isEmpty()) return null
        val mean = numbers.average()
        val variance = numbers.map { (it - mean) * (it - mean) }.average()
        return kotlin.math.sqrt(variance)
    }
}
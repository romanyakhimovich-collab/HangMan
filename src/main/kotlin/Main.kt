val words = mutableListOf(
    "apple", "banana", "orange",
    "computer", "keyboard", "internet", "programming", "python",
    "kotlin", "java", "algorithm", "function", "variable",
    "mountain", "river", "forest", "ocean", "desert",
    "puzzle", "mystery", "adventure", "challenge", "science"
)
fun playRound() {
    val targetWord = words.random()
    val hiddenWord = CharArray(targetWord.length) { '_' }
    val usedLetters = mutableSetOf<Char>()
    var lives = 5

    while (lives > 0) {
        println("Word: ${hiddenWord.joinToString("")}")
        println("Lives: $lives")
        print("Guess a letter: ")
        val input = readln()
        val letter = input.lowercase().first()
        if (letter in usedLetters) {
            println("You've already guessed that letter!")
            continue
        }
        usedLetters.add(letter)
        if (letter in targetWord) {
            for (i in targetWord.indices) {
                if (targetWord[i] == letter) {
                    hiddenWord[i] = letter
                }
            }
            println("Good guess!")
        } else {
            lives--
            println("Wrong one!")
        }
        if ('_' !in hiddenWord) {
            println("You won! The word was $targetWord")
            return
        }
    }
    println("You lost! The word was $targetWord")
}

fun main() {
    println("Welcome to HangMan Game!")
    while (true) {
        playRound()

        print("Play again? (y/n): ")
        if (readln() != "y") {
            break
        }
    }
}
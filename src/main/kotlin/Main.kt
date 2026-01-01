fun main() {
    while (true) {
        val words = mutableListOf("apple", "banana", "orange")
        val guessedWord = words.random()
        val hidden = CharArray(guessedWord.length) { '_' }
        var lives = 5
        val usedLetters = mutableSetOf<Char>()
        while (lives > 0) {
            println("Word: ${hidden.joinToString(" ")}")
            println("Lives left: $lives")
            print("Enter your first letter: ")
            val input = readln()
            if (input.isEmpty()) {
                continue
            }
            val letter = input.lowercase()[0]
            if (letter in usedLetters) {
                println("You've already used this letter!")
                continue
            }
            usedLetters.add(letter)
            var found = false
            for (i in guessedWord.indices) {
                if (letter == guessedWord[i]) {
                    hidden[i] = letter
                    found = true
                }
            }
            if (!found) {
                lives--
                println("No such letter in the word!")
            }
            if ('_' !in hidden) {
                println("You won! The word was $guessedWord")
                break
            }
        }
        if (lives == 0) {
            println("You lost! The word was $guessedWord")
            break
        }
        print("Play again? (y/n): ")
        if (readln() != "y") {
            println("Thanks for playing!")
            break
        }
    }
}
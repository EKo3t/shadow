package shadow.english.model

enum class Language(val fullName: String) {
    EN("English"),
    RU("Russian"),
    PL("Polish")
}

data class Word(val word: String, val language: Language)

data class Translation(val wordFrom: Word, val wordTo: Word)


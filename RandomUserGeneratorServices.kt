class JSONService {
    fun getNameAndGenderFromJSON(json: String): Pair<String, String>? {
        val gson = Gson()
        val personData = gson.fromJson(json, Person::class.java)

        val name = personData.name
        val gender = personData.gender

        return if (name != null && gender != null) {
            Pair("${name.title} ${name.first} ${name.last}", gender)
        } else {
            null
        }
    }
}

fun main() {
    val json = """
        {
            /* The provided JSON data */
        }
    """.trimIndent()

    val service = JSONService()
    val nameAndGender = service.getNameAndGenderFromJSON(json)

    if (nameAndGender != null) {
        val (name, gender) = nameAndGender
        println("Name: $name")
        println("Gender: $gender")
    } else {
        println("Failed to extract name and gender from JSON.")
    }
}
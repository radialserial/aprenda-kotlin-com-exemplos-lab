@file:Suppress("UNCHECKED_CAST")
// [Template no Kotlin Playground](https://pl.kotl.in/WcteahpyN)

enum class Nivel { BASICO, INTERMEDIARIO, AVANCADO }

data class Usuario(val email: String, val nome: String, val senha: String)

data class ConteudoEducacional(val nome: String, val duracao: Int = 60, val nivel: Nivel)

data class Formacao(val nome: String, val conteudos: List<ConteudoEducacional>, val inscritos: MutableList<Usuario>) {
    fun matricular(usuario: Usuario) {
        this.inscritos.add(usuario)
    }

}

fun main() {

    val conteudos: MutableMap<String, ConteudoEducacional> = mutableMapOf(
        Pair(
            "Lógica de Programação", ConteudoEducacional(
                "Lógica de Programação",
                60,
                Nivel.BASICO,
            )
        ),
        Pair(
            "Matemática Elementar", ConteudoEducacional(
                "Matemática Elementar",
                60,
                Nivel.BASICO,
            )
        ),
        Pair(
            "POO", ConteudoEducacional(
                "POO",
                120,
                Nivel.INTERMEDIARIO,
            )
        ),
        Pair(
            "Redes de Computadores", ConteudoEducacional(
                "Redes de Computadores",
                240,
                Nivel.INTERMEDIARIO,
            )
        ),
        Pair(
            "Servidores Linux", ConteudoEducacional(
                "Servidores Linux",
                360,
                Nivel.AVANCADO,
            )
        ),
        Pair(
            "Programação em Kotlin", ConteudoEducacional(
                "Programação em Kotlin",
                120,
                Nivel.INTERMEDIARIO,
            )
        ),
        Pair(
            "Programação em Android", ConteudoEducacional(
                "Programação em Android",
                120,
                Nivel.INTERMEDIARIO,
            )
        ),
    )

    val formacoes = mutableMapOf(
        "Administrador de Sistemas" to Formacao(
            "Administrador de Sistemas", listOf(
                conteudos["Lógica de Programação"],
                conteudos["Redes de Computadores"],
                conteudos["Servidores Linux"],
            ) as List<ConteudoEducacional>, mutableListOf()
        ),
        "Desenvolvimento em Android" to Formacao(
            "Desenvolvimento em Android", listOf(
                conteudos["Lógica de Programação"],
                conteudos["Matemática Elementar"],
                conteudos["POO"],
                conteudos["Programação em Kotlin"],
                conteudos["Programação em Android"],
            ) as List<ConteudoEducacional>, mutableListOf()
        ),
    )

    val usuarios = mutableMapOf(
        Pair(
            "ciclano@gmail.com", Usuario(
                "ciclano@gmail.com",
                "Ciclano",
                "12345",
            )
        ),
        Pair(
            "fulano@gmail.com", Usuario(
                "fulano@gmail.com",
                "Fulano",
                "23456",
            )
        ),
        Pair(
            "beltrano@gmail.com", Usuario(
                "beltrano@gmail.com",
                "Beltrano",
                "34567",
            )
        ),
    )

    usuarios["ciclano@gmail.com"]?.let { formacoes["Administrador de Sistemas"]?.matricular(it) }
    usuarios["fulano@gmail.com"]?.let { formacoes["Desenvolvimento em Android"]?.matricular(it) }
    usuarios["beltrano@gmail.com"]?.let { formacoes["Desenvolvimento em Android"]?.matricular(it) }

    print(formacoes)

}


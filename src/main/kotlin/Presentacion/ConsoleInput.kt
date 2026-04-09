package org.iesra.Presentacion

class ConsoleInput {

    companion object {

        fun solicitarFechaInicial(): String {
            val regex = """^\\d{4}-(0[1-9]|1[0-2])-(0[1-9]|[12]\\d|3[01])\\s([01]\\d|2[0-3]):[0-5]\\d:[0-5]\\d$""".toRegex()

            var fechaInicial: String? = null

            do {
                println("Introduce la fecha inicial en formato 2025-01-15 10:30:15 ")
                val entrada = readLine()
                if (entrada != null && entrada.matches(regex)){
                    fechaInicial = entrada
                }
            } while (fechaInicial == null)
            return fechaInicial
        }

        fun solicitarFechaTerminal(fechaInicial: String): String{
            val regex = """^\\d{4}-(0[1-9]|1[0-2])-(0[1-9]|[12]\\d|3[01])\\s([01]\\d|2[0-3]):[0-5]\\d:[0-5]\\d$""".toRegex()

            var fechaTerminal: String? = null

            do {
                println("Introduce la fecha terminal en formato 2025-01-15 10:30:15 ")
                val entrada = readLine()
                if (entrada != null && entrada.matches(regex)){
                    if (fechaInicial < entrada){
                        fechaTerminal = entrada
                    } else { println("La fecha terminal debe ser mayor a la fecha inicial") }
                }
            } while (fechaTerminal == null)
            return fechaTerminal
        }

        fun mostrarMenú(): String {

            val entradasPosibles = listOf<String>("1", "2", "3", "4")
            var decision: String? = null

            do {
                println("===== Procesador de Logs =====\n")
                println("Elija una opción: \n")
                println("1. Contar número de Logs")
                println("2. Filtrar por fecha")
                println("3. Generar análisis")
                println("4. Salir")
                val entrada = readLine()
                if (entrada in entradasPosibles){
                    decision = entrada
                }
            } while (decision == null)
            return decision
        }

        fun mostrarAnalisis(lineasProcesadas: Int, info: Int, error: Int, warning: Int, primeraEntrada: String, ultimaEntrada: String) {
            println("")
        }
    }

}
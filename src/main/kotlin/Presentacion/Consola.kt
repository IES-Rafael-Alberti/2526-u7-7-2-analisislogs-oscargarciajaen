package org.iesra.Presentacion

object Consola {


    fun mostrarAnalisis(lineasProcesadas: Int, info: Int, error: Int, warning: Int, primeraEntrada: String, ultimaEntrada: String) {
        println("")
    }

    fun mostrarAyuda() {
        println("===== Ayuda =====\n")
        println("-i, --input <fichero>        Fichero de entrada (obligatorio)")
        println("-f, --from <fechaHora>       Formato: \"YYYY-MM-DD HH:MM:SS\"")
        println("-t, --to <fechaHora>         Formato: \"YYYY-MM-DD HH:MM:SS\"")
        println("-l, --level <niveles>        Filtra niveles: INFO, WARNING, ERROR, Formato: INFO,WARNING,ERROR")
        println("-s, --stats                  Muestra solo estadísticas")
        println("-r, --report                 Genera informe completo")
        println("-o, --output <fichero>       Guarda la salida en un fichero")
        println("-p, --stdout                 Muestra la salida por consola")
        println("--ignore-invalid         Ignora líneas inválidas y continúa")
        println("-h, --help                   Muestra esta ayuda")
    }
}
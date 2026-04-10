package org.iesra.Presentacion

import org.iesra.Dominio.ProcesadorDeLogs

class Consola {

    val procesadorLogs = ProcesadorDeLogs()


    fun mostrarAnalisis() {
        println("INFORME DE LOGS")
        println("===============\n")
        println("RangoAplicado -> " + procesadorLogs.informeLog["primerLog"] + "-" + procesadorLogs.informeLog["ultimoLog"])
        println("Niveles incluidos -> " + procesadorLogs.informeLog["nivelesIncluidos"])
        println("Lineas procesadas -> " + procesadorLogs.informeLog["lineasProcesadas"])
        println("INFO -> " + procesadorLogs.informeLog["INFO"])
        println("WARNING -> " + procesadorLogs.informeLog["WARNING"])
        println("ERROR -> " + procesadorLogs.informeLog["ERROR"])

    }

    fun mostrarStats() {
        println("INFORME DE STATS")
        println("===============\n")
        println("Lineas procesadas -> " + procesadorLogs.informeLog["lineasProcesadas"])
        println("INFO -> " + procesadorLogs.informeLog["INFO"])
        println("WARNING -> " + procesadorLogs.informeLog["WARNING"])
        println("ERROR -> " + procesadorLogs.informeLog["ERROR"])
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
        println("-h, --help                   Muestra esta ayuda")
    }

    fun mostrarLogsFiltradosPorNivel(logsFiltradosPorNivel: MutableList<String>) {
        logsFiltradosPorNivel.forEach {
            println(it)
        }
    }

    fun mostrarLogsFiltradosPorFecha(logsFiltradosPorFecha: MutableList<String>) {
        logsFiltradosPorFecha.forEach {
            println(it)
        }

    }
}

package org.iesra.Dominio

import java.io.File
import java.io.FileNotFoundException

class FileManager() {

    companion object {
        val logs = mutableListOf<String>()

        fun ObtenerLogs(): Boolean {
            var logsVolcados: Boolean? = null
            try {
                val fichero = File("src/main/kotlin/Datos/logs.txt").readLines()
                fichero.forEach { line ->  logs.add(line)}
                logsVolcados =  true
            } catch (e: FileNotFoundException) {
                println("Error: El archivo no se encontró.")
                logsVolcados = false

            }
            return logsVolcados
        }
    }
}
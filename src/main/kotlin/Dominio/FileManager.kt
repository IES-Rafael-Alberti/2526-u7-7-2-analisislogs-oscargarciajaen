package org.iesra.Dominio

import java.io.File
import java.io.FileNotFoundException

object FileManager {

        val logs = mutableListOf<String>()

        fun ObtenerLogs(ruta: String): Boolean {
            var logsVolcados: Boolean? = null
            try {
                val logsLeidos = File(ruta).readLines()
                logsLeidos.forEach { line ->  logs.add(line)}
                logsVolcados =  true
            } catch (e: FileNotFoundException) {
                println("Error: El archivo no se encontró.")
                logsVolcados = false

            }
            return logsVolcados
        }
}
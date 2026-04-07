package org.iesra.Dominio

import kotlin.math.log

class ProcesadorDeLogs() {

    val logs = FileManager.logs

    fun contadorEntradas(): Int {
        var entradas = 0
        for (i in logs){
            entradas += 1
        }
        return entradas
    }

    fun filtrarPorFecha(desde: String, hasta: String): MutableList<String>{

        val logsFiltrados = mutableListOf<String>()

        for (log in logs){
            val horaLog = log.substringAfter("[").substringBefore("]")
            if (horaLog >= desde && horaLog <= hasta ){
                logsFiltrados.add(log)
            }
        }
        return logsFiltrados
    }

    fun generarAnalisis(){
        // Todo generardor analisis
    }

}
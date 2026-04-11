package org.iesra.Dominio

import java.io.File
import java.time.LocalDateTime

class ProcesadorDeLogs() {

    val logs = FileManager.logs

    val informeLog = mutableMapOf<String, String>()

    fun contadorEntradas(): Int {
        var entradas = 0
        for (i in logs){
            entradas += 1
        }
        return entradas
    }

    fun filtrarPorFecha(desde: String?, hasta: String?): MutableList<String>{
        val logsFiltrados: MutableList<String> = mutableListOf()
        if (desde != null && hasta != null && desde < hasta){
            for (log in logs){
                val logDividido = log.split("]")
                val fechaLog = logDividido[0].replace("[", "")
                if (desde <= fechaLog && fechaLog <= hasta){
                    logsFiltrados.add(log)
                }
            }
        } else if (desde == null && hasta != null){
            for (log in logs){
                val logDividido = log.split("]")
                val fechaLog = logDividido[0].replace("[", "")
                if (fechaLog <= hasta){
                    logsFiltrados.add(log)
                }
            }
        } else if (desde != null && hasta == null){
            for (log in logs){
                val logDividido = log.split("]")
                val fechaLog = logDividido[0].replace("[", "")
                if (desde <= fechaLog){
                    logsFiltrados.add(log)
                }
            }
        }
        return logsFiltrados
    }

    fun contarInfo(): Int{
        var contadorInfo = 0
        for (log in logs){
            if (log.contains("INFO")){
                contadorInfo++
            }
        }
        return contadorInfo
    }

    fun contarError(): Int{
        var contadorError = 0
        for (log in logs){
            if (log.contains("ERROR")){
                contadorError++
            }
        }
        return contadorError
    }

    fun contarWarning(): Int{
        var contadorWarning = 0
        for (log in logs){
            if (log.contains("WARNING")){
                contadorWarning++
            }
        }
        return contadorWarning
    }

    fun obtenerPrimeraEntrada(): String {
        val primeraEntrada = logs.first().substringAfter("[").substringBefore("]")
        return primeraEntrada
    }

    fun obtenerUltimaEntrada(): String {
        val ulimaEntrada = logs.last().substringAfter("[").substringBefore("]")
        return ulimaEntrada
    }

    fun filtrarPorNivel(listaNiveles: MutableList<String>): MutableList<String> {
        val logsFiltradosPorNivel = mutableListOf<String>()

        for (log in logs) {
            if (listaNiveles.any { nivel -> log.contains(nivel) }) {
                logsFiltradosPorNivel.add(log)
            }
        }
        return logsFiltradosPorNivel
    }

    fun generarInformeCompleto():MutableMap<String, String>{
        informeLog["primerLog"] = obtenerPrimeraEntrada()
        informeLog["ultimoLog"] = obtenerUltimaEntrada()
        informeLog["nivelesIncluidos"] = "INFO,WARNING,ERROR"
        informeLog["lineasProcesadas"] = contadorEntradas().toString()
        informeLog["INFO"] = contarInfo().toString()
        informeLog["WARNING"] = contarWarning().toString()
        informeLog["ERROR"] = contarError().toString()
        return informeLog
    }

    fun generarStats():MutableMap<String, String>{
        informeLog["lineasProcesadas"] = contadorEntradas().toString()
        informeLog["INFO"] = contarInfo().toString()
        informeLog["WARNING"] = contarWarning().toString()
        informeLog["ERROR"] = contarError().toString()
        return informeLog
    }






}
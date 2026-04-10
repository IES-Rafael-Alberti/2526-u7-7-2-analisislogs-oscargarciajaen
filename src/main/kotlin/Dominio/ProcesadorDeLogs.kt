package org.iesra.Dominio

import org.iesra.Presentacion.Consola
import java.time.LocalDateTime

class ProcesadorDeLogs() {

    val consola = Consola()

    val logs = FileManager.logs

    fun contadorEntradas(): Int {
        var entradas = 0
        for (i in logs){
            entradas += 1
        }
        return entradas
    }

    fun filtrarPorFecha(desde: LocalDateTime?, hasta: LocalDateTime?): MutableList<String>{
        val logsFiltrados: MutableList<String> = mutableListOf()
        if (desde != null && hasta != null && desde.isBefore(hasta)){
            for (log in logs){
                val logDividido = log.split("]")
                val fechaLog = logDividido[0].replace("[", "")
                val fechaYHora = LocalDateTime.parse(fechaLog)
                if (desde <= fechaYHora && fechaYHora <= hasta){
                    logsFiltrados.add(log)
                }
            }
        } else if (desde == null && hasta != null){
            for (log in logs){
                val logDividido = log.split("]")
                val fechaLog = logDividido[0].replace("[", "")
                val fechaYHora = LocalDateTime.parse(fechaLog)
                if (fechaYHora <= hasta){
                    logsFiltrados.add(log)
                }
            }
        } else if (desde != null && hasta == null){
            for (log in logs){
                val logDividido = log.split("]")
                val fechaLog = logDividido[0].replace("[", "")
                val fechaYHora = LocalDateTime.parse(fechaLog)
                if (desde <= fechaYHora){
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

    fun generarAnalisis(){
        val entradas = contadorEntradas()
        val info = contarInfo()
        val errores = contarError()
        val warnings = contarWarning()
        val primeraEntrada = obtenerPrimeraEntrada()
        val ultimaEntrdada = obtenerUltimaEntrada()
        consola.mostrarAnalisis(entradas, info, errores, warnings, primeraEntrada, ultimaEntrdada)
    }

    fun filtrarPorNivel(listaNiveles: MutableList<String>):MutableList<String>{
        val logsFiltradosPorNivel = mutableListOf<String>()
        for (i in logs){
            val log = i.split(" ")
            if (log[2] in listaNiveles){
                logsFiltradosPorNivel.add(i)
            }
        }
        return logsFiltradosPorNivel
    }



}
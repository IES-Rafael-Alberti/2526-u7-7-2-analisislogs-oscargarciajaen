package org.iesra.Dominio
import org.iesra.Datos.ConfigEjecucion
import org.iesra.Presentacion.Consola
import java.time.LocalDateTime
import kotlin.*

class InputParser {

    val consola: Consola = Consola()

    fun procesarEntrada(args: Array<String>):ConfigEjecucion {
        var i = 0

        var conf: ConfigEjecucion = ConfigEjecucion()

        while (i < args.size){
            when(args[i]){
                "-i" , "--input"  -> {
                    validarImput(args[i +1])
                    i++
                }
                "-f", "--from" -> {
                    conf.dateFrom = validarFrom(args[i+1])
                    i++
                }
                "-t", "--to" -> {
                    conf.dateTo =  validarTo(args[i+1])
                    i++
                }
                "-l", "--level" -> {
                    conf.levels = validarNiveles(args[i+1])
                    i++
                }
                "-s", "--stats" -> {
                    conf.stats = true
                }
                "-r", "--report" -> {
                    conf.report = true
                }
                "-o", "--output" -> {
                    if (i +1 < args.size) {
                        conf.output = args[i+1]
                        i++
                    }
                }
                "-p", "--stdout" -> {
                    conf.mostrarConsola = true
                }
                "-h", "--help" -> {
                    consola.mostrarAyuda()
                }
            }
            i++
        }

        return conf

    }


    fun validarImput(ruta: String): Boolean {
        FileManager.ObtenerLogs(ruta)
        return true
    }

    fun validarFrom(fecha: String): String{
        val regex = """^\d{4}-(0[1-9]|1[0-2])-(0[1-9]|[12]\d|3[01])\s([01]\d|2[0-3]):[0-5]\d:[0-5]\d$""".toRegex()
        if (fecha.matches(regex)){
            return fecha
        } else {
            throw IllegalArgumentException("-f, --from <fechaHora>         Formato: \"YYYY-MM-DD HH:MM:SS")
        }
    }

    fun validarTo(fecha: String): String{
        val regex = """^\d{4}-(0[1-9]|1[0-2])-(0[1-9]|[12]\d|3[01])\s([01]\d|2[0-3]):[0-5]\d:[0-5]\d$""".toRegex()
        if (fecha.matches(regex)){
            return fecha
        } else {
            throw IllegalArgumentException("-t, --to <fechaHora>         Formato: \"YYYY-MM-DD HH:MM:SS")
        }
    }

    fun validarNiveles(niveles: String):MutableList<String>{
        val nivelesList = mutableListOf<String>()
        if (niveles.contains(",")){
            val nivelesEncontrados = niveles.split(",")
            for (nivel in nivelesEncontrados){
                if (nivel in listOf("INFO", "WARNING", "ERROR")){
                    nivelesList.add(nivel)
                }
            }
        } else {
            if (niveles in listOf("INFO", "WARNING", "ERROR")) {
                nivelesList.add(niveles)
            } else {
                throw IllegalArgumentException("niveles invalidos")
            }
        }
        return nivelesList
    }
}
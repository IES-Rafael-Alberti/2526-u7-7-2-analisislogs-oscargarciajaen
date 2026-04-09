package org.iesra.Dominio
import kotlin.*


class ProcesadorDeImputs {

    companion object {

        fun procesarEntrada(args: Array<String>){
            when(args[0]){
                "-i" , "--input"  -> validarImput(args)
                "-f", "--from" -> validarFechas(args)
            }
        }

        fun validarImput(args: Array<String>): Boolean{
            var valido = false
            if(args.size == 2){
                valido = true
                FileManager.ObtenerLogs(args[1])
            }
            return valido
        }

        fun validarFechas(args: Array<String>): Boolean{
            var valido = false
            val regex = """^\\d{4}-(0[1-9]|1[0-2])-(0[1-9]|[12]\\d|3[01])\\s([01]\\d|2[0-3]):[0-5]\\d:[0-5]\\d$""".toRegex()
            if (args.size == 6){
                if(args[4] == "-i" || args[4] == "--input" && args[2] == "-t" || args[2] == "--to"){
                    if (FileManager.ObtenerLogs(args[5])){
                        if(args[1].matches(regex) && args[3].matches(regex) && args[1] < args[3]){
                            
                            valido = true
                        }
                    }
                }
            }
            return valido
        }
    }


}
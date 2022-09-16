import java.io.File
import java.util.Scanner

fun main(args: Array<String>) {
    val sc = Scanner(System.`in`)
    var file = File.listRoots()[0]
    llistaDirectori(file)
    println("Introduce un numero")
    var opcion = sc.nextInt()
    while (opcion != -1) {
        if (opcion >= 0 && opcion <= file.listFiles().size) {
            if (file.listFiles().sorted()[opcion - 1].canRead()) {
                if (file.listFiles().sorted()[opcion - 1].isFile) {
                    println("No puedes acceder a un fichero")
                } else {
                    if (opcion == 0) {
                        if (file != File.listRoots()[0]) {
                            file = file.parentFile
                            llistaDirectori(file)
                        } else {
                            println("No puedes ir mas atras")
                        }
                    }
                    if (opcion > 0 && opcion <= file.listFiles().size) {
                        file = file.listFiles().sorted()[opcion - 1]
                        llistaDirectori(file)
                    }
                }
            } else {
                println("No tienes permiso de lectura")
            }
        } else {
            println("Introduce un numero correcto")
        }
        println("Introduce un numero")
        opcion = sc.nextInt()
    }
}

fun llistaDirectori(f: File) {
    var indice = 1;
    val s = "Llista de fitxers i directoris del directori " + f.getCanonicalPath()
    println(s)
    println("-".repeat(s.length))
    println("0. Directorio padre")
    for (e in f.listFiles().sorted()) {
        if (e.isFile())
            println("" + indice + ". " + e.getName() + "\t " + e.length())
        if (e.isDirectory())
            println("" + indice + ". " + e.getName() + "\t <Directori>")
        indice++;
    }
}
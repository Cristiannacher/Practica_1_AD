package exemples

import java.io.File
import java.text.SimpleDateFormat
import java.util.*

fun main(args: Array<String>) {

    val sc = Scanner(System.`in`)
    var f = File.listRoots()[0]
    llistadirectori_amb_permisos(f)

    println("Tria un directori per anar, 0 per anar al pare i -1 per a acabar")
    var num = sc.nextInt()

    while (num != -1) {
        if (num == 0) {
            if (f != File.listRoots()[0]) {
                f = f.parentFile
                llistadirectori_amb_permisos(f)
            } else println("ya estas en la raiz")
        } else if (num <= f.listFiles().size && num > 0) {
            if (f.listFiles().sorted()[num - 1] != null) {
                if (f.listFiles().sorted()[num - 1].canRead()) {
                    if (f.listFiles().sorted()[num - 1].isDirectory) {
                        f = f.listFiles().sorted()[num - 1]
                        llistadirectori_amb_permisos(f)
                    } else println("No és un directori")
                } else println("No tienes acceso")
            } else println("El directori es null")
        } else println("Mete un numero dentro del rango")
        println("Tria un directori per anar, 0 per anar al pare i -1 per a acabar")
        num = sc.nextInt()
    }

}

fun llistadirectori_amb_permisos(f: File) {

    val sdf = SimpleDateFormat("dd/M/yyyy hh:mm:ss")

    val s = "Llista de fitxers i directoris del directori " + f.getCanonicalPath()
    println(s)
    println("-".repeat(s.length))
    var i = 1
    println("" + 0 + ". Directori pare - " + f.name)
    for (e in f.listFiles().sorted()) {
        val currentDate = sdf.format(e.lastModified())
        if (e.isFile())
            println("" + i + ".- " + isdirectory(e) + canread(e) + canwrite(e) + canexecut(e) + +e.length() + "  " + currentDate + "  " + e.getName())
        if (e.isDirectory())
            println("" + i + ".- " + isdirectory(e) + canread(e) + canwrite(e) + canexecut(e) + e.length() + "  " + currentDate + "  " + e.getName())
        i++
    }
}

fun isdirectory(f: File): String {
    if (f.isDirectory)
        return "d"
    else
        return "-"
}

fun canread(f: File): String {
    if (f.canRead())
        return "r"
    else return "-"
}

fun canwrite(f: File): String {
    if (f.canWrite())
        return "w"
    else return "-"
}

fun canexecut(f: File): String {
    if (f.canExecute())
        return "x   "
    else return "-   "
}


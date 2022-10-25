package exemples

import java.io.File
import java.util.*

fun main(args: Array<String>) {
    val sc = Scanner(System.`in`)
    var f = File.listRoots()[0]
    llistaDirectori(f)

    println("Tria un directori per anar, 0 per anar al pare i -1 per a acabar")
    var num = sc.nextInt()

    while (num != -1) {
        if (num == 0) {
            if (f != File.listRoots()[0]) {
                f = f.parentFile
                llistaDirectori(f)
            } else println("ya estas en la raiz")
        } else if (num <= f.listFiles().size && num > 0) {
            if (f.listFiles().sorted()[num - 1] != null) {
                if (f.listFiles().sorted()[num - 1].canRead()) {
                    if (f.listFiles().sorted()[num - 1].isDirectory) {
                        f = f.listFiles().sorted()[num - 1]
                        llistaDirectori(f)
                    } else println("No és un directori")
                } else println("No tienes acceso")
            } else println("El directori es null")
        } else println("Mete un numero dentro del rango")
        println("Tria un directori per anar, 0 per anar al pare i -1 per a acabar")
        num = sc.nextInt()
    }
}


fun llistaDirectori(f: File) {
    val s = "Llista de fitxers i directoris del directori " + f.getCanonicalPath()
    println(s)
    println("-".repeat(s.length))
    var i = 1
    println("" + 0 + ". Directori pare - " + f.name)
    for (e in f.listFiles().sorted()) {
        if (e.isFile())
            println("" + i + ". " + e.getName() + "\t tamany = " + e.length())
        if (e.isDirectory())
            println("" + i + ". " + e.getName() + "\t <Directori>")
        i++
    }

}

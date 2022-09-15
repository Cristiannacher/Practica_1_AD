package exemples

import java.io.BufferedReader
import java.io.File
import java.io.InputStreamReader
import java.util.*

fun main(args: Array<String>) {
    val sc = Scanner(System.`in`)
    var f = File("/")
    llistaDirectori(f)

    var n: Int? = null

    while (n != -1) {
        println("Tria un directori per anar, 0 per anar al pare i -1 per a acabar")
        n = sc.nextInt()
        if (n == -1) {
            break
        } else if (n == 0) {
            f = f.parentFile
            llistaDirectori(f)
        } else if (n < f.listFiles().size && n > 0) {
            f = f.listFiles().sorted()[n - 1]
            if (f.exists()) {
                if (f.isDirectory()) {
                    llistaDirectori(f)
                } else
                    println("No és un directori")
            } else
                println("No existeix el directori")
        } else println("Mete otra opcion")
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

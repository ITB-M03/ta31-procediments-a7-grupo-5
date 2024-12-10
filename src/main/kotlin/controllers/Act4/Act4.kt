package controllers.Act4

import java.util.*

fun main(){
    val scanner = abrirScanner()
    val titol = pedimosElTitulo(scanner)
    val separacion = titulo(titol)
    centrar(separacion, titol)
    cerrarScanner(scanner)
}

/**
 * Abre una Scanner para leer la entrada del usuario.
 * @return un objeto Scanner
 */
fun abrirScanner( ): Scanner{
    return Scanner(System.`in`)
}

/**
 * Cierra Scanner
 * @param scanner el scanner que se debe cerrar
 */
fun cerrarScanner(scanner: Scanner){
    scanner.close()
}

/**
 * Función para pedi el titulo
 * @param scanner el scanner para leer la entrada del usuario
 * @return el titulo que el usuario habra introducido
 */
fun pedimosElTitulo(scanner:Scanner): String{
    val nom = scanner.nextLine()
    return nom
}

/**
 * Función para determinar los espacios laterales
 * @param nom es el titulo que el usuario ha escrito anteriormente
 * @return se devuelve el calculo de los espacios laterales que tiene el titulo
 */
fun titulo(nom:String): Int{
    val amplitud = 80
    val espaciosLaterales = (amplitud - nom.length)/2
    return espaciosLaterales
}

/**
 * Función para imprimir el titulo centrado
 * @param separacion la separacion que hay en los laterales del titulo
 */
fun centrar(separacion:Int, titol:String){
    println(" ".repeat(separacion) + titol)
}

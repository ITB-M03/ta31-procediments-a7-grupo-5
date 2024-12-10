package controllers.Act2

import java.util.*

fun main(){
    val scanner = abrirScanner()
    val num1 = pedimosNumeroEntero(scanner)

    cerrarScanner(scanner)
}

fun abrirScanner( ): Scanner{
    return Scanner(System.`in`)
}

fun cerrarScanner(scanner: Scanner){
    scanner.close()
}

fun pedimosNumeroEntero(scanner:Scanner): Int{
    val num = scanner.nextInt()
    return num
}

fun canviEnterARoman(){

}
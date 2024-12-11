package controllers.Act5

import java.util.*

data class Pila(
    var elementos:Array<Int>,
    var pilaVacia:Boolean
)

fun main(){
    val scanner = abrirScanner()
    val opcion = menu("Indica que opcion quieres escoger: \n 1)Añadir un número \n 2)Quitar un número \n 3)Mostrar el contenido de la pila \n 4)Salir",scanner)
    val pila = Pila(elementos = arrayOf(), pilaVacia = true)
    inicializarPila(pila)
    escogerOpcion(pila, opcion, scanner)
    cerrarScanner(scanner)

}
/**
 * Abre un nuevo objeto Scanner para leer la entrada estándar.
 *
 * @return Un nuevo objeto Scanner.
 */
fun abrirScanner(): Scanner {
    return Scanner(System.`in`)
}

/**
 * Cierra el objeto Scanner proporcionado.
 *
 * @param scanner El objeto Scanner a cerrar.
 */

fun cerrarScanner(scanner: Scanner) {
    scanner.close()
}

fun menu(msg:String, scanner: Scanner): Int{
    println(msg)
    val opcio = scanner.nextInt()
    return opcio
}

fun inicializarPila(pila: Pila){
    pila.elementos = arrayOf<Int>(10)
    pila.pilaVacia = true
}

fun escogerOpcion(pila: Pila, opcion:Int, scanner: Scanner){
    while(opcion > 0 && opcion < 4){
        val pilaVacia =  //CAMBIAR IMPORTANTE
        if(opcion == 1){
            opcion1(pila, scanner)
        } else if(opcion == 2){

        } else {

        }
    }
}

fun opcion1(pila:Pila, scanner: Scanner) {
    if(pila.pilaVacia == false) {
        println("En que posicon quieres introducir el número: ")
        val num1 = scanner.nextInt()
        println("Que número quieres introducir: ")
        val posicion = scanner.nextInt()
        for(i in 0 until pila.elementos.size){
            if(pila.elementos[i] == pila.elementos[posicion])
            pila.elementos[posicion] = num1
        }


    }
}

fun opcion2(){

}
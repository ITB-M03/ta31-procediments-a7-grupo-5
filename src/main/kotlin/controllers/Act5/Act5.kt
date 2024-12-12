package controllers.Act5

import java.util.*

/**
 * Clase que representa una pila con capacidad máxima de 10 elementos.
 *
 * @property elementos Array de enteros que almacena los elementos de la pila.
 * @property pilaVacia Booleano que indica si la pila está vacía.
 * @property indice Índice que apunta al siguiente lugar disponible en la pila.
 */

data class Pila(
    var elementos:Array<Int> = Array(10) {-1},
    var pilaVacia:Boolean = true,
    var indice:Int = 0
)

fun main(){
    val scanner = abrirScanner()
    menuFinal(scanner, Pila())
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

/**
 * Muestra el menú principal y gestiona las opciones seleccionadas por el usuario.
 *
 * @param scanner Para leer la entrada del usuario.
 * @param pila Para realizar las operaciones.
 */

fun menuFinal(scanner: Scanner, pila: Pila) {
    var opcion: Int
    do {
        println(
            "Indica que opción quieres escoger: \n" +
                    "1) Añadir un número \n" +
                    "2) Quitar un número \n" +
                    "3) Mostrar el contenido de la pila \n" +
                    "4) Salir"
        )
        opcion = scanner.nextInt()
        when (opcion) {
            1 -> opcionPush(pila, scanner)
            2 -> opcionPop(pila)
            3 -> opcionMostrar(pila)
            4 -> println("Adiós!!")
            else -> println("Opción inválida")
        }
    } while (opcion != 4)
}

/**
 * Añade un número a la pila.
 *
 * @param pila Donde se añadirá el número.
 * @param scanner Para leer la entrada del usuario.
 */

fun opcionPush(pila: Pila, scanner: Scanner) {
    if (pila.indice < 10) {
        println("Que número quieres introducir: ")
        val num1 = scanner.nextInt()
        pila.elementos[pila.indice] = num1
        pila.indice++
        pila.pilaVacia = false
        println("Número $num1 se ha añadido correctamente")
    } else {
        println("La pila esta llena, no se puede introducir más números")
    }
}

/**
 * Elimina un número de la pila.
 *
 * @param pila De donde se eliminará el número.
 */

fun opcionPop(pila: Pila){
    if(!pila.pilaVacia){
        pila.indice--
        val num2 = pila.elementos[pila.indice]
        pila.elementos[pila.indice] = -1
        if(pila.indice == 0) pila.pilaVacia = true
        println("Número $num2 se ha eliminado correctamente")
    } else {
        println("La pila esta vacia")
    }
}

/**
 * Muestra el contenido de la pila.
 *
 * @param pila Del cual contenido se mostrará.
 */

fun opcionMostrar(pila: Pila){
    if(pila.pilaVacia){
        println("La pila está vacía.")
    } else{
        println("La pila contiene:")
        for(i in pila.indice-1 downTo 0){
            println(pila.elementos[i])
        }
    }
}

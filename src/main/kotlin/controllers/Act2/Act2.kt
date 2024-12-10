package controllers.Act2

import java.util.*

fun main(){
    val scanner = abrirScanner()
    val nums = pedimosNumeroEntero("Introduce un numero entero para pasarlo a romano: ", scanner)
    val cambio = encontrarUnidades(nums)
    imprimirNumeroRoman(nums, cambio)
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
 * Pide al usuario que introduzca un número entero y lo devuelve.
 *
 * @param scanner El objeto Scanner para leer la entrada del usuario.
 * @return El número entero introducido por el usuario.
 */
fun pedimosNumeroEntero(msg:String, scanner: Scanner): Int {
    println(msg)
    val num = scanner.nextInt()
    return num
}

/**
 * Convierte un número entero en su representación en números romanos.
 *
 * @param nums El número entero a convertir.
 * @return La representación en números romanos del número proporcionado.
 */
fun encontrarUnidades(nums: Int):String {
    var numRoman = ""
    val unidades = arrayOf("", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX")
    val decenas = arrayOf("", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC")
    val centenas = arrayOf("", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM")
    val miles = arrayOf("", "M", "MM", "MMM")

    val millar = nums / 1000
    numRoman += miles[millar]

    val calculoCentenas = (nums / 100) % 10
    numRoman += centenas[calculoCentenas]

    val calculoDecenas = (nums / 10) % 10
    numRoman += decenas[calculoDecenas]

    val calculoUnidades = nums % 10
    numRoman += unidades[calculoUnidades]

    return numRoman
}
/**
 * Imprimimos el numero en romano
 *
 */
fun imprimirNumeroRoman(nums:Int, numRoman:String){
    println("El numero $nums en romano en $numRoman")
}
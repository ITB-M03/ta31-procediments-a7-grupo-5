package controllers.Act2

import java.util.*

fun main(){
    val scanner = abrirScanner()
    val nums = pedimosNumeroEntero(scanner)
    val cambio = cencontrarUnidades(nums)
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
fun pedimosNumeroEntero(scanner: Scanner): Int {
    val num = scanner.nextInt()
    return num
}

/**
 * Convierte un número entero en su representación en números romanos.
 *
 * @param nums El número entero a convertir.
 * @return La representación en números romanos del número proporcionado.
 */
fun cencontrarUnidades(nums: Int): String {
    var numRoman = ""
    val unidades = arrayOf("", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX")
    val decenas = arrayOf("", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC")
    val centenas = arrayOf("", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM")
    val miles = arrayOf("", "M", "MM", "MMM")

    val millar = nums / 1000
    print(miles[millar])

    val calculoCentenas = (nums / 100) % 10
    print(centenas[calculoCentenas])

    val calculoDecenas = (nums / 10) % 10
    print(decenas[calculoDecenas])

    val calculoUnidades = nums % 10
    print(unidades[calculoUnidades])

    println(numRoman)
    return numRoman
}

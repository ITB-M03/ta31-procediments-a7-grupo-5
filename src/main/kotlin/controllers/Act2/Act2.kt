package controllers.Act2

import java.util.*
import kotlin.math.sign

fun main(){
    val scanner = abrirScanner()
    val nums = pedimosNumeroEntero(scanner)
    val cambio = cencontrarUnidades(nums)
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

fun cencontrarUnidades(nums: Int):String{
    var numRoman = ""
    val unidades = arrayOf<String>("" ,"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX")
    val decenas = arrayOf<String>("", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC",)
    val centenas = arrayOf<String>("", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM",)
    val miles = arrayOf<String>("", "M", "MM", "MMM")

    val millar = nums/1000
    print(miles[millar])

    val calculoCentenas = (nums/100) % 10
    print(centenas[calculoCentenas])

    val calculoDecenas = (nums/10) % 10
    print(decenas[calculoDecenas])

    val calculoUniades = nums%10
    print(unidades[calculoUniades])

    println(numRoman)
    return numRoman
}

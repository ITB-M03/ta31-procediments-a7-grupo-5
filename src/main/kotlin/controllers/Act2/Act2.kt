package controllers.Act2

import java.util.*

fun main(){
    val scanner = abrirScanner()
    val nums = pedimosNumeroEntero(scanner)
    val cambio = canviEnterARoman(nums)
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

fun canviEnterARoman(nums: Int):String{
    var numRoman = ""
//    for(i in nums){
//        if(i == 1){
            numRoman += 'I'
//        }
    //}
    return numRoman
}
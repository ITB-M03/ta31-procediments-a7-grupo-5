package controllers.Act1

import controllers.MensajesError.letra_no_Entero
import java.util.*

fun main(){
    val scan = Scanner(System.`in`)
    print("Ingrese el precio al cual quiere aplicar el iva: ")
    var precio = scan.nextDouble()
    println()

    print("Ingresa la fecha de compra con el formato DD/MM/YY: ")
    val fecha = scan.nextLine().split("/").map { it.toInt() }
    println()
    val dia = fecha[0]
    val mes = fecha[1]
    val año = fecha[2]
    menuIvas()
    val elecion = scan.nextInt()

}
fun recogerEntero(msg: String, scan: Scanner) :Int {
    print(msg)
    var numero :Int
    try {
        numero =scan.nextInt()
    }
    catch (errorLetra : InputMismatchException){
        numero= Int.MAX_VALUE
        letra_no_Entero()
    }
    return numero
}
fun menuIvas(){
    println("1) General")
    println("2) Reducido")
    println("3) Super reducido")
    println("4) Excento")
    print("Seleccione cual es el iva que quiere aplicar: ")
}
fun calcularIVA(eleccion:Int, precio:Double){
    if (eleccion ==1){

    }
    else if (eleccion==2){

    }
    else if (eleccion==3){

    }
    else if (eleccion==4)
}
fun ivaGeneral(precio: Double, fecha:Int):Double{
    var iva:Double
    if (fecha<1992){
        iva=precio*0.12
    }
    else if (fecha in 1992 until 1995){
        iva=precio * 0.15
    }
    else if (fecha in 1995 until 2010){
        iva=precio*0.16
    }
    return iva
}
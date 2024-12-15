package controllers.MensajesError

fun letra_no_Entero() {
    val rojo = "\u001b[31m"
    val reset = "\u001b[0m" //devuelve el color por defecto
    println( rojo + "Error: Valor no valido ingresado: Asegure de ingresar un numero entero" + reset)
}
fun letra_no_Numero() {
    val rojo = "\u001b[31m"
    val reset = "\u001b[0m" //devuelve el color por defecto
    println( rojo + "Error: Valor no valido ingresado: Asegure de ingresar un numero" + reset)
}
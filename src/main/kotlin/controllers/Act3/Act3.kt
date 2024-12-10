package controllers.Act3
import controllers.MensajesError.letra_no_Entero
import java.util.*

fun main(){
    val scan = Scanner(System.`in`)
    var contraseña = recogerLinea("Por favor cree su contraseña: ", scan)
    var intentos=0
    var validacion = false
    while (intentos !=3 && !validacion){
        validacion =validarSuperusuari(contraseña,scan)
        mensajeValidacion(validacion)
        intentos++
    }
}
/**
 * @author Carlos Vargas
 * @param msg Mensaje que da el contexto sobre que debe ingresar el usuario en la linea.
 * @param scan Parametro que permite escanear el teclado del usuario en la funcion
 * @return Retorna la linea ingresada por el usuario
 */
fun recogerLinea(msg: String, scan: Scanner) :String {
    print(msg)
    var linea :String
    linea =scan.nextLine()
    return linea
}
/**
 * @author Carlos Vargas
 * @param contraseña Se usara para comparar con la linea que ingrese el usuario
 * @param scan Parametro que permite escanear el teclado del usuario en la funcion
 * @return Retorna un Boleano dependiendo de la comparacion con la contraseña entregada
 * y la linea ingresada por el usuario
 */
fun validarSuperusuari(contraseña:String, scan: Scanner) :Boolean{
    var correcta= false
    println()
    print("Por favor, ingrese su contraseña: ")
    var ingresado = scan.nextLine()
    if (contraseña == ingresado){correcta = true}
    return  correcta
}
/**
 * @author Carlos Vargas
 * @param correcta Parametro Boleano
 * @return Imprime un mensaje al usuario dependiendo del Bolleano ingresado
 */
fun mensajeValidacion(correcta:Boolean) {
    if (correcta) println("Contraseña correcta")
    else println("La contraseñas no coinciden")
}

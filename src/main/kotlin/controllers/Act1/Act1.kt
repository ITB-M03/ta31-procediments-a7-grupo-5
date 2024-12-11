package controllers.Act1
import controllers.MensajesError.letra_no_Entero
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*
import kotlin.math.roundToInt

fun main(){
    val scan = Scanner(System.`in`)
    var precio = recogerDouble("Ingrese el precio al cual quiere aplicar el iva: ", scan)
    scan.nextLine()
    print("Ingresa la fecha de compra con el formato YYYY/MM/DD: ")
    val datosfecha = scan.nextLine().split("/").map { it.toInt() }
    println()
    //datos de la fecha
    val año = datosfecha[0]
    val mes = datosfecha[1]
    val dia = datosfecha[2]
    val fecha = Calendar.getInstance().apply { set(año,mes,dia) }
    println()
    menuIvas() //mostrar las opciones disponible al usuario
    val elecion = scan.nextInt()
    val totalIva= calcularIVA(elecion, precio, fecha)
    println(totalIva)

}
/**
 * @author Carlos Vargas
 * @param msg Mensaje que ofrece en que contexto se usara el Double ingresado  por el usuario
 * @param scan Permite escanear el teclado del usuario
 * @return Rertona el numero DOuble ingresado por el usuario, si lo que ingresa no es valido se retornara un Double.MAX_VALUE
 */
fun recogerDouble(msg: String, scan: Scanner) :Double {
    print(msg)
    var numero :Double
    try {
        numero =scan.nextDouble()
    }
    catch (errorLetra : InputMismatchException){
        numero= Double.MAX_VALUE
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
/**
 * @author Carlos Vargas
 * @param eleccion Numero que indica la opción elegida por el usuario, dependiendo de su valor se udar una funcion diferente
 * @param precio Precio original que indico el usuario
 * @param fecha año del iva que se quiere aplicar
 * @return Rertona el valor del iva redondeado a dos decimales, el valor dependera del la eleccion del usuario.
 */
fun calcularIVA(eleccion:Int, precio:Double, fecha:Calendar) :Double{
    var iva =0.0
    if (eleccion ==1){
        iva = ivaGeneral(precio, fecha)
    }
    else if (eleccion==2){
        iva = ivaReducido(precio, fecha)
    }
    else if (eleccion==3){
        iva = ivaSuperReducido(precio, fecha)
    }
    else if (eleccion==4){
        iva = precio*0.0
    }
    else{
        println("Opcion no valida")
    }
    iva = (iva * 100.0).roundToInt() / 100.0
    return iva
}
/**
 * @author Carlos Vargas
 * @param precio Precio original que indico el usuario
 * @param fecha año del iva que se quiere aplicar
 * @return Rertona el valor del iva dependiedno de su año de aplicacion.
 */
fun ivaGeneral(precio: Double, fecha:Calendar):Double{
    val fecha1986 = Calendar.getInstance().apply { set(1986, 0, 1) }
    val fecha1995 = Calendar.getInstance().apply { set(1995, 0, 1) }
    val fecha2010 = Calendar.getInstance().apply { set(2010, 0, 1) }
    val fecha2012 = Calendar.getInstance().apply { set(2012, 6, 15) }
    var iva:Double
    iva=0.0
    if (fecha.before(fecha1986)){
        iva=precio*0.12
    }
    else if (fecha.after(fecha1986) && fecha.before(fecha1995)){
        iva=precio * 0.15
    }
    else if (fecha.after(fecha1995) && fecha.before(fecha2010)){
        iva=precio*0.16
    }
    else if (fecha.after(fecha2010) && fecha.before(fecha2012)){
        iva=precio*0.18
    }
    else{
        iva=precio*0.21
    }
    return iva
}
/**
 * @author Carlos Vargas
 * @param precio Precio original que indico el usuario
 * @param fecha año del iva que se quiere aplicar
 * @return Rertona el valor del iva dependiedno de su año de aplicacion.
 */
fun ivaReducido(precio: Double, fecha:Calendar):Double{
    var iva:Double
    val fecha1995 = Calendar.getInstance().apply { set(1995, 0, 1) }
    val fecha2010 = Calendar.getInstance().apply { set(2010, 0, 1) }
    val fecha2012 = Calendar.getInstance().apply { set(2012, 6, 15) }
    iva=0.0
    if (fecha.before(fecha1995)){
        iva=precio*0.6
    }
    else if (fecha.after(fecha1995) && fecha.before(fecha2010)){
        iva=precio * 0.7
    }
    else if (fecha.after(fecha2010) && fecha.before(fecha2012)){
        iva=precio*0.8
    }
    else{
        iva=precio*0.10
    }
    return iva
}
/**
 * @author Carlos Vargas
 * @param precio Precio original que indico el usuario
 * @param fecha año del iva que se quiere aplicar
 * @return Rertona el valor del iva dependiedno de su año de aplicacion.
 */
fun ivaSuperReducido(precio: Double, fecha:Calendar):Double{
    var iva:Double
    val fecha1993 = Calendar.getInstance().apply { set(1993, 0, 1) }
    val fecha1995 = Calendar.getInstance().apply { set(1995, 0, 1) }
    iva=0.0
    if (fecha.before(fecha1993)){
        iva=0.0
    }
    else if (fecha.after(fecha1993) && fecha.before(fecha1995)){
        iva=precio * 0.3
    }
    else{
        iva=precio*0.10
    }
    return iva
}
package controllers.Act1
import controllers.Act2.pedimosNumeroEntero
import controllers.MensajesError.letra_no_Entero
import controllers.MensajesError.letra_no_Numero
import java.util.*
import kotlin.math.roundToInt

fun main(){
    val scan = Scanner(System.`in`)
    var precio = recogerDouble("Ingrese el precio al cual quiere aplicar el iva: ", scan)
    scan.nextLine()
    val fechaCompra = recogerCalendar("Ingresa la fecha de compra con el formato YYYY/MM/DD: ",scan)
    val fechasIvas = fechasIva() //lista con las fechas de los diferente ivas
    println()
    menuIvas() //mostrar las opciones disponible al usuario
    val elecion = pedimosNumeroEntero("Seleccione cual es el iva que quiere aplicar: ", scan)
    val totalIva= calcularIVA(elecion, precio, fechaCompra, fechasIvas)
    val preciofinal = sumaDoubles(precio, totalIva)
    resultadosIvas(preciofinal, totalIva) //muestra el iva aplicado y e pecio con el iva
}

/**
 * @author Carlos vargas
 * @param msg Mensaje que informa al usuario que debe ingresar una fecha.
 * @param scan Parametro que permite escaner el teclado del usuario, sirve para recoger la fecha ingresada.
 * @return Retorn la fecha ingresada como un calendar,en este solo se declara el año,mes y dia.
 */
fun recogerCalendar(msg:String, scan: Scanner):Calendar{
    print(msg)
    val fecha :Calendar
    val datosFecha = scan.nextLine().split("/", " ").map { it.toInt() }
    val año = datosFecha[0]
    val mes = datosFecha[1]-1
    val dia = datosFecha[2]
    fecha = Calendar.getInstance().apply {
        set(año, mes, dia)
        set(Calendar.HOUR_OF_DAY, 0)
        clear(Calendar.MINUTE)
        clear(Calendar.SECOND)
        clear(Calendar.MILLISECOND)
    }
    return fecha
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
        letra_no_Numero()
    }
    return numero
}

/**
 * @author Carlos Varas
 * @return Muestra una lista con las diferentes opciones de calculo de iva al usuario
 */
fun menuIvas(){
    println("1) General")
    println("2) Reducido")
    println("3) Super reducido")
    println("4) Exento")
}
/**
 * @author Carlos Vargas
 * @param eleccion Numero que indica la opción elegida por el usuario, dependiendo de su valor se udar una funcion diferente.
 * @param precio Precio original que indico el usuario.
 * @param fecha Fecha del precio original.
 * @param fechaIva Lista con las diferentes fechas de alicacion de los diferentes Ivas.
 * @return Rertona el valor del iva redondeado a dos decimales, el valor dependera del la eleccion del usuario.
 */
fun calcularIVA(eleccion:Int, precio:Double, fecha:Calendar, fechaIva:MutableList<Calendar>) :Double{
    var iva =0.0
    if (eleccion ==1){ iva = ivaGeneral(precio, fecha, fechaIva) }
    else if (eleccion==2){ iva = ivaReducido(precio, fecha, fechaIva) }
    else if (eleccion==3){ iva = ivaSuperReducido(precio, fecha, fechaIva) }
    else if (eleccion==4){ iva = precio*0.0 }
    else{ println("Opcion no valida") }
    iva = (iva * 100.0).roundToInt() / 100.0
    return iva
}
/**
 * @author Carlos Vargas
 * @param precio Precio original que indico el usuario
 * @param fecha Fecha del precio original.
 * @param fechaIva Lista con las diferentes fechas de alicacion de los diferentes Ivas.
 * @return Rertona el valor del iva dependiedno de la fecha del precio.
 */
fun ivaGeneral(precio: Double, fecha:Calendar, fechaIva: MutableList<Calendar>):Double{
    var iva:Double
    iva=0.0
    if ( fecha < fechaIva[1]){ iva=precio*0.12 }
    else if (fecha >= fechaIva[1] && fecha < fechaIva[3]){ iva=precio * 0.15 }
    else if (fecha >= fechaIva[3] && fecha < fechaIva[4]){ iva=precio*0.16 }
    else if (fecha >= fechaIva[4] && fecha < fechaIva[5]){ iva=precio*0.18 }
    else{ iva=precio*0.21 }
    return iva
}
/**
 * @author Carlos Vargas
 * @param precio Precio original que indico el usuario
 * @param fecha Fecha del precio original.
 * @param fechaIva Lista con las diferentes fechas de alicacion de los diferentes Ivas.
 * @return Rertona el valor del iva dependiedno de la fecha del precio.
 */
fun ivaReducido(precio: Double, fecha:Calendar, fechaIva: MutableList<Calendar>):Double{
    var iva:Double
    iva=0.0
    if (fecha < fechaIva[3]){ iva=precio*0.06 }
    else if (fecha >= fechaIva[3] && fecha < fechaIva[4]){ iva=precio * 0.07 }
    else if (fecha >= fechaIva[4] && fecha < fechaIva[5]){ iva=precio*0.08 }
    else{ iva=precio*0.10 }
    return iva
}
/**
 * @author Carlos Vargas
 * @param precio Precio original que indico el usuario
 * @param fecha Fecha del precio original.
 * @param fechaIva Lista con las diferentes fechas de alicacion de los diferentes Ivas.
 * @return Rertona el valor del iva dependiedno de la fecha del precio.
 */
fun ivaSuperReducido(precio: Double, fecha:Calendar, fechaIva: MutableList<Calendar>):Double{
    var iva:Double
    iva=0.0
    if (fecha < fechaIva[2]){ iva=0.0 }
    else if (fecha >= fechaIva[2] && fecha < fechaIva[3]){ iva=precio * 0.03 }
    else{ iva=precio*0.10 }
    return iva
}
/**
 * @author Carlos vargas
 * @return Retorna una lista con todas las fechas de implementacion de los ivas
 */
fun fechasIva():MutableList<Calendar>{
    var fechas:MutableList<Calendar> = mutableListOf()
    fechas.add(Calendar.getInstance().apply { set(1986, 0, 1); set(Calendar.HOUR_OF_DAY, 0); clear(Calendar.MINUTE); clear(Calendar.SECOND); clear(Calendar.MILLISECOND) })
    fechas.add(Calendar.getInstance().apply { set(1992, 0, 1); set(Calendar.HOUR_OF_DAY, 0); clear(Calendar.MINUTE); clear(Calendar.SECOND); clear(Calendar.MILLISECOND) })
    fechas.add(Calendar.getInstance().apply { set(1993, 0, 1); set(Calendar.HOUR_OF_DAY, 0); clear(Calendar.MINUTE); clear(Calendar.SECOND); clear(Calendar.MILLISECOND) })
    fechas.add(Calendar.getInstance().apply { set(1995, 0, 1); set(Calendar.HOUR_OF_DAY, 0); clear(Calendar.MINUTE); clear(Calendar.SECOND); clear(Calendar.MILLISECOND) })
    fechas.add(Calendar.getInstance().apply { set(2010, 0, 1); set(Calendar.HOUR_OF_DAY, 0); clear(Calendar.MINUTE); clear(Calendar.SECOND); clear(Calendar.MILLISECOND) })
    fechas.add(Calendar.getInstance().apply { set(2012, 6, 15); set(Calendar.HOUR_OF_DAY, 0); clear(Calendar.MINUTE); clear(Calendar.SECOND); clear(Calendar.MILLISECOND) })
    return fechas
}

/**
 * @author Carlos Vargas
 * @param numA Numero decimal
 * @param numB Numero decimal
 * @return Retorna el resultado de la suma del numA y NumB
 */
fun sumaDoubles(numA: Double, numB:Double):Double{
    val total :Double
    total = numA+numB
    return total
}

/**
 * @author Carlos vargas
 * @param precioFinal Resultado de un precio al cual se le aplica un iva
 * @param iva iva aplicado al precio
 */
fun resultadosIvas(precioFinal: Double, iva:Double){
    println("La cantidad de iva es: $iva")
    println("El precio con el iva aplicado es: $precioFinal")
}
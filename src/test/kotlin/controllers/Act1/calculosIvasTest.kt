package controllers.Act1

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import java.util.*

class calculosIvasTest {

@Test
 fun checkIvaGeneral(){
 val precio = 500.0
 val fecha = Calendar.getInstance().apply { set(2024, 12, 15);set(Calendar.HOUR_OF_DAY, 0);clear(Calendar.MINUTE);clear(Calendar.SECOND);clear(Calendar.MILLISECOND) }
 val esperado = 105.0
 val fechasIva= fechasIva()
 val resultadoFinal = calcularIVA(1,precio,fecha,fechasIva)
 assertEquals(esperado,resultadoFinal)
 }
@Test
fun checkIvaReducido(){
 val precio = 500.0
 val fecha = Calendar.getInstance().apply { set(2024, 12, 15);set(Calendar.HOUR_OF_DAY, 0);clear(Calendar.MINUTE);clear(Calendar.SECOND);clear(Calendar.MILLISECOND) }
 val esperado = 50.0
 val fechasIva= fechasIva()
 val resultadoFinal = calcularIVA(2,precio,fecha,fechasIva)
 assertEquals(esperado,resultadoFinal)
 }
@Test
 fun checkIvaSuperReducido(){
  val precio = 500.0
  val fecha = Calendar.getInstance().apply { set(2024, 12, 15);set(Calendar.HOUR_OF_DAY, 0);clear(Calendar.MINUTE);clear(Calendar.SECOND);clear(Calendar.MILLISECOND) }
  val esperado = 20.0
  val fechasIva= fechasIva()
  val resultadoFinal = calcularIVA(3,precio,fecha,fechasIva)
  assertEquals(esperado,resultadoFinal)
 }
 @Test
 fun checkIvaExento(){
  val precio = 500.0
  val fecha = Calendar.getInstance().apply { set(2024, 12, 15);set(Calendar.HOUR_OF_DAY, 0);clear(Calendar.MINUTE);clear(Calendar.SECOND);clear(Calendar.MILLISECOND) }
  val esperado = 0.0
  val fechasIva= fechasIva()
  val resultadoFinal = calcularIVA(4,precio,fecha,fechasIva)
  assertEquals(esperado,resultadoFinal)
 }
 @Test
 fun checkinicioDeIva(){
  val precio = 500.0
  val fecha = Calendar.getInstance().apply { set(1995, 0, 1);set(Calendar.HOUR_OF_DAY, 0);clear(Calendar.MINUTE);clear(Calendar.SECOND);clear(Calendar.MILLISECOND) }
  val esperado = 80.0
  val fechasIva= fechasIva()
  val resultadoFinal = calcularIVA(4,precio,fecha,fechasIva)
  assertEquals(esperado,resultadoFinal)
 }
}

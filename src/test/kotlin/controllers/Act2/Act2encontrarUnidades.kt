package controllers.Act2

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
 class Act2encontrarUnidades {

@Test
 fun encontrarUnidadesTest() {
  val esperat = "XV"
 assertEquals(esperat, encontrarUnidades(15))
 }
@Test
  fun encontrarUnidadesTest2() { //no es poden fer tests perque
   val esperat = "MMDV"
   assertEquals(esperat, encontrarUnidades(2505))
  }
@Test
  fun encontrarUnidadesTest3() { //no es poden fer tests perque
   val esperat = "MMDCCXXIII"
   assertEquals(esperat, encontrarUnidades(2723))
  }
}
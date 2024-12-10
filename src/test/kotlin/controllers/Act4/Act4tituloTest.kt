package controllers.Act4

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
 class Act4tituloTest {

@Test
 fun tituloTest() {
  val esperado = 20
 val nom = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
 assertEquals(esperado, titulo(nom))
 }
@Test
  fun tituloTest2() {
   val esperado = 38
   val nom = "nome"
   assertEquals(esperado, titulo(nom))
  }
  @Test
  fun tituloTest3() {
   val esperado = 0
   val nom = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
   assertEquals(esperado, titulo(nom))
  }

}
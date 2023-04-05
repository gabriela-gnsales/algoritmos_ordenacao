/**
 * You can edit, run, and share this code.
 * play.kotlinlang.org
 */

fun main() {
    // função de nível superior -> não tá associada a uma classe (isso não pode no java)
    // método println -> + simples
    // não precisa colocar ; no final da instrução -> inserção do ; é automática
    println("Hello, world!!!")
    
  	// Tipos básicos
  	// kotlin não permite conversão interna/automática de diferentes tipos de dados
  	// não tem os tipos primitivos, já considera todos como objeto
  	// VAR: declarar uma variável mutável (que pode ser atribuída várias vezes)
  	// VAL: declarar variável final / imutável (que pode ser inicializada apenas uma vez)

  	// números
  	val a: Int = 10000
  	val d: Double = 100.00
	val f: Float = 100.00f
    val l: Long = 100000000000004
    val s: Short = 10
    val b: Byte = 1
    println(a); // não pode colocar pra printar + de 1 variável
    println(d);
    println(f);
    println(l);
    println(s);
    println(b);
    
	// caracteres
	val letra: Char // define uma variável
    letra = 'A' // atribui valor
    println(letra)
    println("A letra é $letra") // qnd tem + de 1 caracter tem que ser aspas duplas
    println("A letra é $letra $a")
    
	// strings
	var rawString: String = "eu sou uma string crua"
    val escapedString: String = "eu sou uma string escapada\n"
    println("Olá: " + escapedString)
    println("Olá: " + rawString)
    println("Olá: $rawString")
    
    // arrays
    val numeros: IntArray = intArrayOf(1, 2, 3, 4, 5)
    println("Exemplo de elemento de array: " + numeros[2]) // não dá pra usar o $ nesse caso
    
    // coleções
    val lista1: MutableList<Int> = mutableListOf(1, 2, 3) // lista mutável
    println("Lista mutável: " + lista1)
    lista1.add(4)
    println("Lista após adição: " + lista1)
    val lista2: List<Int> = listOf(10, 20, 30) // lista de apenas leitura -> é imutável, não possui métodos para alteração da lista, como add ou remove
    println("Lista de apenas leitura: " + lista2)
	// lista2.add(5) -> não compila
	
    val itens = listOf(11, 12, 13, 14) // parece que não precisa declarar o tipo
    println("Primeiro elemento: " + itens.first())
    println("Último elemento: " + itens.last())
    println("Núemros pares da lista: " + itens.filter {it % 2 == 0})
    
    val readWriteMap = hashMapOf("foo" to 1, "bar" to 2)
    println(readWriteMap["foo"])
    
    val strings = hashSetOf("a", 'b', 'b') // pode usar aspas simples ou duplas ou até mesmo as 2
    println("Meu conjunto de valores é: " + strings) // não vai retornar as repetidas, pq é um conjunto
    
    // intervalos
    for (j in 1..4)
    	println(j)
    val i: Int = 2
    if (i in 1..10) {
        println("O número é: " + i) // como é só 1 linha, não precisaria das {}
    }
    
}
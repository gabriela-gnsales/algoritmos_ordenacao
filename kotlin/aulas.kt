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

    // if-else
  	val a: Int = 5
  	val b: Int = 2
    var max: Int
    
    if (a > b) {
        max = a
    } else {
        max = b
    }
    println("1. O máximo de a e b é: " + max); 

    // como uma expressão -> parecido com operador ternário
    max = if (a>b) a else b
   	println("2. O máximo de a e b é: " + max);

    // when -> parecido com o switch, não precisa do comando break
    val x: Int = 5
	when (x) {
        1 -> print("x == 1")
        2 -> print("x == 2")
        3, 4 -> println("x é 3 ou 4") // outra forma
        else -> {
            print("x não é 1 ou 2")
        }
    }

    // for
    val itens = listOf(10, 20, 30, 40, 50)
    for (i in itens)
    	println("Valor = $i")

    // while
    var x: Int = 0
    while(x <= 10) { // tem que colocar as {} quando há + de 1 linha
        println(x)
        x++
    }

    // do-while
    var x: Int = 0
    do {
        x += 10 // x = x + 10
    	println(x)    
    } while (x <= 50) 

    // return, break e continue
    var x: Int = 10
   	println("O dobro de x é: " + dobro(x))  
    
}

fun dobro(x: Int): Int {
    return x*2
}

fun main() {
    
    meuRotulo@ for (x in 1..10) {
        if (x == 5) {
            println("Dentro do bloco IF o valor de x é: " + x)     
            break@meuRotulo
        } else {
            println("Dentro do bloco ELSE o valor de x é: " + x)     
            continue@meuRotulo     
        }
    
    }
}

class MinhaClasse {
    // propriedade (dado)
    private var nome: String = "Gran Cursos"
    
    // frunção membro
    fun meImprima() {
        print("Estudando kotlin no " + nome)
    }
}

fun main() {
    val obj = MinhaClasse() // cria um objeto de MinhaClasse, pode usar VAR tbm
	obj.meImprima()
}

// classe aninhada
class Externa {
    class Interna {
        fun foo() = "Olá, mundo!"
    }
}

fun main() {
    val demo = Externa.Interna().foo() // chamando o método da classe aninhada
    print(demo)
}

// classe interna (inner) -> consegue acessar uma variável da classe externa
class Externa {
    private val boasVindas: String = "Bem-vindo!"
    inner class Interna {
        fun foo() = boasVindas
    }
}

fun main() {
    val demo = Externa().Interna().foo() // chamando o método da classe interna
    print(demo)
}

// classe anônima interna 
fun main() {
    var programador: Humano = object: Humano { // cria uma instância da interface
        override fun pensar() { // implementa o método pensar
            print("Sou um exemplo de classe anônima interna")
        }
    }
    programador.pensar()
}

interface Humano {
    fun pensar()
}

// construtor é o método que é chamado para atribuir os valores iniciais
// 2 tipos: uma classe pode ter 1 construtor principal/primário e 1 ou + secundários
// em java o construtor inicializa as variáveis membro, já no kotlin o primário inicializa a classe e o secundário inclui algum tipo de lógica 

class Pessoa(val primeiroNome: String, var idade: Int) {
}

fun main() {
    val pessoa1 = Pessoa("Jhony", 35)
    println("Primeiro nome = ${pessoa1.primeiroNome}")
    println("Idade = ${pessoa1.idade} anos")
}

// no java o nome do construtor é o próprio nome da classe 
// no kotlin é 'constructor'
class Humano(val primeiroNome: String, var idade: Int) {
    val mensagem: String = "Olá"
    constructor(nome: String, idade: Int, mensagem: String):this(nome, idade){
    }
}

fun main() {
    val humano = Humano("Gabriela", 28)
    println("${humano.mensagem} ${humano.primeiroNome}, sua idade é ${humano.idade}.")
}

// herança
// classe base no kotlin é o any (no java é object)
// tudo no kotlin é final, as classes não podem ser estendidas por default
// para poder estender uma classe tem que colocar a palavra 'open' antes
import java.util.Arrays

open class ABC {
    fun falar() {
        println("Olá, mundo!")
    }	
    open fun gritar() {
        println("OIIIIIIIII")
    }
}

class BCD: ABC() {
}

class CDE: ABC() {
    // para sobrescrever um método (colocar o nome de 1 que já existe) 
    // tem que declarar que aquele é passível de ser sobrescrito -> 'open' e 'override'
	// sobrescrever -> alterar o comportamento de um método que foi herdado de uma classe
	override fun gritar() {
        println("AAAIIII")
    }
}

fun main() {
    var a = BCD()
    a.falar()
    a.gritar()
    var b = CDE()
    b.falar()
    b.gritar()
}


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

class BCD: ABC() { // não precisa das {} nesse caso, mas não dá erro se colocar
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

// interface
// as interfaces podem conter a implementação de métodos, bem como a declaração de métodos abstratos
// no java isso só foi possível a partir da versão 8
// da msm forma que no java, no kotlin não é possível instanciar diretamente uma interface, tem que criar uma classe que implementa aquela interface
// no kotlin o 2 pontos : significa tanto extends qnt implements
interface PessoaInterface {
    var idade: Int
    fun falar(): String
    fun saudar() {
        println("Olá, alunos")
    }
}

class PessoaImp: PessoaInterface {
    override var idade: Int = 25
    override fun falar() = "Bom dia!"
}

fun main() {
    val obj = PessoaImp()
    println("Minha idade é ${obj.idade}")
    print("Chamando saudar(): ")
    obj.saudar()
    print("Chamando falar(): ")
    println(obj.falar())
}

interface A {
    fun mensagemA() {
        println("Método da interface A")
    }
}

interface B {
    fun mensagemB() {
        println("Método da interface B")
    }
}

class ExemploMultiplasInterfaces: A, B

fun main() {
    val obj = ExemploMultiplasInterfaces()
    obj.mensagemA()
    obj.mensagemB()
}

/*
Modificadores de Visibilidade
- há quatro modificadores de visibilidade em Kotlin: Private, Protected, Internal, Public
- a visibilidade padrão é public
- no java, a visibilidade padrão é protected
- private significa visível apenas dentro desta classe (incluindo todos os seus membros);
- protected é o mesmo que private mas também é visível nas subclasses;
- internal significa que qualquer cliente dentro deste módulo que vê a classe declarante vê seus membros internal
- o modificador internal de visibilidade significa que o membro está visível dentro do mesmo módulo (um módulo é um conjunto de arquivos Kotlin compilados juntos)
- public significa que qualquer cliente que vê a classe declarante vê seus membros public
- no Kotlin, a classe externa não vê membros privados de suas classes internas
- se você substituir um membro protected e não especificar a visibilidade explicitamente, o membro que está substituindo também terá visibilidade protected
- por padrão, todos os construtores são public , o que efetivamente significa que eles estão visíveis em todos os lugares onde a classe está visível (isso significa que um construtor de uma classe internal só é visível dentro do mesmo módulo)
- variáveis, funções e classes locais não podem ter modificadores de visibilidade
*/

// pacotes
package	foo

fun baz() {
    println("baz")
}

class Bar

fun main() {
    var b: Bar
    baz()
}

// arquivo: exemplo.kt
package foo

private fun foo() { print("Olá") } // visível dentro de exemplo.kt

public var bar: Int = 5 // propriedade é visível em todo lugar
	private set // setter é visível apenas em exemplo.kt

internal val baz = 6 // visível dentro do mesmo módulo

open class Externa {
    private	val a = 1
    protected open val b = 2
    internal val c = 3
    val d = 4 // public por padrão
    
    protected class Aninhada {
        public val e: Int = 5
    }
}

class Subclasse: Externa() {
    // a não é visível
    // b, c, d são visíveis
    // Aninhada, e são visíveis
    override val b = 5 // b é protected
}

class NaoRelacionada(o: Externa) {
    // o.a, o.b não são visíveis
    // o.c, o.d são visíveis (mesmo módulo)
    // Externa.Aninhada não é visível, e Aninhada::e não é visível também
}

// extensões de função
fun MutableList<Int>.troca(index1: Int, index2: Int) {
    val tmp = this[index1]
    this[index1] = this[index2]
    this[index2] = tmp
}

fun main() {
    val list = mutableListOf(1, 2, 3)
    println(list)
    list.troca(0, 2)
    println(list)
}

// extensões de objeto
class A {
    companion object {
        fun saudar(): String {
            return("Bom dia!") // pode ser tbm só: return "Bom dia!"
        }
    }
}

fun main() {
    println("Olá " + A.saudar())
}

// classes de dados
data class Livro(val nome: String, val editora: String, var nota: Int)

fun main() {
    val livro: Livro = Livro("Kotlin", "Gran Cursos", 5) // pode ser tbm: val livro = Livro("Kotlin", "Gran Cursos", 5) -> sem informar o tipo de dado "Livro"
    println("O nome do livro é: " + livro.nome)
    println("Editora: " + livro.editora)
    println("Nota: " + livro.nota)
    livro.nota = 7
    println("Imprimindo tudo: " + livro.toString())
    println("HashCode: " + livro.hashCode())
}

// classes seladas não podem ser estendidas depois que foram compiladas

sealed interface Expr

sealed class MathExpr(): Expr

data class Const(val number: Double): MathExpr()
data class Sum(val e1: Expr, val e2: Expr): MathExpr()
object NotANumber: Expr

// genéricos
class Caixa<T>(t: T) {
    var valor = t
}

val caixa1: Caixa<Int> = Caixa<Int>(1) // pode ser tbm: val caixa1: Caixa<Int> = Caixa(1)
val caixa2 = Caixa(2)

fun main() {
    println(caixa1.valor)
    println(caixa2.valor)
}


????????????

// função sem retorno -> Unit
fun printHello(name: String?): Unit { // pode ser tbm sem o Unit: fun printHello(name: String?) {
    if (name != null)
    	println("Hello, $name!")
    else
    	println("Hi there!")
    // 'return Unit' ou 'return' é opcional
}

fun main() {
    var a = printHello("Gabi")
    var b = printHello(null)
}

// funções de expressão única
fun teste1(x: Int): Int = x * 2
fun teste2(x: Int = 5) = x * 2
fun teste3(x: Int = 5) = x * 2

fun main() {
    var a = teste1(2)
    var b = teste2(2)
    var c = teste3()
    println("a = $a \nb = $b \nc = $c")
}

// número variável de argumentos
fun <T> asList(vararg ts: T): List<T> {
    val result = ArrayList<T>()
    for (t in ts) // ts é um Array
    	result.add(t)
    return result
}

fun main() {
    val a = asList(1, 2, 3)
    val b = arrayOf(1, 2, 3)
    val c = asList(-1, 0, 4)
    
    println("a = $a \nb = $b \nc = $c")
}

// notação infixa
infix fun Int.sh1(x: Int): Int { return x + 1 }

fun main() {
    // chamando a função usando a notação infixa
    println(1 sh1 2)

    // é o mesmo que
    println(1.sh1(2))
}





// SLIDE 36


// TESTE

fun main() {
    val a = 5
    var b = ++a
    
    println("a = $a")
    println("b = $b")
}


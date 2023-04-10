// não pode usar aspas simples, nem pra 1 caracter apenas -> somente aspas duplas " "

print("oi", "Gabi", "e", "Jhony", separator: "-", terminator: "!")

// Type Aliases -> apelidos para tipos de dados -> type = tipo, alias = apelido

typealias MeuInteiro = Int
var distancia: MeuInteiro = 100
print(distancia)

// optional

var minhaString: String? = nil // se não fizer uma atribuição inicial (var minhaString: String?), a variável tbm inicia com valor nulo
if minhaString != nil {
  print(minhaString)
} else {
  print("minhaString é nula")
}

// desembrulhamento forçado

var minhaString: String? 
minhaString = "foo"

if minhaString != nil {
  print(minhaString)
} else {
  print("minhaString é nula")
}
// Optional("foo")

if minhaString != nil {
  print(minhaString!) // colocar ! depois do nome da variável
} else {
  print("minhaString é nula")
}
// foo

// tuplas -> utilizadas para dados intrinsecamente relacionados

var erro501 = (501, "Não implementado")
print("O código é \(erro501.0) e sua definição é: \(erro501.1).")

var erro404 = (codigo: 404, descricao: "Não encontrado")
print(erro404.codigo)

// operador Nil Coalescing

var a: Int?
let b = 10
let c = (a ?? b)
print(c)

let d = a != nil ? a! : b
print(d)

// operador de intervalo fechado -> inclui as extremidades

for index in 1...4 {
  print("\(index) vezes 5 é \(index * 5)")
}

// intervalo semiaberto

let nomes = ["Ana", "Bia", "Jhony"]
let count = nomes.count
print(count)

for i in 0..<count {
  print("Pessoa \(i) se chama \(nomes[i])")
}

// intervalo unilateral

let nomes = ["Ana", "Bia", "Jhony", "Pedro"]
let count = nomes.count
print(count)

for nome in nomes[2...] {
  print(nome)
}

print("--------------")

for nome in nomes[...2] {
  print(nome)
}

// switch

var a = 10
switch a {
  case 100:
    print("valor é 100")
  case 10, 15:
    print("valor 10 ou 15")
    fallthrough // verifica as demais condições, imprimindo "valor 10 ou 15" e "valor entre 10 e 15" para a = 10 e a = 15
  case 10...15:
    print("valor entre 10 e 15")
  default:
    print("caso padrão")
}

// arrays

// sintaxe convencional
var a: Array<Int> = [1, 5]
print(a)

// sintaxe abreviada
var b: [Int]
b = [2, 4, 8]
print("b possui \(b.count) elementos")

// tipo inferido
var c = [6, 8]
c.append(3)
print("c: \(c)")

c = []
print("o tipo se mantém:", c, type(of: c))

var tresValores = Array(repeating: 1.2, count: 3)
print("tresValores:", tresValores)
print("tipo tresValores:", type(of: tresValores))

// Conjuntos / Sets -> elementos não são duplicados e nem indexados (não dá pra saber a posição deles)

var a: Set<Int> = [1, 5, 1]
print(a)
// [5, 1]

// Dicionários -> não perde a memória do tipo original

var nomesDeInteiros: [Int: String] = [:]
nomesDeInteiros[16] = "dezesseis"
print(nomesDeInteiros)
nomesDeInteiros = [:]
print(nomesDeInteiros, type(of: nomesDeInteiros))

var ufs: [String: String] = ["GO": "Goiás", "DF": "Brasília"]

// opcional
if let uf = ufs["DF"] {
  print("O nome da UF é \(uf).")
} else {
  print("UF não está no dicionário")
}

// removendo
ufs["GO"] = nil
print(ufs)

if let removido = ufs.removeValue(forKey: "DF") {
  print("O valor removido é \(removido).")
} else {
  print("O dicionário não continha a chave.")
}
print(ufs)

// funções

// definição
func saudar(pessoa: String) -> String {
  let saudacao = "Olá, " + pessoa + "!"
  return saudacao
}

// chamada
print(saudar(pessoa: "Gabi"))

// sem retorno
func saudar2(pessoa: String) {
  print("Olá, " + pessoa + "!")
}
saudar2(pessoa: "Jhony")

// retorno implícito
func saudar3(para pessoa: String) -> String {
  "Olá, " + pessoa + "!"
}
print(saudar3(para: "Maria"))

// omitindo rótulo
func saudar4(_ pessoa: String) -> String {
  "Olá, " + pessoa + "!"
}
print(saudar4("Maria"))

// parâmetros padrão
func saudar5(pessoa: String = "anônimo") {
  print("Olá, " + pessoa + "!")
}
saudar5()

// parâmetros variáveis
func media(_ numeros: Double...) -> Double {
  var total: Double = 0
  for num in numeros {
    total += num
  }
  return total / Double(numeros.count)
}
print(media(1, 2, 3, 4, 5))

// inout -> parâmetros de entrada são os mesmos de saída
func trocaValores(_ a: inout Int, _ b: inout Int) {
  let tempA = a
  a = b
  b = tempA
}
var umInt = 3
var outroInt = 27
trocaValores(&umInt, &outroInt)

print("umInt:", umInt, "\noutroInt:", outroInt)

// (Int, Int) -> Int
func soma(_ a: Int, _ b: Int) -> Int {
  return a + b
}
// (Int, Int) -> Int
func multiplica(_ a: Int, _ b: Int) -> Int {
  return a * b
}
// () -> Void
func olaMundo() {
  print("Olá, mundo!")
}

var funcaoMatematica: (Int, Int) -> Int = soma
print("Soma:", funcaoMatematica(3, 5))

funcaoMatematica = multiplica
print("Multiplica:", funcaoMatematica(3, 5))

func imprimeRes(_ funcMat: (Int, Int) -> Int, _ a: Int, _ b: Int) {
  print("Resultado: \(funcMat(a, b))")
}
imprimeRes(soma, 3, 5)

// closures
let nomes = ["Antônio", "Tiago", "Artur", "Bruno"]

func reverso(_ s1: String, _ s2: String) -> Bool {
  return s1 > s2
}
var nomesInvertido = nomes.sorted(by: reverso) // sorted devolve uma cópia ordenada da lista, mas não a altera
print(nomesInvertido)

// outra forma
let nomesInvertido = nomes.sorted(by: {(s1: String, s2: String) -> Bool in return s1 > s2})

// outra forma
let nomesInvertido = nomes.sorted(by: {s1, s2 in return s1 > s2})

// outra forma
let nomesInvertido = nomes.sorted(by: {s1, s2 in s1 > s2})

// outra forma
let nomesInvertido = nomes.sorted(by: >)

// enumerações
enum PontoCardeal {
  case norte
  case sul
  case leste
  case oeste
}
enum Planetas {
  case mercurio, venus, terra, marte, jupiter
}
var direcao = PontoCardeal.norte
switch direcao {
  case .norte:
    print("N")
  case .sul:
    print("S")
  default:
    print("L ou O")
}

// structs -> são value type -> significa que, quando é atribuído um valor para outro, cada instância mantém uma cópia exclusiva dos dados -> se uma instância for alterada, a outra não será modificada
// não precisa usar um construtor para inicializar as variáveis, pois ele já está lá indiretamente
// structs são imutáveis, então, se quiser alterar uma propriedade dessa struct dentro de uma função, é preciso adicionar a palavra reservada mutating antes do nome da função
struct Pessoa {
  var nome: String
  var sobrenome: String
  var idade: Int

  func boasVindas() {
    print("Boas-vindas, \(nome) \(sobrenome)!")
  }

  mutating func mudarNome(novoNome: String) {
    self.nome = novoNome
  }
}
var pessoa = Pessoa.init(nome: "John", sobrenome: "Doe", idade: 34)
print(pessoa.idade) 
pessoa.boasVindas()


// classes
/* é recomendado usar classes (em vez de structs):
    - quando você precisar utilizar o conceito de herança, herdar propriedades/métodos de uma outra classe pai;
    - quando você precisar de interoperabilidade, ou seja, utilizar um código de Objective-C, já que nessa linguagem não existe struct;
    - quando precisamos controlar a identidade, já que as classes em Swift vêm com uma noção embutida de identidade porque são tipos de referência.
*/
class Pessoa {
  var nome: String
  var sobrenome: String
  var idade: Int

  init(nome: String, sobrenome: String, idade: Int) { // construtor
    self.nome = nome
    self.sobrenome = sobrenome
    self.idade = idade
  }

  func boasVindas() {
    print("Boas-vindas, \(nome) \(sobrenome)")
  }
}
var pessoa1 = Pessoa.init(nome: "John", sobrenome: "Doe", idade: 34)
var pessoa2 = pessoa1
pessoa1.nome = "Gabriel"
print(pessoa1.nome) // Gabriel
print(pessoa2.nome) // Gabriel



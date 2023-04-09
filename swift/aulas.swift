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




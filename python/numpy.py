import numpy as np

dados = np.random.rand(2,3)

# todos os dados do array são do mesmo tipo -> float64
dados.dtype 

# tamanho
dados.shape

# dimensão
dados.ndim

lista = [1, 2, 5, 7.8, 1.25]

dados2 = np.array(lista) # converte os nºs inteiros para float, pq no array os dados são todos do mesmo tipo

dados_zero = np.zeros(10) # cria um array de 10 elementos, todos com valor 0 -> float64

dados_zero2 = np.zeros((2,3)) # cria uma mariz de 2 linhas com 3 elementos cada uma com valor 0 -> float64

dados_um = np.ones(5) # cria um array de 5 elementos, todos com valor 1 -> float

dados_seq = np.arange(10) # cria um array de 10 valores sequenciais, começando do 0 -> int64

dados_seq2 = np.arange(0, 20, 2) # -> int64

dados_seq_float = dados_seq.astype(np.float64)

mascara = (dados_seq < 5) # retorna um array com True para dados com valor abaixo de 5 e False caso contrário

dados_seq[dados_seq < 2] = 100

dados.T # retorna a matriz transposta

np.dot(dados.T, dados) # faz a multiplicação das matrizes


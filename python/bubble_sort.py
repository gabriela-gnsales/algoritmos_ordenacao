def bubble_sort_chatgpt(array):
    n = len(array)
    # Percorre todos os elementos do array
    for i in range(n):
        # Percorre todos os elementos do array, exceto os que já estão ordenados
        for j in range(0, n-i-1):
            # Se o elemento atual é maior que o próximo elemento, troca-os de posição
            if array[j] > array[j+1]:
                array[j], array[j+1] = array[j+1], array[j]
    return array

def bubble_sort(array):  
    count = 0  
    for final in range(len(array), 0, -1):
        for atual in range(final-1):
            if array[atual] > array[atual+1]:
                array[atual], array[atual+1] = array[atual+1], array[atual]
        print(f'{count}: {array}')
        count += 1
    print(f'nº de iterações: {count}')
    # return array

# Exemplo de uso

vetor_ex = [64, 34, 25, 12, 22, 11, 90]

bubble_sort(vetor_ex)

# print('Array ordenado:')
# print(bubble_sort_chatgpt(array))
# print(bubble_sort(array))

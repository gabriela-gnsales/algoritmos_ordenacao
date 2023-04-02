def insertion_sort(array):   
    count = 0  
    for p in range(len(array)):
        current_element = array[p]
        while p > 0 and array[p-1] > current_element:
            array[p] = array[p-1]
            p -= 1
        array[p] = current_element
        print(f'{count}: {array}')
        count += 1
    print(f'nº de iterações: {count}')

# Exemplo de uso

vetor_ex = [64, 34, 25, 12, 22, 11, 90]

insertion_sort(vetor_ex)

# print('Array ordenado:')
# print(insertion_sort(array))
def selection_sort(array):   
    count = 0  
    for index in range(len(array)):
        min_index = index
        for right in range(index+1, len(array)):
            if array[right] < array[min_index]:
                min_index = right
        array[index], array[min_index] = array[min_index], array[index]
        print(f'{count}: {array}')
        count += 1
    print(f'nº de iterações: {count}')
    # return array

# Exemplo de uso

vetor_ex = [64, 34, 25, 12, 22, 11, 90]

selection_sort(vetor_ex)

# print('Array ordenado:')
# print(selection_sort(array))
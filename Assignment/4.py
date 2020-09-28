if '__main__' == __name__:
    c = input('Enter temp. in celsius')
    f = (9/5) * c + 32
    f = round(f, 2)
    print('Fahrenheit equivalent of ' + c + ' is ' + f)
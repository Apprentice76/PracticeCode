if '__main__' == __name__:
    x = input('Enter x: ')
    y = input('Enter y: ')
    print("""Enter choice:
    1. Add
    2. Subtract
    3. Divide
    4. Multiply
    5. Modulus
    6. Power (x^y)""")
    ch = int(input())
    if ch == 1:
        print('x + y: ' + (x+y))
    elif ch == 2:
        print('x - y: ' + (x-y))
    elif ch == 3:
        print('x / y: ' + round((x/y),2))
    elif ch == 4:
        print('x * y: ' + (x*y))
    elif ch == 5:
        print('x % y: ' + (x%y))
    elif ch == 6:
        print('x^y: ' + (x**y))
    else:
        print('INVALID CHOICE')
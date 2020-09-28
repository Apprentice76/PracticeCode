if '__main__' == __name__:
    hr = input('Enter hours worked: ')
    rate = input('Enter rate per hour: ')
    gpay = int(hr)*int(rate)
    print('Gross Pay is: ' + gpay)
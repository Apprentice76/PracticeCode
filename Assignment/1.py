if '__main__' == __name__:
    name = input('Enter name: ')
    roll = input('\nEnter roll no., sem (with space inbetween): ').split()
    branch = input('\nEnter branch (ex. CSE), department (with space inbetween): ').split()
    clg = input('\nCollege name: ')

    # This is a single line comment bhfbhefhehf

    """
    Multiline Comment:

    hduhejd
    dihduwjidwd]'wpjd\\dh (used two backlashes here because if I used one it interpreter
    whduhwjdij             would have considered an escape character!)
    dujwidjow
    wuhdwjodpwld
    w
    """

    print('NAME: ' + name)
    print('ROLL NO.: ' + roll[0])
    print('SEMESTER: ' + roll[1])
    print('BRANCH: ' + branch[0])
    print('DEPT.: ' + branch[1:])
    print('COLLEGE: ' + clg)
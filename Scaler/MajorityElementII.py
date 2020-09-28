class Solution:
    def repeatedNumber(self, A):
        count1, count2 = 0, 0
        el1, el2 = -1, -1
        for i in A:
            if i == el1: count1 += 1
            elif i == el2: count2 += 1
            elif count1 == 0:
                el1 = i
                count1 = 1
            elif count2 == 0:
                el2 = i
                count2 = 1
            else:
                count1 -= 1
                count2 -= 1
        count1, count2 = 0, 0
        for i in A:
            if i == el1: count1 += 1
            elif i == el2: count2 += 1
        if count1 > len(A) // 3: return el1
        elif count2 > len(A) // 3: return el2
        else: return -1
class Solution:
    # @param A : list of list of integers
    # @return the same list modified
    def setZeroes(self, A):
        List = [];
        for i in range(len(A)):
            for j in range(len(A[0])):
                if A[i][j] == 0:
                    List.append([i, j]);
        # print(List)
        
            
        def setColZeroes(A, c):
            for i in range(len(A)):
                A[i][c] = 0
            
        def setRowZeroes(A, r):
            for i in range(len(A[0])):
                A[r][i] = 0
                
        for key in range(len(List)):
            setColZeroes(A, List[key][1])
            setRowZeroes(A, List[key][0])

    # Optimal Solution:
    # class Solution:
    # # @param A : list of list of integers
    # # @return the same list modified
    # def setZeroes(self, A):
    #     r = len(A)
    #     c = len(A[0])
    #     zFirstRow = False
    #     zFirstCol = False
        
    #     for i in range(r):
    #         if A[i][0] == 0: 
    #             zFirstCol = True
    #             break
    #     for i in range(c):
    #         if A[0][i] == 0:
    #             zFirstRow = True
    #             break
        
    #     for i in range(1, r):
    #         for j in range(1, c):
    #             if A[i][j] == 0:
    #                 A[i][0] = 0
    #                 A[0][j] = 0
                    
    #     for i in range(1, r):
    #         for j in range(1, c):
    #             if A[i][0] == 0 or A[0][j] == 0:
    #                 A[i][j] = 0
    #     if zFirstRow:
    #         for i in range(c):
    #             A[0][i] = 0
    #     if zFirstCol:
    #         for i in range(r):
    #             A[i][0] = 0
                    
        
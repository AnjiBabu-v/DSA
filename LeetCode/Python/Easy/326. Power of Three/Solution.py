class Solution:
    def isPowerOfThree(self, n: int) -> bool:
        if n<=0:
            return False
        a=n**(1/3)
        if a.is_integer():
            return True
        return False    
        
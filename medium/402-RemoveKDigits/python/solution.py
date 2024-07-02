class Solution(object):
    def removeKdigits(self, num, k):
        """
        :type num: str
        :type k: int
        :rtype: str
        """
        
        if(k == len(num)):
            return "0"
        
        x = 0
        found = 0
        while x < len(num):
            x+= 1 if (x == -1) else 0
            if(x==len(num)-1 or int(num[x]) > int(num[x+1])):
                    num = num[:x] + num[x+1:]
                    x-=1
                    found+=1
                    if(found == k):
                        break
            else:
                x+=1

        if(found != k):
            num = num[k-found:]
        
        result = num.lstrip('0')
        
        if(result == ""): 
            return "0" 
        else:
            return result 
        
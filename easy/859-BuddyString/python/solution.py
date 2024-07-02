class Solution(object):
    def buddyStrings(self, s, goal):
        """
        :type s: str
        :type goal: str
        :rtype: bool
        """
        diff = {}
        
        if(len(s) != len(goal)):
            return False
        
        for i in range(len(s)):
            if(s[i] != goal[i]):
                if(not s[i] in diff):
                   diff[s[i]] = [goal[i]]
                else:
                    return False
        
                   
        if(len(diff) == 2):
            a,b = diff.keys()
            if(diff[a][0] == b and diff[b][0] == a):
                return True
        
        letters = {}
        if(len(diff) == 0):
            for i in range(len(s)):
                if(s[i] in letters):
                    return True
                letters[s[i]] = 1
        
        return False
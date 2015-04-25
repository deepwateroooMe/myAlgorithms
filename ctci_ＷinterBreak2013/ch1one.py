def has_unique_chars(string):
    # Strategy: Linearly check if the char of the string belongs to the dictionary, otherwise add it
    # Time complexity is O(n) and space complexity is O(n)
    dictionary = {} #technically, a boolean array (for the char set) would do the job for ASCII strings
    for i in string:
        if i in dictionary:
            return False
        else:
            dictionary[i] = True
    return True

# What if you can't use an additional data structure?

def has_unique_chars2(string):
    # Stragety: Check every char of the string with every other char of the string
    # Time complexity is O(n^2) and space complexity is O(1)
    for i in xrange(len(string)):
        for j in xrange(i + 1, len(string)):
            if string[i] == string[j]:
                return False
    return True

# If destroying the input is allowed:

def has_unique_chars3(string):
    # Strategy: Sort the string inline and linearly check the string for identical neighboring characters
    # Time complexity is O(n * log(n) + n => n * log(n)) and space complexity is O(1)
    string = ''.join(sorted(string)) #technically, this creates a new list and then joins back to string
    for i in xrange(len(string) - 1):
        if string[i] == string[i+1]:
            return False
    return True

if __name__ == '__main__':
    case1 = 'abcdefghijklmnopqrstuvwxyz'
    case2 = 'abcdefghijklmabcdefghijklm'
    print has_unique_chars(case1)
    print has_unique_chars(case2)
    print has_unique_chars2(case1)
    print has_unique_chars2(case2)
    print has_unique_chars3(case1)
    print has_unique_chars3(case2)

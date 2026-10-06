import numpy as np

l1 = [100, 200, 300]
l2 = [400, 500, 600]
l3 = np.array([l1, l2])
print ("size:",l3.size)
print ("size:",l3.shape)
x= np.zeros([1,3], dtype = int)
#print (x)
y= np.ones([2,3], dtype = int) *3
#print (y)

# Indexing
#print ("l3[0,0]:",l3[0,0])
y = np.array([[1,2,3],[4,5,6],[7,8,9]])
y[1,2]=16 # change only one value
print(y[1,2])
p = y[0:3, :]
print(p)
x = x.T
x= np.transpose(x)
x[ : 3]= x[:3] +2
print(x)
print(type(x))

#arr = np.arange(0, 10, 2)
#print(arr)
##arr  = np.arange(0, 10, 2).reshape(5,1)
##print(arr)
#p = x [0:2, 0:2]
#q = x [2:0, 1:0]
#print (q)
"""
print(np.greater(x,y))
print(np.less(x,y))
print(np.equal(x,y))
print(np.logical_and(x,y))
print(np.logical_or(x,y))
print(np.logical_not(x))
print(np.add(x,y))
"""
#aggregate functions
g =np.arange [1,2,3,4,5,6,7,8,9]
print(np.sum(g))
print(np.mean(g))
print(np.std(g))


/*
 * Title: siece.cpp
 * Abstract: Calculates the prime numbers from an input using Sieve of Eratosthenes algorithm
 * Author: Daniel Calderon
 * ID: 3083
 * Date: 2/3/17
 */
#include<iostream>
#include<cstdlib>
#include<cmath>
using namespace std;
void grow(int*& L,int count);
int* sieve(int n,int&size);
int main()
{
	int n;
	int* final;
	int size;
	cout << "Enter a number: " ;
	cin >> n;
	final = sieve(n,size);
	cout << "Prime Numbers: ";
	for(int i= 0 ;i < size;i++)
	{
		if(i < size-1)
			cout << final[i] << ", ";
		else
			cout << final[i];
	}
	return EXIT_SUCCESS;
}
int* sieve(int n,int&size)
{
	int A[n];
	int*L ;
	int j = 0;
	for(int p = 2; p <= n;p++)
		A[p] = p;
	for(int p = 2; p <= floor(sqrt(n));p++)
	{
		if(A[p] != 0)
			j = p*p;
			while(j<=n)
			{
				A[j] = 0;
				j = j+p;
			}
	}
	int i = 0;
	int count = 0;
	for(int p = 2; p < n;p++)
	{
		if(A[p] != 0)
		{
			count++;
			grow(L,count);
			L[i] = p;

			i +=1;
		}
	}
	size = count;
	return L;
}
void grow(int*& L,int count)
{
	int *n = new int[count+1];
	copy(L,L+count-1,n);
	if(count>1)
		delete[]L;
	L = n;
}



#include <iostream>
using namespace std;

int main() {
	int times;
	cin >> times;

	int cntPrime = 0;

	for (int i = 0; i < times; i++)
	{
		int num;
		cin >> num;

		bool isPrime = true;

		if (num == 1)
		{
			isPrime = false;
		} 
		else {
			for (int j = 2; j <= num / 2; j++)
			{
				if (num % j == 0)
				{
					isPrime = false;
					break;
				}
			}
		}
		
		if (isPrime)
		{
			cntPrime++;
		}
	}

	cout << cntPrime;
}
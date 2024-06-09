#include <iostream>
using namespace std;

int main() {
	
	int numArr[3];

	for (int i = 0; i < 3; i++)
	{
		cin >> numArr[i];
	}

	for (int i = 0; i < 2; i++)
	{
		for (int j = i + 1; j < 3; j++)
		{
			if (numArr[i] >= numArr[j])
			{
				int tmp = numArr[i];
				numArr[i] = numArr[j];
				numArr[j] = tmp;
			}
		}
		
	}

	for (int i = 0; i < 3; i++)
	{
		cout << numArr[i] << " ";
	}
}
#include <iostream>
using namespace std;

int main() {
	int n;
	int maxNum;

	cin >> n >> maxNum;

	int* numArr = new int[n];

	for (int i = 0; i < n; i++)
	{
		cin >> numArr[i];
	}

	for (int i = 0; i < n; i++)
	{
		if (numArr[i] < maxNum)
		{
			cout << numArr[i] << " ";
		}
	}
	delete[] numArr;
}
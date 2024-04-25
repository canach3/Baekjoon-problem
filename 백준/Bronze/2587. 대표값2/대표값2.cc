#include <iostream>
using namespace std;

int main() {
	int nArr[5];
	int sum = 0;
	for (int i = 0; i < 5; i++)
	{
		cin >> nArr[i];
		sum += nArr[i];
	}

	for (int i = 0; i < 4; i++)
	{
		for (int j = 0; j < 4; j++)
		{
			if (nArr[j] >= nArr[j + 1])
			{
				int tmp = nArr[j];
				nArr[j] = nArr[j + 1];
				nArr[j + 1] = tmp;
			}
		}
	}

	cout << sum / 5 << endl;
	cout << nArr[2] << endl;
}
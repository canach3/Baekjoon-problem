#include <iostream>
using namespace std;

int main() {

	int n, m;
	cin >> n >> m;

	int* cardArr = new int[n];

	for (int i = 0; i < n; i++)
	{
		cin >> cardArr[i];
	}

	int sum = 0;
	for (int i = 0; i < n - 2; i++)
	{
		for (int j = i + 1; j < n - 1; j++)
		{
			for (int k = j + 1; k < n; k++)
			{
				if (cardArr[i] + cardArr[j] + cardArr[k] >= sum && cardArr[i] + cardArr[j] + cardArr[k] <= m)
				{
					sum = cardArr[i] + cardArr[j] + cardArr[k];
				}
			}
		}
	}

	cout << sum << endl;
}
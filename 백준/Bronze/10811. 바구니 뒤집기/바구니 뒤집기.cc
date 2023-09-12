#include <iostream>
using namespace std;

int main() {
	int n, m, first, last, temp;
	cin >> n >> m;

	int* basArr = new int[n + 1];

	for (int i = 0; i <= n; i++)
	{
		basArr[i] = i;
	}
	
	for (int i = 0; i < m; i++)
	{
		cin >> first >> last;
		
		if (first == last)
		{
			continue;
		}

		for (int j = 0; j <= (last - first) / 2; j++)
		{
			temp = basArr[first + j];
			basArr[first + j] = basArr[last - j];
			basArr[last - j] = temp;
		}
	}
	for (int i = 1; i <= n; i++)
	{
		cout << basArr[i] << " ";
	}

	delete[] basArr;
}
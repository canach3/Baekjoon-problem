#include <iostream>
#include <algorithm>
using namespace std;

int main() {
		
	int paper[100][100] = { 0 };

	int n;
	cin >> n;

	int sum = 0;

	for (int i = 0; i < n; i++)
	{
		int x, y;
		cin >> x >> y;

		for (int j = x; j < x + 10; j++)
		{
			for (int k = y; k < y + 10; k++)
			{
				if (paper[j][k] == 0)
				{
					paper[j][k] = 1;
					sum++;
				}
			}
		}
	}

	cout << sum << endl;
}
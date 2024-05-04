#include <iostream>
using namespace std;

int main() {
	
	int minN;
	int maxN;
	cin >> minN >> maxN;

	int sum = 0;
	int minSquareN = maxN;
	for (int i = 1; i * i <= maxN; i++)
	{
		if (i * i >= minN && i * i <= maxN)
		{
			if (i * i <= minSquareN)
			{
				minSquareN = i * i;
			}

			sum += i * i;
		}
	}

	if (sum == 0)
	{
		cout << -1 << endl;
	}
	else {
		cout << sum << '\n' << minSquareN << endl;

	}
}
#include <iostream>
using namespace std;

int main() {

	int minN = 100;
	int sum = 0;

	for (int i = 0; i < 7; i++)
	{
		int n;
		cin >> n;

		if (n % 2 == 1)
		{
			sum += n;

			if (n <= minN)
			{
				minN = n;
			}
		}
	}

	if (minN == 100)
	{
		cout << -1 << endl;
		return 0;
	}

	cout << sum << "\n" << minN << endl;
}
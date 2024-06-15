#include <iostream>
using namespace std;

int main() {
	
	int n;
	cin >> n;

	for (int i = 0; i < n; i++)
	{
		int sum = 0;
		int minN = 100;

		for (int j = 0; j < 7; j++)
		{
			int number;
			cin >> number;

			if (number % 2 == 0)
			{
				sum += number;

				if (number <= minN)
				{
					minN = number;
				}
			}
		}

		cout << sum << " " << minN << endl;
	}
}
#include <iostream>
using namespace std;

int main() {

	int num;
	cin >> num;

	for (int i = 1; i < num; i++)
	{
		int sum = i;
		int tmp = i;

		while (true)
		{
			sum += tmp % 10;
			tmp /= 10;

			if (tmp == 0)
			{
				break;
			}
		}

		if (sum == num)
		{
			cout << i << endl;
			return 0;
		}
	}

	cout << 0 << endl;
}
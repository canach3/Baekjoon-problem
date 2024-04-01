#include <iostream>
using namespace std;

int main() {

	int n2;
	int n1;
	int sum = 0;
	int minNum = 0;

	cin >> n1 >> n2;

	for (int i = n1; i <= n2; i++)
	{
		int cnt = 0;
		for (int j = 1; j <= i; j++) {
			if (i % j == 0)
			{
				cnt++;
			}
		}

		if (cnt == 2)
		{
			sum += i;

			if (minNum == 0)
			{
				minNum = i;
			}
		}
	}

	if (minNum == 0)
	{
		cout << -1 << endl;
	}
	else {
		cout << sum << "\n" << minNum << endl;
	}
}	
#include <iostream>
using namespace std;

int main() {
	int testCase;
	cin >> testCase;

	for (int i = 0; i < testCase; i++)
	{
		int sum = 0;
		int carPrice;
		cin >> carPrice;

		sum += carPrice;

		int optionNum;
		cin >> optionNum;

		for (size_t i = 0; i < optionNum; i++)
		{
			int n;
			int optionPrice;
			cin >> n >> optionPrice;

			sum += (n * optionPrice);
		}

		cout << sum << endl;
	}
}
#include <iostream>
using namespace std;

int main() {

	int testCase;
	cin >> testCase;

	for (int i = 0; i < testCase; i++)
	{
		int n;
		cin >> n;

		int sum = 0;
		for (int j = 0; j < n; j++)
		{
			int num;
			cin >> num;

			sum += num;
		}

		cout << sum << endl;
	}
}
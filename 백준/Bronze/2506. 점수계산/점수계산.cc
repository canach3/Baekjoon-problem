#include <iostream>
using namespace std;

int main() {
	
	int n;
	cin >> n;

	int sum = 0;
	int plus = 0;
	for (int i = 0; i < n; i++)
	{
		int answer;
		cin >> answer;

		if (answer == 0)
		{
			plus = 0;
		}

		if (answer == 1)
		{
			sum += ++plus;
		}
	}

	cout << sum << endl;
}
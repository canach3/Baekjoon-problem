#include <iostream>
using namespace std;

int main() {
	int n;
	cin >> n;

	int sum = -n + 1;

	for (int i = 0; i < n; i++)
	{
		int plugs;
		cin >> plugs;

		sum += plugs;
	}

	cout << sum << endl;
}
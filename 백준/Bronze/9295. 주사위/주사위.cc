#include <iostream>
using namespace std;

int main() {

	int n;
	cin >> n;

	for (int i = 0; i < n; i++)
	{
		int sum = 0;
		int d1, d2;
		cin >> d1 >> d2;

		sum = d1 + d2;

		cout << "Case " << (i + 1) << ": " << sum << endl;
	}
}
#include <iostream>
using namespace std;

int main() {
	int n;
	cin >> n;

	int left = 0;
	for (int i = 0; i < n; i++)
	{
		int studentN;
		int appleN;

		cin >> studentN >> appleN;

		left += appleN % studentN;
	}

	cout << left << endl;
}
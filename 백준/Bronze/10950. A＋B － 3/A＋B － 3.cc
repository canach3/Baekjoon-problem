#include <iostream>
using namespace std;

int main() {

	int n;
	cin >> n;

	for (int i = 0; i < n; i++)
	{
		int num1, num2;
		cin >> num1;
		cin >> num2;
		cout << num1 + num2 << endl;
	}

	return 0;
}
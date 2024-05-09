#include <iostream>
using namespace std;

int main() {
	int totalPrice;
	cin >> totalPrice;

	int sum = 0;

	for (int i = 0; i < 9; i++)
	{
		int price;
		cin >> price;

		sum += price;
	}

	cout << totalPrice - sum << endl;
}
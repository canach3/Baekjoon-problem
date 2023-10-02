#include <iostream>

using namespace std;

int main() {
	
	int n;
	int quarter;
	int dime;
	int nickel;
	int penny;

	cin >> n;

	for (int i = 0; i < n; i++)
	{
		int change;
		cin >> change;

		quarter = change / 25;
		change %= 25;

		dime = change / 10;
		change %= 10;

		nickel = change / 5;
		change %= 5;

		penny = change;

		cout << quarter << " " << dime << " " << nickel << " " << penny << endl;
	}
}
#include <iostream>
using namespace std;

int main() {
	int sugar;
	cin >> sugar;

	int kg5 = sugar / 5;
	int kg3 = 0;
	
	int tmp = sugar % 5;

	while (tmp <= sugar)
	{
		if (tmp % 3 == 0)
		{
			kg3 = tmp / 3;
			cout << kg5 + kg3 << endl;

			return 0;
		}
		else {
			tmp += 5;
			kg5--;
		}
	}

	cout << -1 << endl;
}
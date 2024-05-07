#include <iostream>
using namespace std;

int main() {
	int n1, n2;
	cin >> n1 >> n2;

	int GCD = 0;
	int LCM = n1 * n2;

	for (int i = 1; i <= min(n1, n2); i++)
	{
		if ((n1 % i == 0) && (n2 % i == 0))
		{
			GCD = i;
		}
	}

	for (int i = n1 * n2; i >= max(n1, n2); i--)
	{
		if ((i % n1 == 0) && (i % n2 == 0))
		{
			LCM = i;
		}
	}

	cout << GCD << '\n' << LCM << endl;
}
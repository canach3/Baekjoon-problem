#include <iostream>
using namespace std;

int main() {

	int i = 1;
	while (true)
	{
		int n;
		cin >> n;

		if (n == 0)
		{
			return 0;
		}


		if (n % 2 != 0)
		{
			cout << i << ". odd " << (n - 1) / 2 << endl;
		}
		else {
			cout << i << ". even " << (n / 2) << endl;
		}

		i++;
	}
}
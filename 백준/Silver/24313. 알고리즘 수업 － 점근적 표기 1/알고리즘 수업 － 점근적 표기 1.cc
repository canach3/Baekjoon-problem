#include <iostream>
using namespace std;

int main() {

	int a1, a0;
	int c;
	int n0;

	cin >> a1 >> a0 >> c >> n0;

	if (c >= a1)
	{
		if ((n0 * c) >= (a1 * n0 + a0))
		{
			cout << 1 << endl;
		}
		else {
			cout << 0 << endl;
		}
	}
	else {
		cout << 0 << endl;
	}

}
#include <iostream>
using namespace std;

int main() {

	int fibo[46];

	fibo[0] = 0;
	fibo[1] = 1;

	for (int i = 2; i <= 45; i++)
	{
		fibo[i] = fibo[i - 1] + fibo[i - 2];
	}

	int n;
	cin >> n;

	cout << fibo[n] << endl;
}
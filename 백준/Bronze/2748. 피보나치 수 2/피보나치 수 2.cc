#include <iostream>
using namespace std;

int main() {
	long long n;
	cin >> n;

	long long sequence[91] = { 0, 1, };

	for (int i = 2; i <= 90; i++)
	{
		sequence[i] = sequence[i - 2] + sequence[i - 1];
	}
	
	cout << sequence[n];
}
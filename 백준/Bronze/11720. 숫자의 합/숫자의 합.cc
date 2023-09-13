#include <iostream>
using namespace std;

int main() {
	
	int n;
	cin >> n;

	char number[100];
	int sum = 0;

	for (int i = 0; i < n; i++)
	{
		cin >> number[i];
		sum += (int)number[i] - 48;
	}
	
	cout << sum << endl;
	
}
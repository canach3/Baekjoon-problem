#include <iostream>
#include <cmath>
using namespace std;

int main() {
	
	string n;
	int b;
	long result = 0;

	cin >> n >> b;

	for (int i = 0; i < n.length(); i++)
	{
		if (n[i] >= '0' && n[i] <= '9') {
			result += (n[i] - '0') * pow(b, n.length() - 1 - i);
		}
		else {
			result += (n[i] - 55) * pow(b, n.length() - 1 - i);
		}
	}

	cout << result;
}
#include <iostream>

using namespace std;

int main() {
	
	int a;
	int b;

	cin >> a;
	cin >> b;

	cout.precision(15);
	cout << (double)a / b << endl;
	
	return 0;
}
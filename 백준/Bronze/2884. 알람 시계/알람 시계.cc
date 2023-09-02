#include <iostream>

using namespace std;

int main() {
	
	int h, m;
	cin >> h;
	cin >> m;

	if (m >= 45) {
		m -= 45;
	}
	else if (h == 0) {
		h = 23;
		m += 15;
	}
	else {
		h -= 1;
		m += 15;
	}

	cout << h;
	cout << " ";
	cout << m << endl;

	return 0;
}
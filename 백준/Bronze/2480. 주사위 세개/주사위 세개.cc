#include <iostream>

using namespace std;

int main() {
	
	int d1, d2, d3;
	int prize;

	cin >> d1;
	cin >> d2;
	cin >> d3;

	if (d1 == d2 && d2 == d3) {
		prize = 10000 + (d1 * 1000);
	}
	else if (d1 == d2 || d1 == d3) {
		prize = 1000 + (d1 * 100);
	}
	else if (d2 == d3) {
		prize = 1000 + (d2 * 100);
	}
	else if (d1 >= d2 && d1 >= d3) {
		prize = d1 * 100;
	}
	else if (d2 >= d1 && d2 >= d3) {
		prize = d2 * 100;
	}
	else {
		prize = d3 * 100;
	}

	cout << prize;

	return 0;
}
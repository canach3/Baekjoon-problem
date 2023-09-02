#include <iostream>

using namespace std;

int main() {
	
	int h, m, time;
	cin >> h;
	cin >> m;
	cin >> time;

	h += (m + time) / 60;
	m = (m + time) % 60;

	cout << h % 24 << " " << m << endl;

	return 0;
}
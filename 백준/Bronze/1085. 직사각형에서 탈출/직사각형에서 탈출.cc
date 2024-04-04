#include <iostream>
using namespace std;

int main() {

	int x, y;
	int w, h;

	cin >> x >> y >> w >> h;

	int shortest = min(min(x - 0, y - 0), min(w - x, h - y));

	cout << shortest << endl;
}	
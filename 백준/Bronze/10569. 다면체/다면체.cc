#include <iostream>
using namespace std;

int main() {

	int n;
	cin >> n;

	for (int i = 0; i < n; i++)
	{
		int corners, edge;
		cin >> corners >> edge;

		cout << edge - corners + 2 << endl;
	}
}
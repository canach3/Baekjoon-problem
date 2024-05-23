#include <iostream>
using namespace std;

int main() {

	int n;
	cin >> n;

	for (int i = 0; i < n; i++)
	{
		int totalPieces;
		int people;

		cin >> totalPieces >> people;

		int getPieces = totalPieces / people;
		int rest = totalPieces % people;

		cout << "You get " << getPieces << " piece(s) and your dad gets " << rest << " piece(s)." << endl;
	}
}
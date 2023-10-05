#include <iostream>

using namespace std;

int main() {
	
	int n;
	cin >> n;

	int edgeDot = 2;
	
	for (int i = 0; i < n; i++)
	{
		edgeDot = edgeDot * 2 - 1;
	}

	cout << edgeDot * edgeDot;

	return 0;
}
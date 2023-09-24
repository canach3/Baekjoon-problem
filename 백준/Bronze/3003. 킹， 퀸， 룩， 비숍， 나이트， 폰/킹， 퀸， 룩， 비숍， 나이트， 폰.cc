#include <iostream>
using namespace std;

int main() {
	
	int piece[6] = { 1, 1, 2, 2, 2, 8 };
	
	for (int i = 0; i < 6; i++)
	{
		int input;
		cin >> input;
		piece[i] -= input;
	}

	for (int i = 0; i < 6; i++)
	{
		cout << piece[i] << " ";
	}
	
}
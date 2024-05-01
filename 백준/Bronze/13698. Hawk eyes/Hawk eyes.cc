#include <iostream>
using namespace std;

int main() {

	int cups[] = { 1, 0, 0, 2 };

	string input;
	cin >> input;

	for (int i = 0; i < input.length(); i++)
	{
		int tmp;
		switch (input[i]) {
		case 'A':
			tmp = cups[0];
			cups[0] = cups[1];
			cups[1] = tmp;
			break;
		case 'B':
			tmp = cups[0];
			cups[0] = cups[2];
			cups[2] = tmp;
			break;
		case 'C':
			tmp = cups[0];
			cups[0] = cups[3];
			cups[3] = tmp;
			break;
		case 'D':
			tmp = cups[1];
			cups[1] = cups[2];
			cups[2] = tmp;
			break;
		case 'E':
			tmp = cups[1];
			cups[1] = cups[3];
			cups[3] = tmp;
			break;
		case 'F':
			tmp = cups[2];
			cups[2] = cups[3];
			cups[3] = tmp;
			break;
		}
	}
	
	for (int i = 0; i < 4; i++)
	{
		if (cups[i] == 1)
		{
			cout << i + 1 << endl;
		}
	}

	for (int i = 0; i < 4; i++)
	{
		if (cups[i] == 2)
		{
			cout << i + 1 << endl;
		}
	}
}
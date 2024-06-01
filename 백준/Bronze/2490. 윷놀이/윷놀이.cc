#include <iostream>
using namespace std;

int main() {
	
	for (int i = 0; i < 3; i++)
	{
		int front = 0;

		for (int j = 0; j < 4; j++)
		{
			int stick;
			cin >> stick;

			if (stick == 0)
			{
				front++;
			}
		}

		switch (front)
		{
			case 0: 
				cout << 'E' << endl;
				break;
			case 1:
				cout << 'A' << endl;
				break;
			case 2:
				cout << 'B' << endl;
				break;
			case 3:
				cout << 'C' << endl;
				break;
			case 4:
				cout << 'D' << endl;
		}
	}
}
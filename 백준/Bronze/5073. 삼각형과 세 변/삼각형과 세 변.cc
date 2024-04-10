#include <iostream>
using namespace std;

int main() {

	int side1;
	int side2;
	int side3;

	while (true)
	{
		cin >> side1 >> side2 >> side3;

		if (side1 == 0 && side2 == 0 && side3 == 0)
		{
			break;
		}
		else {
			if (max(max(side1, side2), side3) >= side1 + side2 || max(max(side1, side2), side3) >= side1 + side3 || max(max(side1, side2), side3) >= side2 + side3)
			{
				cout << "Invalid" << endl;
			}
			else if (side1 == side2 && side2 == side3)
			{
				cout << "Equilateral" << endl;
			}
			else if (side1 == side2 || side1 == side3 || side2 == side3)
			{
				cout << "Isosceles" << endl;
			}
			else {
				cout << "Scalene" << endl;
			}
		}
	}
}
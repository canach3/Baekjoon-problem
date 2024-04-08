#include <iostream>
using namespace std;

int main() {

	int angle1;
	int angle2;
	int angle3;

	cin >> angle1 >> angle2 >> angle3;

	if (angle1 + angle2 + angle3 != 180)
	{
		cout << "Error" << endl;
	}
	else {
		if (angle1 == angle2 && angle1 == angle3 && angle2 == angle3)
		{
			cout << "Equilateral" << endl;
		}
		else if (angle1 == angle2 || angle1 == angle3 || angle2 == angle3)
		{
			cout << "Isosceles" << endl;
		}
		else
		{
			cout << "Scalene" << endl;
		}
	}
}
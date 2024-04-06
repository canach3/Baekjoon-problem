#include <iostream>
using namespace std;

int main() {

	int x;
	int y;
	int sumX = 0;
	int sumY = 0;
	int xArr[3];
	int yArr[3];
	int needX;
	int needY;


	for (int i = 0; i < 3; i++)
	{
		cin >> x >> y;

		xArr[i] = x;
		yArr[i] = y;
		
		sumX += x;
		sumY += y;
	}

	if (x == xArr[0] || x == xArr[1])
	{
		sumX -= x * 2;
		needX = sumX;
	}
	else {
		needX = x;
	}

	if (y == yArr[0] || y == yArr[1])
	{
		sumY -= y * 2;
		needY = sumY;
	}
	else {
		needY = y;
	}

	cout << needX << " " << needY << endl;
}	
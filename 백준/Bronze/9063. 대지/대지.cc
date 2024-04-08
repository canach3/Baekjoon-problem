#include <iostream>
using namespace std;

int main() {

	int n;
	int x, y;
	int minX = 10000;
	int maxX = -10000;
	int minY = 10000;
	int maxY = -10000;

	cin >> n;

	for (int i = 0; i < n; i++)
	{
		cin >> x >> y;
		if (x < minX)
		{
			minX = x;
		}
		if (x > maxX)
		{
			maxX = x;
		}
		if (y < minY)
		{
			minY = y;
		}
		if (y > maxY)
		{
			maxY = y;
		}
	}
	
	int area = (maxX - minX) * (maxY - minY);

	cout << area << endl;
}
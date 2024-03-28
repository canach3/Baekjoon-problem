#include <iostream>
using namespace std;

int main()
{
	int upLength;
	int downLength;
	int treeLength;
	int days;

	cin >> upLength >> downLength >> treeLength;

	days = (treeLength - downLength) / (upLength - downLength);

	if ((treeLength - downLength) % (upLength - downLength) != 0)
	{
		days++;
	}

	cout << days << endl;
}
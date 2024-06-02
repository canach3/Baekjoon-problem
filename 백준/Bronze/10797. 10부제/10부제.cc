#include <iostream>
using namespace std;

int main() {
	
	int date;
	cin >> date;

	int violate = 0;
	for (int i = 0; i < 5; i++)
	{
		int carNum;
		cin >> carNum;

		if (date == carNum)
		{
			violate++;
		}
	}

	cout << violate << endl;
}
#include <iostream>
using namespace std;

int main() {
	
	int n;
	cin >> n;

	for (int i = 0; i < n; i++)
	{
		int playerN;
		cin >> playerN;

		int price;
		int maxPrice = 0;
		string name;
		string pick;
		for (int j = 0; j < playerN; j++)
		{
			cin >> price;
			cin.ignore();
			cin >> name;

			if (price >= maxPrice)
			{
				maxPrice = price;
				pick = name;
			}
		}

		cout << pick << endl;
	}
}
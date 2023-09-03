#include <iostream>
using namespace std;

int main() {

	int total_cost;
	int kind;
	int price;
	int n;
	int sum = 0;

	cin >> total_cost;
	cin >> kind;

	for (int i = 0; i < kind; i++)
	{
		cin >> price;
		cin >> n;
		sum += (price * n);
	}

	if (total_cost == sum)
	{
		cout << "Yes" << endl;
	}
	else {
		cout << "No" << endl;
	}


	return 0;
}
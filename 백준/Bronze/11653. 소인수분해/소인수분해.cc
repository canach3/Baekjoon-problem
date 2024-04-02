#include <iostream>
using namespace std;

int main() {

	int num;
	cin >> num;

	int i = 2;
	while (true)
	{
		if (num == 1)
		{
			return 0;
		}
		else {
			if (num % i == 0)
			{
				cout << i << endl;
				num /= i;
			}
			else {
				i++;
			}
		}
	}
}	
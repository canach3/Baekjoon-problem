#include <iostream>
#include <algorithm>
using namespace std;

int main() {

	string num;
	cin >> num;
	
	for (int i = 0; i < num.length() - 1; i++)
	{
		for (int j = 0; j < num.length() - 1; j++)
		{
			if (num[j] <= num[j+1])
			{
				int tmp = num[j];
				num[j] = num[j + 1];
				num[j + 1] = tmp;
			}
		}
	}

	cout << num;
}
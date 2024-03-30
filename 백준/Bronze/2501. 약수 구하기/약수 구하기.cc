#include <iostream>
using namespace std;

int main()
{
	int num;
	int order;

	cin >> num >> order;

	int cnt = 0;
	int* factorArr = new int[num];

	for (int i = 0; i < num; i++)
	{
		factorArr[i] = 0;
	}

	for (int i = 1; i <= num; i++)
	{
		if (num % i == 0)
		{
			cnt++;

			for (int j = 0; j < num; j++)
			{
				if (factorArr[j] == 0)
				{
					factorArr[j] = i;
					break;
				}
			}
		}
	}

	if (cnt < order)
	{
		cout << 0 << endl;
	}
	else {
		cout << factorArr[order - 1] << endl;
	}

	delete[] factorArr;	
}
#include <iostream>
#include <list>
using namespace std;

int main() {

	while (true)
	{
		list<int> factorList;
		int num;
		cin >> num;

		if (num == -1)
		{
			return 0;
		}

		int sum = 1;
		for (int i = 2; i < num; i++)
		{
			if (num % i == 0)
			{
				factorList.push_back(i);
				sum += i;
			}
		}

		if (num == sum)
		{
			cout << num << " = 1";
			for (int factor : factorList)
			{
				cout << " + " << factor;
			}

			cout << endl;

		} else {
			cout << num << " is NOT perfect." << endl;
		}
	}
}
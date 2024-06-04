#include <iostream>
using namespace std;

int main() {
	
	int left = 0;
	int max = 0;

	for (int i = 0; i < 4; i++)
	{
		int out, in;
		cin >> out >> in;

		left += in - out;

		if (left >= max)
		{
			max = left;
		}
	}

	cout << max << endl;
}
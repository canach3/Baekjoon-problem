#include <iostream>
using namespace std;

int main() {
	int arr[9][9];
	int maxNum = 0;
	int maxNumRow = 0;
	int maxNumCol = 0;

	for (int i = 0; i < 9; i++)
	{
		for (int j = 0; j < 9; j++)
		{
			cin >> arr[i][j];

			if (arr[i][j] >= maxNum)
			{
				maxNum = arr[i][j];
				maxNumRow = i + 1;
				maxNumCol = j + 1;
			}
		}
	}

	cout << maxNum << "\n" << maxNumRow << " " << maxNumCol << endl;
}
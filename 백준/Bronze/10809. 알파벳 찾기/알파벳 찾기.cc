#include <iostream>
#include <cstring>

using namespace std;

int main() {
	
	char input[101];
	cin >> input;

	int alpArr[26];
	for (int i = 0; i < sizeof(alpArr) / sizeof(alpArr[0]); i++)
	{
		alpArr[i] = -1;
	}

	for (int i = 0; i < strlen(input); i++)
	{
		for (int j = 0; j < 26; j++)
		{
			if (alpArr[j] != -1)
			{
				continue;
			}

			else if (((int)input[i] - 97) == j)
			{
				alpArr[j] = i;
			}
		}
	}

	for (int i = 0; i < 26; i++)
	{
		cout << alpArr[i] << " ";
	}
}
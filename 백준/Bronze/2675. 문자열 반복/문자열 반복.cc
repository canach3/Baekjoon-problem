#include <iostream>
#include <cstring>

using namespace std;

int main() {
	
	int t;
	cin >> t;

	int n;
	char s[21];


	for (int i = 0; i < t; i++)
	{
		cin >> n >> s;

		for (int j = 0; j < strlen(s); j++)
		{
			for (int k = 0; k < n; k++)
			{
				cout << s[j];
			}
		}
		cout << endl;
	}

}
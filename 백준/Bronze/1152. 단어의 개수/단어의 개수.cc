#include <iostream>
#include <string>

using namespace std;

int main() {
	
	string s;
	getline(cin, s);

	int cnt = 1;

	for (int i = 0; i < s.length(); i++)
	{
		if ((int)s[i] == 32)
		{
			cnt += 1;
		}

	}
	
	if ((int)s[0] == 32)
	{
		cnt -= 1;
	}

	if ((int)s[s.length() - 1] == 32)
	{
		cnt -= 1;
	}

	cout << cnt;
}
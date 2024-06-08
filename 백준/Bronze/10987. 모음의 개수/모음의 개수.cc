#include <iostream>
using namespace std;

int main() {
	int vowel = 0;

	string str;
	cin >> str;

	for (int i = 0; i < str.length(); i++)
	{
		switch (str[i])
		{
			case 'a':
				vowel++;
				break;
			case 'e':
				vowel++;
				break;
			case 'i':
				vowel++;
				break;
			case 'o':
				vowel++;
				break;
			case 'u':
				vowel++;
				break;
		}
	}

	cout << vowel << endl;
}
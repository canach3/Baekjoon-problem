#include <iostream>
#include <string>
using namespace std;

int main() {
	
	string word;
	cin >> word;

	bool ispalindorme = true;

	for (int i = 0; i < word.length() / 2; i++)
	{
		if (word[i] != word[word.length() - 1 - i])
		{
			ispalindorme = false;
			break;
		}
	}

	if (ispalindorme)
	{
		cout << 1 << endl;
	}
	else {
		cout << 0 << endl;
	}
	
}
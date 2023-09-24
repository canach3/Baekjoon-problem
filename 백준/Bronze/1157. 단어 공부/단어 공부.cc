#include <iostream>
#include <cstring>
using namespace std;

int main() {

	string word;
	cin >> word;

	for (int i = 0; i < word.length(); i++)
	{
		word[i] = toupper(word[i]);
	}

	int alphabet[26] = { 0 };

	for (int i = 0; i < word.length(); i++)
	{
		for (int j = 0; j < 26; j++)
		{
			if ((int)(word[i] - 65) == j)
			{
				alphabet[j] += 1;
			}
		}
	}

	int max = 0;
	int maxidx;

	for (int i = 0; i < 26; i++)
	{
		if (alphabet[i] > max)
		{
			max = alphabet[i];
			maxidx = i;
		}
	}

	bool dupli = false;

	for (int i = maxidx + 1; i < 26; i++)
	{
		if (alphabet[i] == max)
		{
			cout << "?" << endl;
			dupli = true;
			break;
		}
		
	}

	if (!dupli)
	{
		cout << (char)(maxidx + 65) << endl;
	}
}
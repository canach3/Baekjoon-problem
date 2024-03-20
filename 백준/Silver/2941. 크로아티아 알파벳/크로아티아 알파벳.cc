# include <iostream>
using namespace std;

int main() {
	string s;
	cin >> s;

	int count = 0;

	for (int i = 0; i < s.length(); i++)
	{
		if (i < s.length() - 2)
		{
			if (s[i] == 'd' && s[i + 1] == 'z' && s[i + 2] == '=')
			{
				i += 2;
			}
		}

		if (i < s.length() - 1)
		{
			if (s[i] == 'c' && (s[i + 1] == '=' || s[i + 1] == '-'))
			{
				i++;
			}

			if (s[i] == 'd' && s[i + 1] == '-')
			{
				i++;
			}

			if (s[i] == 'l' && s[i + 1] == 'j')
			{
				i++;
			}

			if (s[i] == 'n' && s[ i + 1] == 'j')
			{
				i++;
			}
			
			if ((s[i] == 's' || s[i] == 'z') && s[i + 1] == '=')
			{
				i++;
			}
		}
		count++;
	}

	cout << count << endl;
}
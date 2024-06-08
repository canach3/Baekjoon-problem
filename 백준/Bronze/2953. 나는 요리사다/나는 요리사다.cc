#include <iostream>
using namespace std;

int main() {
	int winner;
	int winnersScore = 0;

	int sum = 0;
	for (int i = 0; i < 5; i++)
	{
		int score1;
		int score2;
		int score3;
		int score4;

		cin >> score1 >> score2 >> score3 >> score4;

		sum = score1 + score2 + score3 + score4;

		if (sum > winnersScore)
		{
			winnersScore = sum;
			winner = i + 1;
		}
	}

	cout << winner << " " << winnersScore << endl;
}
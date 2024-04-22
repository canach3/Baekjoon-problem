#include <iostream>
#include <string>
using namespace std;

string WB[8] = {
	"WBWBWBWB",
	"BWBWBWBW",
	"WBWBWBWB",
	"BWBWBWBW",
	"WBWBWBWB",
	"BWBWBWBW",
	"WBWBWBWB",
	"BWBWBWBW" };

string BW[8] = {
	"BWBWBWBW",
	"WBWBWBWB",
	"BWBWBWBW",
	"WBWBWBWB",
	"BWBWBWBW",
	"WBWBWBWB",
	"BWBWBWBW",
	"WBWBWBWB" };

int cntWB(string* board, int x, int y);
int cntBW(string* board, int x, int y);

int main() {

	int rows;
	int cols;
	cin >> rows >> cols;
	cin.ignore();

	string* board = new string[rows];
	for (int i = 0; i < rows; i++)
	{
		getline(cin, board[i]);
	}


	int minCnt = 64;
	for (int i = 0; i <= rows - 8; i++)
	{
		for (int j = 0; j <= cols - 8; j++)
		{
			if (minCnt >= min(cntWB(board, i, j), cntBW(board, i, j)))
			{
				minCnt = min(cntWB(board, i, j), cntBW(board, i, j));
			}
		}
	}
	cout << minCnt << endl;
}

int cntWB(string* board, int x, int y) {
	int cnt = 0;
	for (int i = 0; i < 8; i++)
	{
		for (int j = 0; j < 8; j++)
		{
			if (board[x + i][y + j] != WB[i][j])
			{
				cnt++;
			}
		}
	}
	return cnt;
}

int cntBW(string* board, int x, int y) {
	int cnt = 0;
	for (int i = 0; i < 8; i++)
	{
		for (int j = 0; j < 8; j++)
		{
			if (board[x + i][y + j] != BW[i][j])
			{
				cnt++;
			}
		}
	}
	return cnt;
}
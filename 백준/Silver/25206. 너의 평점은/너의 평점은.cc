#include <iostream>
using namespace std;

int main() {
	string subjectName;
	double credit;
	string grade;
	double totalScore = 0;
	double totalCredit = 0;

	for (int i = 0; i < 20; i++)
	{
		cin >> subjectName >> credit >> grade;

		totalCredit += credit;

		if (grade == "A+") totalScore += credit * 4.5;
		else if (grade == "A0") totalScore += credit * 4.0;
		else if (grade == "B+") totalScore += credit * 3.5;
		else if (grade == "B0") totalScore += credit * 3.0;
		else if (grade == "C+") totalScore += credit * 2.5;
		else if (grade == "C0") totalScore += credit * 2.0;
		else if (grade == "D+") totalScore += credit * 1.5;
		else if (grade == "D0") totalScore += credit * 1.0;
		else if (grade == "F") totalScore += credit * 0.0;
		else if (grade == "P")
		{
			totalCredit -= credit;
		}
	}
	cout << totalScore / totalCredit;
}
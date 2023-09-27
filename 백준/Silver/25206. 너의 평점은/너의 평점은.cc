#include <iostream>
#include <iomanip>
using namespace std;

int main() {
	
	string subject;
	string grade;
	double credit;
	double creditSum = 0;
	double sum = 0;
	
	
	
	for (int i = 0; i < 20; i++)
	{
		cin >> subject >> credit >> grade;

		if (grade == "P")
		{
			continue;
		}

		creditSum += credit;

		if (grade == "A+")
		{
			sum += credit * 4.5;
		}
		else if (grade == "A0") {
			sum += credit * 4.0;
			
		}
		else if (grade == "B+") {
			sum += credit * 3.5;
			
		}
		else if (grade == "B0") {
			sum += credit * 3.0;
			
		}
		else if (grade == "C+") {
			sum += credit * 2.5;
			
		}
		else if (grade == "C0") {
			sum += credit * 2.0;
			
		}
		else if (grade == "D+") {
			sum += credit * 1.5;
			
		}
		else if (grade == "D0") {
			sum += credit * 1.0;
		
		}
		else if (grade == "F") {
			sum += credit * 0.0;
			
		}
	}
	cout << fixed << setprecision(6);
	cout << sum / creditSum << endl;
}

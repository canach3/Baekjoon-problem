#include <iostream>
#include <string>
using namespace std;

int main() {
    int cnt = 0;
    int n;
    
    cin >> n;

    string word;

    for (int i = 0; i < n; i++)
    {
        int alphabet[26] = {0};
        bool isGroupWord = true;
        cin >> word;

        if (word.length() == 1)
        {
            cnt++;
            continue;
        }
        else 
        {
            for (int j = 1; j < word.length(); j++)
            {
                if (word[j] != word[j - 1])
                {
                    if (alphabet[word[j] - 97] == 1)
                    {
                        isGroupWord = false;
                        break;
                    }
                    else {
                        alphabet[word[j - 1] - 97] = 1;
                    }
                }
            }            
        }
        if (isGroupWord) {
            cnt++;
        }
    }
    cout << cnt << endl;
}

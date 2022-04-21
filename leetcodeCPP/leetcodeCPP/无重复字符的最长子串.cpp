#include<iostream>
#include<unordered_map>
using namespace std;


int lengthOfLongestSubstring(string s) {
    if (s.length() == 0)
        return 0;
    unordered_map<char, int> hashTable;
    int maxLength = 0;
    int currentLength = 0;
    int startIndex = 0;

    //遍历
    for (int i = 0; i < s.length(); i++) {
        if (hashTable.find(s[i]) == hashTable.end()) {
            //没有出现过
            currentLength++;
            hashTable[s[i]] = i;
        }
        else {
            //出现过字符，收缩
            if (currentLength > maxLength)
                maxLength = currentLength;
            startIndex = max(startIndex, hashTable[s[i]]);
            currentLength = i - startIndex;
            hashTable[s[i]] = i;
        }
    }
    if (currentLength > maxLength)
        maxLength = currentLength;
    return maxLength;

}

int main() {
    string s = "sssssaakksksa";
    cout << lengthOfLongestSubstring(s);
    return 0;
}
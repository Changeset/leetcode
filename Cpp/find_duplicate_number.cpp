//
// Created by Xuelong Liao on 16:36 2018/5/15.
//
#include <iostream>
#include <vector>
#include <string>
using namespace std;

class Solution {
public:
    int findDupNum(vector<int> &num) {
        if (num.size() > 1) {
            int slow = num[0], fast = num[0];
            fast = num[num[fast]];
            while (fast != slow) {
                slow = num[slow];
                fast = num[num[fast]];
            }
            fast = 0;
            while (slow != fast) {
                fast = num[fast];
                slow = num[slow];
            }
            return slow;
        }
        return -1;
    }
};


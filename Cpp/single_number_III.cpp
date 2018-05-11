class Solution {
public:
    vector<int> singleNumber(vector<int>& nums) {
        vector<int> res = {0, 0};
        int diff = accumulate(nums.begin(), nums.end(), 0, bit_xor<int>());
        diff &= -diff;
        for (int num : nums) {
            if ((num & diff) == 0)
                res[0] ^= num;
            else res[1] ^= num;
        }
        return res;
    }
};
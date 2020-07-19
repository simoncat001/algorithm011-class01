class Solution {
    public boolean lemonadeChange(int[] bills) {
        int five = 0;
        int ten = 0;
        int twenty = 0;
        for (int i = 0; i < bills.length; i++) {
            int cur = bills[i];
            if (cur == 5) {
                five++;
            } else if (cur == 10) {
                if (five == 0) {
                    return false;
                } else {
                    ten++;
                    five--;
                }
            } else if (cur == 20) {
                if (ten == 0) {
                    if (five < 3) {
                        return false;
                    } else {
                        five -= 3;
                    }
                } else {
                    if (five == 0) {
                        return false;
                    } else {
                        ten--;
                        five--;
                    }
                }
                twenty++;
            }
        }
        return true;
    }
}
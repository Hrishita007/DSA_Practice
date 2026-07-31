package Arrays.Greedy;
//lemonade-change(vending-machine)
//time complexity: O(n)
//space complexity: O(1)
class leetcode860 {
    public boolean lemonadeChange(int[] bills) {
        int five = 0;
    int ten = 0;

    for (int bill : bills) {

        if (bill == 5) {
            five++;
        }

        else if (bill == 10) {

            if (five == 0)
                return false;

            five--;
            ten++;
        }

        else { 

            if (ten > 0 && five > 0) {
                ten--;
                five--;
            }
            else if (five >= 3) {
                five -= 3;
            }
            else {
                return false;
            }
        }
    }

    return true;
    }
    public static void main(String[] args) {
        leetcode860 solution = new leetcode860();
        int[] bills = {5, 5, 5, 10, 20};
        System.out.println("Can provide change: " + solution.lemonadeChange(bills));
    }
}



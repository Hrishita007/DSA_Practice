//Given two integer arrays gas and cost, return the starting gas 
// station's index if you can travel around the circuit once in the clockwise direction, 
// otherwise return -1. If there exists a solution, it is guaranteed to be unique
class leetcode134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalgas=0; int totalcost=0;
        for(int i=0;i<gas.length;i++){
            totalgas+=gas[i];
            totalcost+=cost[i];           
        }
        if(totalgas<totalcost) return -1;

        int start=0;int current=0; 
        for(int i=0;i<gas.length;i++){
            current+=gas[i]-cost[i];
            if(current<0){
                current=0;
                start=i+1;
            }
        }
        return start;        
    }
    piblic static void main(String[] args) {
        leetcode134 solution = new leetcode134();
        int[] gas = {1,2,3,4,5};
        int[] cost = {3,4,5,1,2};
        int startIndex = solution.canCompleteCircuit(gas, cost);
        System.out.println("Starting Gas Station Index: " + startIndex); // Output: 3
    }
}
/*
 * There are n gas stations along a circular route, where the amount of gas at the ith station is gas[i].
 * You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from the ith station to its next (i + 1)th station. You begin the journey with an empty tank at one of the gas stations.
 * Given two integer arrays gas and cost, return the starting gas station's index if you can travel around the circuit once in the clockwise direction, otherwise return -1. If there exists a solution, it is guaranteed to be unique
 * Constraints:
 *      n == gas.length == cost.length
 *      1 <= n <= 10^5
 *      0 <= gas[i], cost[i] <= 10^4
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int index = 0;
        int remainingGas = 0;
        // The last index needs to be checked so that is why it's excluded
        for(int i = 0; i < gas.length - 1; i++) {
            remainingGas += gas[i] - cost[i];
            // if the gas reaches 0 then we reset the remainingGas and index
            if(remainingGas <= 0) {
                remainingGas = 0;
                index = -1;
            // the first time the gas is above 0, that is our starting index
            } else if(index == -1) {
                index = i;
            }
        }
        // check the last index
        remainingGas += gas[gas.length - 1] - cost[cost.length - 1];
        // if we have achieved a full circle
        if(index == 0 && remainingGas >= 0)
            return 0;
        // if we ran out of gas and did not achieve a full circle
        else if(remainingGas <= 0)
            return -1;
        // if we have gas but no index, we will try a full circle starting from the end (last index)
        else if(index == -1)
            index = gas.length - 1;
        // continue until you reach the index
        for(int i = 0; i < index; i++) {
            remainingGas += gas[i] - cost[i];
            // if you run out of gas before getting to the index, their is no solution
            if(remainingGas < 0) {
                index = -1;
                break;
            }
        }
        // solution was found
        return index;
    }
}
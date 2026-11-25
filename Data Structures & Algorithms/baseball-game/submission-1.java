class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> stack = new Stack<>();
        int prev = 0;
        int prevPrev = 0;

        for(String operation : operations) {
            if("+".equals(operation)) {
                int top = stack.pop();
                int newScore = top + stack.peek();
                stack.push(top);
                stack.push(newScore);
            } else if("C".equals(operation)) {
                stack.pop();
            } else if("D".equals(operation)) {
                stack.push(stack.peek() * 2);
            } else {
                int v = Integer.parseInt(operation);

                stack.push(v);
            }
        }
        int result = 0;
        while(stack.size() != 0) {
            result += stack.pop();
        }
        return result;
    }
}
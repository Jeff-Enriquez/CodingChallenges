import java.io.*;
import java.util.*;
import java.util.stream.*;
// https://www.hackerrank.com/challenges/simple-text-editor/problem
public class SimpleTextEditor {
	
    /*
     * Time Complexity: O(n)
     * Space Complexity: O(s)
     *      n = number of input operations
     *      s = total text length of input operations
     */
	static class TextEditor {
		int opTask;
		Stack<Operation> prevOperations = new Stack<>();
		List<Character> print = new ArrayList<>();
		StringBuilder str = new StringBuilder();
		
		public TextEditor(List<Operation> operations) {
	        for(Operation op : operations)
	        	if(op.opTask() == 1)
	        		addText(op.objString());
	        	else if(op.opTask() == 2)
	        		deleteText(op.objInteger());
	        	else if(op.opTask() == 3)
	        		print(op.objInteger());
	        	else
	        		undo();
		}
		
		public void addText(String s) {
    		int k = s.length();
    		str.append(s);
    		prevOperations.push(new Operation(2, k));
		}
		
		public void deleteText(int k) {
			int idx = str.length() - k;
    		String deleted = str.substring(idx, str.length());
    		str.delete(idx, str.length());
    		prevOperations.push(new Operation(1, deleted));
		}
		
		public void print(int k) {
			print.add(str.charAt(k-1));
		}
		
		public void undo() {
			Operation op = prevOperations.pop();
			if(op.opTask() == 1) {
				addText(op.objString());
				prevOperations.pop();
			} else {
				deleteText(op.objInteger());
				prevOperations.pop();
			}
		}
		
		public List<Character> getPrint() {
			return new ArrayList<>(print);
		}
		
	}
	
	static class Operation {
		int opTask;
		Object obj;
		Operation(int opTask, Object obj) {
			this.opTask = opTask;
			this.obj = obj;
		}
		public int opTask() {
			return opTask;
		}
		public String objString() {
			return obj.toString();
		}
		public Integer objInteger() {
			return Integer.valueOf(obj.toString());
		}
	}
	
	public static void main(String[] args) throws IOException {
        List<Operation> operations = new ArrayList<>();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        int q = Integer.parseInt(bufferedReader.readLine().trim());
        IntStream.range(0, q).forEach(tItr -> {
            try {
                String line = bufferedReader.readLine().trim();
                int opTask;
                Object obj = null;
                if(line.contains(" ")){
                	opTask = Integer.valueOf(line.split(" ")[0]);
                    obj = line.split(" ")[1];
                } else {
                	opTask = Integer.valueOf(line);
                }
                operations.add(new Operation(opTask, obj));
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
        TextEditor textEditor = new TextEditor(operations);
        List<Character> results = textEditor.getPrint();
        bufferedWriter.write(
            results.stream()
                .map(n -> n.toString() + "\n")
                .collect(Collectors.joining(""))
        );
        bufferedReader.close();
        bufferedWriter.close();
    }
}

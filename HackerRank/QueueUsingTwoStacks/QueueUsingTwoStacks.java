import java.io.*;
import java.util.*;
import java.util.stream.*;
// https://www.hackerrank.com/challenges/queue-using-two-stacks/problem
public class QueueUsingTwoStacks {
	
	/* 
	 * Time Complexity: O(q)
	 * Space Complexity: O(q)
	 * 		q = number of queries
	 */
	public static List<Integer> queueUsingTwoStacks(List<List<Integer>> queries) {
		List<Integer> result = new ArrayList<>();
        Queue queue = new Queue();
        for(int i = 0; i < queries.size(); i++) {
        	List<Integer> query = queries.get(i);
        	if(query.get(0).equals(1))
        		queue.enqueue(query.get(1));
        	else if(query.get(0).equals(2))
        		queue.dequeue();
        	else
        		result.add(queue.headData());
        }
        return result;
    }
	
	static class Queue {
		QueueNode head;
		QueueNode tail;
		public Integer headData() {
			return head.data;
		}
		public void enqueue(int data) {
			QueueNode node = new QueueNode(data);
			if(head == null) {
				head = node;
				return;
			}
			if(tail == null) {
				head.next = node;
				tail = node;
				return;
			}
			tail.next = node;
			tail = node;
		}
		public Integer dequeue() {
			if(head == null)
				return null;
			QueueNode prev = head;
			head = head.next;
			if(head == tail)
				tail = null;
			return prev.data;
		}
		static class QueueNode {
			int data;
			QueueNode next;
			QueueNode(int data) {
				this.data = data;
			}
		}
	}
	
	/* FOR HACKERRANK ONLY */ /*
    public static void main(String[] args) throws IOException {
        List<List<Integer>> queries = new ArrayList<>();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        int q = Integer.parseInt(bufferedReader.readLine().trim());
        IntStream.range(0, q).forEach(tItr -> {
            try {
                String line = bufferedReader.readLine().trim();
                Integer num = null;
                int query = -1;
                if(line.contains(" ")){
                    query = Integer.valueOf(line.split(" ")[0]);
                    num = Integer.valueOf(line.split(" ")[1]);
                } else {
                    query = Integer.valueOf(line);
                }
                queries.add(new ArrayList<>(Arrays.asList(query, num)));
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
        List<Integer> result = queueUsingTwoStacks(queries);
        bufferedWriter.write(
            result.stream()
	            .map(n -> n.toString() + "\n")
	            .collect(Collectors.joining(""))
        );
        bufferedReader.close();
        bufferedWriter.close();
    } */
	
}

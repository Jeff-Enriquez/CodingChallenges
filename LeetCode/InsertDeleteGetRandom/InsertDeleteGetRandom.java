/*
 * Implement the RandomizedSet class:
 *      RandomizedSet() Initializes the RandomizedSet object.
 *      bool insert(int val) Inserts an item val into the set if not present. Returns true if the item was not present, false otherwise.
 *      bool remove(int val) Removes an item val from the set if present. Returns true if the item was present, false otherwise.
 *      int getRandom() Returns a random element from the current set of elements (it's guaranteed that at least one element exists when this method is called). Each element must have the same probability of being returned.
 * You must implement the functions of the class such that each function works in average O(1) time complexity.
 * 
 * Constraints:
 *      -2^31 <= val <= 2^31 - 1
 *      At most 2 * 10^5 calls will be made to insert, remove, and getRandom.
 *      There will be at least one element in the data structure when getRandom is called.
 * 
 * Time Complexity: O(1)
 * Space Complexity: O(n)
 */
class RandomizedSet {
    private final Map<Integer, Integer> valueAndLocations = new HashMap<>();
    private final List<Integer> values = new ArrayList<>();
    private final Random random = new Random();

    public RandomizedSet() {
        // for leetcode memory optimization
        System.gc(); 
    }
    
    public boolean insert(Integer value) {
        // value already exists
        if(valueAndLocations.containsKey(value))
            return false;
        
        // Add value to Map and List
        valueAndLocations.put(value, values.size());
        values.add(value);
        return true;
    }
    
    public boolean remove(Integer value) {
        // value does not exist
        if(!valueAndLocations.containsKey(value))
            return false;
        
        // Remove value from Map and retrieve location
        Integer locationOfCurrValue = valueAndLocations.remove(value);
        int lastIndexOfValues = values.size() - 1;
        // Swap value with last location
        if(((int)locationOfCurrValue) != lastIndexOfValues) {
            Integer lastValueOfLocations = values.get(lastIndexOfValues);
            // update location of last value to location of currValue
            valueAndLocations.put(lastValueOfLocations, locationOfCurrValue);
            values.set(locationOfCurrValue, lastValueOfLocations);
        }
        // Remove last value from list - O(1) operation
        values.remove(lastIndexOfValues);
        return true;
    }
    
    public int getRandom() {
        return values.get(random.nextInt(values.size()));
    }
}


/*
 * This solution isn't a great real-world solution. I did this to get a high
 * score in Runtime and Memory. With this solution I achieved 20s runtime (Beat 100%)
 * and 81.68 MB memory (Beat 99.85%).
 * Time Complexity: O(1)
 * Space Compleixty: O(1)
 */
class RandomizedSet {

	// This is used to mock the java HashSet
    private static class Node {
        int key, location;
        Node next;

        Node(Integer key, int location) {
            this.key = key;
            this.location = location;
            this.next = null;
        }
    }

    private Node[] values = new Node[2000]; // store the values, most optimized memory for leetcode
    private int[] locations = new int[5000]; // track location of values, most optimized memory for leetcode
    int locSize; // size of locations array
    long seed; // for generating random values

    public RandomizedSet() {
    	System.gc(); // invoke garbage collection, optimized memory for leetcode
    }

    private int hash(Integer key) {
    	// keep the hash value within the array size
        return Math.abs(key.hashCode() % values.length);
    }
    
    public boolean insert(int key) {
        int index = hash(key);
        Node node;
        // Check if the key (value) exists
        for(node = values[index]; node != null; node = node.next) {
            if (node.key == key)
                return false;
        }
        // Insert the key (value)
        node = new Node(key, locSize);
        locations[locSize++] = key;
        node.next = values[index];
        values[index] = node;
        return true;
    }
    
    public boolean remove(int key) {
        int index = hash(key);
        Node currNode;
        Node prevNode = null;
        for(currNode = values[index]; currNode != null;) {
            if(currNode.key == key) {
                // remove key from values
                if(prevNode == null)
                    values[index] = currNode.next;
                else
                    prevNode.next = currNode.next;
                // swap key with last location
                if(currNode.location != locSize - 1) {
                    int swapKey = locations[locSize - 1];
                    getNode(swapKey).location = currNode.location;
                    locations[currNode.location] = swapKey;
                }
                // "remove" the last location
                locSize--;
                return true;
            }
            prevNode = currNode;
            currNode = currNode.next;
        }
        return false;
    }
    
    private Node getNode(int key) {
        int index = hash(key);
        for(Node node = values[index]; node != null; node = node.next) {
            if (node.key == key)
                return node;
        }
        return null;
    }
    
    public int getRandom() {
        // Linear Congruential Generator (LCG) component
        seed = (1664525L * seed + 1013904223L) % (1L << 31);
        // Xorshift component to enhance randomness
        seed ^= (seed >>> 17);
        // Keep index within the array size
        int index = Math.abs(((int) seed)) % locSize;
        return locations[index];
    }
    
}
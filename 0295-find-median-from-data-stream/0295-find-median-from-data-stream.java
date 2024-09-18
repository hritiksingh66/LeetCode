class MedianFinder {

    private PriorityQueue<Integer> maxHeap; // max heap --> left part store karne ke liye
    private PriorityQueue<Integer> minHeap; // min heap --> right part elements store karne ke liye

    public MedianFinder() {

        maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer n1, Integer n2) {
                return n2 - n1;
            }
        });

        

        minHeap = new PriorityQueue<>(new Comparator<Integer>(){
            @Override
            public int compare(Integer n1, Integer n2) {
                return n1 - n2;
            }
        });

    }

    public void addNum(int num) {
        if (maxHeap.isEmpty() || num < maxHeap.peek()) {
            maxHeap.add(num);
        } else {
            minHeap.add(num);
        }

        // maxHeap ka size ya toh hmesha minHeap ke size se greater hoga ya equal hoga
        // odd number of elements ke case me greater hogi maxHeap ki size minHeap ke
        // size se
        // even number of elements ke case me dono equal hoga
        // maitain karna padega ye

        if (Math.abs(maxHeap.size() - minHeap.size()) > 1) {
            minHeap.add(maxHeap.poll());
        } else if (maxHeap.size() < minHeap.size()) {
            maxHeap.add(minHeap.poll());
        }

    }

    public double findMedian() {
        // Even number of elements ke case ho to max aur mean ka top element poll
        // karke add karenge phir uska median find karlenge
        if (minHeap.size() == maxHeap.size()) {

            return (double) (maxHeap.peek() + minHeap.peek()) / 2;
        }

        // nahi toh odd number ke case me maxHeap ka top element hi hmara answer hoga

        return (double) maxHeap.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
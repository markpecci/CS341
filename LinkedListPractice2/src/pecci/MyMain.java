//package pecci;
//
//public class MyMain {
//
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		Queue q = new Queue();
//
//
//		
//		//test 1: check to see if queue is empty upon start
//		if(!q.isEmpty()) {
//			System.out.println("Failure: queue is not empty at construction");
//			return;
//		}
//		//test 2: try to dequeue an empty queue
//		int value;
//		try {
//			value = q.dequeue();
//		} catch(Exception e){
//			System.out.println("Failure: an empty queue cannot be dequeued");
//			return;
//		}
//		//test 3: after dequeue, an empty queue results in null head
//		if(q.getHead() != null) {
//			System.out.println("Failure: an empty queue should result in head is null");
//			return;
//		}
//		//test 4: test enqueued single node is pointed to by head
//		q.enqueue(1);
//		if(q.getHead().n != 1) {
//			System.out.println("Failure: node should be pointed to by head");
//			return;
//		}
//		//test 5: test dequeued single node is pointed to by tail
//		value = q.dequeue();
//		if(q.getHead() != null) {
//			System.out.println("Failure: a dequeued single node must reposition head to null");
//			return;
//		}
//		System.out.println("Success");
//	}
//
//}

import java.util.*;

/**
 * Event Manager using Max Heap + HashMap
 *
 * Supports:
 * - Update priority
 * - Get highest priority event
 *
 * Approach:
 * - Max Heap for priority ordering
 * - HashMap for latest valid state
 * - Lazy deletion to ignore stale entries
 *
 * Time Complexity:
 * - update: O(log n)
 * - poll: O(log n) amortized
 */
public class EventManager {

    private static class Event {
        int id;
        int priority;

        Event(int id, int priority) {
            this.id = id;
            this.priority = priority;
        }
    }

    private Map<Integer, Integer> eventToPriority;
    private PriorityQueue<Event> maxHeap;

    public EventManager(int[][] events) {
        eventToPriority = new HashMap<>();

        maxHeap = new PriorityQueue<>((a, b) -> {
            if (b.priority != a.priority) return b.priority - a.priority;
            return a.id - b.id;
        });

        for (int[] e : events) {
            int id = e[0], priority = e[1];
            eventToPriority.put(id, priority);
            maxHeap.offer(new Event(id, priority));
        }
    }

    public void updatePriority(int eventId, int newPriority) {
        eventToPriority.put(eventId, newPriority);
        maxHeap.offer(new Event(eventId, newPriority));
    }

    public int pollHighest() {
        while (!maxHeap.isEmpty()) {
            Event top = maxHeap.poll();

            if (eventToPriority.containsKey(top.id) &&
                    eventToPriority.get(top.id) == top.priority) {

                eventToPriority.remove(top.id);
                return top.id;
            }
        }
        return -1;
    }
}
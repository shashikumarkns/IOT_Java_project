class SmartTimetable {

    String[] subjects = {"Math", "Physics", "Chemistry"};
    String[] teachers = {"A", "B", "A"};
    String[] rooms = {"R1", "R2", "R1"};
    int n = subjects.length;

    int[] slots = new int[n];
    int totalSlots = 3;

    boolean isSafe(int curr) {
        for (int i = 0; i < curr; i++) {
            if (slots[i] == slots[curr]) {
                if (teachers[i].equals(teachers[curr]) ||
                        rooms[i].equals(rooms[curr])) {
                    return false;
                }
            }
        }
        return true;
    }

    boolean assignSlot(int curr) {
        if (curr == n) {
            printTimetable();
            return true;
        }

        for (int s = 1; s <= totalSlots; s++) {
            slots[curr] = s;

            if (isSafe(curr)) {
                if (assignSlot(curr + 1)) {
                    return true;
                }
            }
        }

        return false;
    }

    void generateTimetable() {
        if (!assignSlot(0)) {
            System.out.println("No valid timetable found");
        }
    }

    void printTimetable() {
        System.out.println("Generated Timetable:");
        for (int i = 0; i < n; i++) {
            System.out.println(subjects[i] +
                    " -> Slot " + slots[i] +
                    ", Teacher " + teachers[i] +
                    ", Room " + rooms[i]);
        }
    }

    public static void main(String[] args) {
        SmartTimetable obj = new SmartTimetable();
        obj.generateTimetable();
    }
}
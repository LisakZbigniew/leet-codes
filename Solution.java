class Solution {
    int[] positions;
    int[] healths;
    String directions;

    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        List<Robot> robots = new ArrayList<>();

        for (int i = 1; i <= positions.length; i++) {
            robots.add(new Robot(
                    positions[i - 1],
                    healths[i - 1],
                    directions.charAt(i - 1),
                    i));
        }
        robots.sort((x, y) -> Integer.compare(x.position, y.position));

        Stack<Robot> remaining = new Stack<>();

        for (Robot r : robots) {
            if (r.direction == 'R') {
                remaining.push(r);
            } else {
                while (!remaining.empty() && r.health != -1) {
                    Robot incoming = remaining.peek();
                    if (incoming.health < r.health) {
                        incoming.health = -1;
                        remaining.pop();
                        r.health -= 1;
                    } else if (incoming.health > r.health) {
                        r.health = -1;
                        incoming.health -= 1;
                    } else {
                        incoming.health = -1;
                        r.health = -1;
                        remaining.pop();
                    }
                }
            }
        }

        robots.sort((x, y) -> Integer.compare(x.index, y.index));
        List<Integer> remainingHealths = new ArrayList<>();
        for (Robot r : robots) {
            if (r.health != -1) {
                remainingHealths.add(r.health);
            }
        }

        return remainingHealths;
    }

    class Robot {

        int position;
        int health;
        char direction;
        int index;

        public Robot(int position, int health, char direction, int index) {
            this.position = position;
            this.health = health;
            this.index = index;
            this.direction = direction;
        }
    }
}
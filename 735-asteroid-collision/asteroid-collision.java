class Solution {
    public int[] asteroidCollision(int[] asteroids) {

        List<Integer> list = new ArrayList<>();
        for (int asteroid : asteroids) {
            boolean destroyed = false;

            // Check whether a collision is possible
            while (!list.isEmpty()
                    && list.get(list.size() - 1) > 0
                    && asteroid < 0) {

                int top = list.get(list.size() - 1);

                // Case 1: Current asteroid is larger
                if (Math.abs(top) < Math.abs(asteroid)) {
                    list.remove(list.size() - 1);
                }

                // Case 2: Both asteroids have equal magnitude
                else if (Math.abs(top) == Math.abs(asteroid)) {
                    list.remove(list.size() - 1);
                    destroyed = true;
                    break;
                }
                // Case 3: Last asteroid is larger
                else {
                    destroyed = true;
                    break;
                }
            }
            // Add the current asteroid only if it survives
            if (!destroyed) {
                list.add(asteroid);
            }
        }

        // Convert List<Integer> into int[]
        int[] result = new int[list.size()];

        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }
}
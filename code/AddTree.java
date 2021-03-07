/////add the tgenerate tree method in SnakeGamePanel
public class SnakeGamePanel extends JPanel {

    /**
     * when the score is in multiples of 50,add a Tree randomly.
     */
    private boolean isNeedToGenerateNewBarrier() {
        return score != 0 && score % 50 == 0 && needToGenerateBarrie;
    }

    /**
     * if the random picked position has collision with snake or food，return false,otherwise return true
     */
    private boolean isTreeAvailable(int x, int y) {
        for (Grid grid : snake.getList()) {
            if (x == grid.getX() && y == grid.getY()) {
                return false;
            }
        }
        if (food.getX() == x && food.getY() == y) {
            return false;
        }
        return true;
    }

    /**
     * generate a Tree By Random
     */
    private void generateTreeByRandom() {
        Random r = new Random();
        int randomX = r.nextInt(SnakeGameConstant.GRID_COLUMN_NUMBER);
        int randomY = r.nextInt(SnakeGameConstant.GRID_ROW_NUMBER);

        if (isTreeAvailable(randomX, randomY)) {
            Tree.getTreeList().add(
                    new Grid(randomX, randomY, Color.YELLOW));
            // after generated a tree ，mark the needToGenerateBarrie == false
            needToGenerateTree = false;
        } else {
            generateTreeByRandom();
        }
    }

}

//////add the game over condition " snake hit a tree" in Snake Game Panel
public class SnakeGamePanel extends JPanel
{
    private boolean isSnakeHeadTouchTree() {
        Grid head = snake.getList().get(0);
        for (Grid grid : Tree.getTreeList()) {
            if (head.getX() == grid.getX() && head.getY() == grid.getY()) {
                this.gameOverType = GameOverType.TOUCH_TREE;
                return true;
            }
        }

        return false;
    }

    private void judgeGameOver() {
        if (isSnakeHeadTouchEdge() || isSnakeHeadTouchBody()
                || isSnakeHeadTouchTree()) {
            gameState = GameState.OVER;
            int result = JOptionPane.showConfirmDialog(frame,
                    SnakeGameConstant.GAME_OVER, SnakeGameConstant.SNAKE_GAME,
                    JOptionPane.YES_NO_OPTION);
            if (result == JOptionPane.YES_OPTION) {
                for (int i = SnakeGameConstant.LEFT; i <= SnakeGameConstant.RIGHT; i++) {
                    for (int j = SnakeGameConstant.UP; j <= SnakeGameConstant.DOWN; j++) {
                        flag[i][j] = 0;
                    }
                }

                gameState = GameState.RUN;
                score = 0;
                init();
                timer.start();
            } else {
                System.exit(0);
            }
        }
    }
}

/** Design a Snake game that is played on a device with screen size = width x height. Play the game online if you are not familiar with the game.

The snake is initially positioned at the top left corner (0,0) with length = 1 unit.

You are given a list of food's positions in row-column order. When a snake eats the food, its length and the game's score both increase by 1.

Each food appears one by one on the screen. For example, the second food will not appear until the first food was eaten by the snake.

When a food does appear on the screen, it is guaranteed that it will not appear on a block occupied by the snake.

Example:

Given width = 3, height = 2, and food = [[1,2],[0,1]].

Snake snake = new Snake(width, height, food);

Initially the snake appears at position (0,0) and the food at (1,2).

|S| | |
| | |F|

snake.move("R"); -> Returns 0

| |S| |
| | |F|

snake.move("D"); -> Returns 0

| | | |
| |S|F|

snake.move("R"); -> Returns 1 (Snake eats the first food and right after that, the second food appears at (0,1) )

| |F| |
| |S|S|

snake.move("U"); -> Returns 1

| |F|S|
| | |S|

snake.move("L"); -> Returns 2 (Snake eats the second food)

| |S|S|
| | |S|

snake.move("U"); -> Returns -1 (Game over because snake collides with border)

Done by creating a data structure called point, and storing snake and foods in separate linked lists, every move is checked for validity, i.e snake doesn't collide with border or itself
TC- move  -> O(snakeLength)
**/


class SnakeGame {

    class Point{
        int i;
        int j;
        public Point(int i , int j){
            this.i=i;
            this.j=j;
        }

    }

    /** Initialize your data structure here.
     @param width - screen width
     @param height - screen height
     @param food - A list of food positions
     E.g food = [[1,1], [1,0]] means the first food is positioned at [1,1], the second is at [1,0]. */
    List<Point> foods=new LinkedList<>();
    int width;
    int height;
    List<Point> snake=new LinkedList<>();
    public SnakeGame(int width, int height, int[][] food) {
        for(int i=0;i<food.length;i++){
            foods.add(new Point(food[i][0],food[i][1]));
        }
        this.width=width;
        this.height=height;
        snake.add(new Point(0,0));

    }

    /** Moves the snake. 
     @param direction - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down
     @return The game's score after the move. Return -1 if game over.
     Game over when snake crosses the screen boundary or bites its body. */
    public int move(String direction) {
        Point head=snake.get(0);
        if(direction.equals("R")){
            Point nPoint=new Point(head.i,head.j+1);
            return snakeAdjust(nPoint);
        }

        else if(direction.equals("D")){
            Point nPoint=new Point(head.i+1,head.j);
            return snakeAdjust(nPoint);
        }

        else if(direction.equals("L")){
            Point nPoint=new Point(head.i,head.j-1);
            return snakeAdjust(nPoint);
        }

        else {
            Point nPoint=new Point(head.i-1,head.j);
           return snakeAdjust(nPoint);
        }
    }
	/**
	moves the snake , if food is there size is increased, 
	otherwise normal movement of snake
	**/
        public int snakeAdjust(Point nPoint){
            if(!isValid(nPoint))return -1;
            if(foods.size()>0&&PointCompare(foods.get(0),nPoint)){
                foods.remove(0);
                snake.add(0,nPoint);
            }else{
                snake.add(0,nPoint);
                snake.remove(snake.size()-1);
            }
            return snake.size()-1;
        }
    
    /**
    checks if two co-ordinates are equal
    **/
    public boolean PointCompare(Point a, Point b){
        if(a.i==b.i&&a.j==b.j)return true;
        return false;
    }

    
    /**
	checks if given co-ordinates is valid for movement, within border limits
	and snake doesn't eat itself.
	@param - Given new co-ordinate of movement
	**/
    public boolean isValid(Point p){
        if(p.i<this.height && p.j<this.width&&p.i>=0&&p.j>=0){
            for(int i=1;i<snake.size()-1;i++){
                Point body=snake.get(i);
                if(p.i==body.i&&p.j==body.j)return false;
            }
            return true;
        }
        return false;
    }
}

/**
 * Your SnakeGame object will be instantiated and called as such:
 * SnakeGame obj = new SnakeGame(width, height, food);
 * int param_1 = obj.move(direction);
 */


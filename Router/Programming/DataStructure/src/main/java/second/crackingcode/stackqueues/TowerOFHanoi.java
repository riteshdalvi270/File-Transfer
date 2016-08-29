package second.crackingcode.stackqueues;

import java.util.Stack;

/**
 * @author Ritesh Dalvi (RD026600)
 */
public class TowerOFHanoi
{
    Tower[] towers = new Tower[3];

    public void createTowers() {

        int index = 0;

        // create tower.
        for(int i = 0;i<3;i++) {
            Tower tower = new Tower(i);
            towers[i] = tower;
        }

        //Add disk.
        for(int i = 0;i<3; i++) {
            try
            {
                towers[index].add(i);
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
    }

    public class Tower
    {
        Stack<Integer> disk;
        int index;

        public Tower(int i)
        {
            disk = new Stack();
            this.index = i;
        }

        public void add(int i) throws Exception
        {
            // To handle smaller on top.
            if(!disk.isEmpty() && disk.peek() >= i)
            {
                disk.push(i);
            }else {
                throw new Exception("error");
            }
        }

        public void moveTop(Tower destination){

            if(!this.disk.isEmpty()) {
                int top = this.disk.pop();
                destination.disk.push(top);
            }
        }

        public void move(int n, Tower buffer,Tower destination) {
            if(n>0)
            {
                move(n-1,destination,buffer);
                moveTop(destination);
                buffer.move(n-1,destination,this);
            }
        }
    }

}


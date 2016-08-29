package third.careercup.linkedin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Determine if user A following user B.
 * Created by ritesh on 1/9/16.
 */
public class Influencer {

    public static void main(String args[]) {

        boolean followingMatrix[][] = new boolean[5][5];

        followingMatrix[0][3] = true;
        followingMatrix[1][3] = true;
        followingMatrix[2][3] = true;
        followingMatrix[0][4] = true;

        final Follower follower = new Follower();
        System.out.println(follower.getInfluencer(followingMatrix));
    }
}

class Follower {

    public int getInfluencer(boolean followingMatrix[][]) {

        int row = followingMatrix[1].length;
        int column = followingMatrix.length;

        final Map<Integer,List<Boolean>> follower = new HashMap<>();
        for(int i = 0; i<row; i++) {

            if(follower.get(i) == null) {
                List<Boolean> isFollowing = new ArrayList<>();
                follower.put(i,isFollowing);
            }

            for(int j = 0;j<column;j++) {

                if(i ==  j) {
                    continue;
                }

                if(followingMatrix[i][j]) {

                    addToFollowerList(follower,i,false);
                    addToFollowerList(follower,j,true);
                }else {

                    addToFollowerList(follower,i,true);
                    addToFollowerList(follower,j,false);
                }
            }
        }

        for(final Map.Entry<Integer,List<Boolean>> entrySet: follower.entrySet()) {

            int key = entrySet.getKey();

            List<Boolean> values = entrySet.getValue();

            boolean isInfluencer = false;

            for(final Boolean value : values) {

                if(value) {
                    isInfluencer = true;
                }else {
                    isInfluencer = false;
                    break;
                }
            }

            if(isInfluencer) {
                return key;
            }
        }

        return -1;
    }

    public void addToFollowerList(final Map<Integer,List<Boolean>> followers, final int key, final boolean value) {

        if(followers.get(key) == null) {
            List<Boolean> isFollowing = new ArrayList<>();
            isFollowing.add(value);
            followers.put(key,isFollowing);
        } else {
            List<Boolean> isFollowing = followers.get(key);
            isFollowing.add(value);
        }
    }
}
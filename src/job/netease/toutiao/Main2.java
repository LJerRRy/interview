package job.netease.toutiao;

import java.util.*;

/**
 * Created by jerry on 2017/8/22.
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(), m = scanner.nextInt(), p = scanner.nextInt();
        List<idea> ids = new ArrayList<>();
        for (int i = 0; i < p; i++) {
            idea id = new idea(i,scanner.nextInt(), scanner.nextInt(), scanner.nextInt(), scanner.nextInt(), 0);
            ids.add(id);
            id = null;
        }
        if(m>p){
            for (int i = 0; i < p; i++) {
                idea id = ids.get(i);
                System.out.println(id.y+id.q);
            }
            return;
        }
        ids.sort((a,b)->(a.x - b.x));
        ids.sort((a,b)->(a.q - b.q));
        ids.sort((a,b)->(b.z - a.z));
        ids.sort((a,b)->(a.y - b.y));

        int[] cxy = new int[m];
        for (int i = 0; i < m; i++) {
            idea id = ids.get(i);
            cxy[i] = id.y+id.q;
            id.r = cxy[i];
        }
        Arrays.sort(cxy);

        for (int i = m; i < p; i++) {
            idea id = ids.get(i);

//            for (int j = 0; j < m; j++) {
//                if (id.y>=cxy[j]){
//
//                }
//            }
            if (id.y<=cxy[0]){
                cxy[0] = cxy[0]+id.q;
            }else {
                cxy[0] = id.y + id.q;
            }
            id.r = cxy[0];
            Arrays.sort(cxy);
        }
        ids.sort((a,b)->(a.i - b.i));

        for (int i = 0; i < p; i++) {
            idea id = ids.get(i);
            System.out.println(id.r);
        }
    }
}
class idea {
    int i,x, y, z, q, r;

    public idea() {
    }

    /**
     *
     * @param x id
     * @param y 提出时间
     * @param z 优先级
     * @param q 所需时间
     * @param r 最后完成的时间
     */
    public idea(int i,int x, int y, int z, int q, int r) {
        this.i = i;
        this.x = x;
        this.y = y;
        this.z = z;
        this.q = q;
        this.r = r;
    }
}


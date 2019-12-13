//https://onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&page=show_problem&problem=1524
import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
static int TC,n,m;
static int [] union = new int[50001];
    public static void main(String[] args) throws IOException {
	// write your code here
        //sovle in .320 in java
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
        String line ;
        int j=1;
        while ((line = br.readLine())!=null&&!line.equals("0 0")){
            StringTokenizer st = new StringTokenizer(line);
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            //make union
            for (int i=0;i<=n;i++)
                union[i] = i;
            for (int i=0;i<m;i++)
            {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v= Integer.parseInt(st.nextToken());
                unite(u,v);
            }
            pw.write("Case "+j+": "+n+"\n");
            j++;
        }
        pw.flush();
    }
    static int find(int x){
        if(union[x]==x)
            return x;
        else
        {
            union[x] = find(union[x]);
            return union[x];
        }
    }
    static void unite(int x,int y){
        if(find(x)!=find(y)){
            union[find(x)] = find(y);
            n--;
        }
    }
}

class Solution {
    
    // 우-하-좌-상 이동
    private final int[] dx = {1, 0, -1, 0};
    private final int[] dy = {0, 1, 0, -1};
    
    int H, W;
    private String[][] area;
    public int[] solution(String[] park, String[] routes) {
        H = park.length;
        W = park[0].length();
        area = new String[H][W];
        
        int sx = -1;
        int sy = -1;
        
        for(int i=0; i<H; i++) {
            String[] oneLine = park[i].split("");
            for(int j=0; j<W; j++) {
                area[i][j] = oneLine[j];
                if(area[i][j].equals("S")) {
                    sy = i;
                    sx = j;
                } 
            }
        }
        
        for(String command : routes) {
            String[] cBits = command.split(" ", 2);
            int move = -1;
            switch(cBits[0]) {
                case "E":
                    move = 0;
                    break;
                case "S":
                    move = 1;
                    break;
                case "W":
                    move = 2;
                    break;
                case "N":
                    move = 3;
                    break;
                default:
                    break;
            }
            
            int nx=sx;
            int ny=sy;
            boolean isRight = true;
            for(int i=0; i<Integer.parseInt(cBits[1]); i++) {
                nx += dx[move];
                ny += dy[move];
                if(!isIn(ny, nx)) {
                    isRight=false;
                    break;
                }
                if(area[ny][nx].equals("X")) {
                    isRight=false;
                    break;
                }
            }
            if(!isRight) continue;
            sx = nx;
            sy = ny;
        }
        
        
        int[] answer = {sy, sx};
        return answer;
    }
    
    private boolean isIn(int y, int x) {
        return y>=0 && y<H && x>=0 && x<W;
    }
}
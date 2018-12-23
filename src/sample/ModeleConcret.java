package sample;


public class ModeleConcret implements Modele {
    private static String [][] map;//游戏操作的地图
    private static String [][] map2;//游戏操作的地图
    private static int x=0;//玩家当前在数组中的坐标
    private static int y=0;//玩家当前在数组中的坐标



    public void f_alert_informationDialog(String p_header, String p_message){
       
    }

   
     public void chargerNiveau(String [][]mapTmp){

         map2=new String[mapTmp.length][mapTmp[0].length];
         map=new String[mapTmp.length][mapTmp[0].length];

         for(int a=0;a<mapTmp.length;a++){
            for (int b=0;b<mapTmp[a].length;b++){
                map2[a][b]=""+mapTmp[a][b];
            }
         }
         reset();

    }

    public String [][] getEtat() {
        return map;
    }

    public  void afficher(){
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
               // System.out.print(map[i][j]);
            }
           // System.out.println();
        }
    }

    public String move(String direction) {
        int f=0;
        int fb=0;
        switch (direction) {
        //TODO
            case "u":
                //通道和目标点
                if (map[x - 1][y].equals(" ")  || map[x - 1][y].equals(".") ) {
                    if(map[x-1][y].equals(".")){
                        f=1;
                    }
                    //1.将玩家当前位置还原
                    if (map2[x][y].equals(".") ){
                        map[x][y] = ".";
                    } else {
                        map[x][y] = " ";
                    }
                    //3.将玩家移动过去
                    if (f==1){
                        map[x - 1][y] = "+";
                    }else {
                        map[x - 1][y] = "@";
                    }
                    //4.记录玩家的当前坐标
                    x -= 1;
                    break;
                }
                //如果是箱子
                if (map[x - 1][y].equals("$")||map[x - 1][y].equals("*")) {
                    //继续判断箱子的上边
                    //如果是通道或目标点
                    if (map[x - 2][y].equals(" ") || map[x - 2][y].equals(".") ){
                        if(map[x - 1 - 1][y].equals(".")){
                            fb=0;
                        }
                        //移动玩家
                        if (map2[x][y].equals(".")) {
                            map[x][y] = ".";
                        } else {
                            map[x][y] = " ";
                        }
                        //3.将玩家移动过去
                        map[x - 1][y] = "@";
                        //4.记录玩家的当前坐标
                        x -= 1;
                        //移动箱子
                        //1.将箱子当前的位子不需要还原
                        //3.移动箱子
                        if(fb==1){
                            map[x - 1][y] ="*";
                        }else {
                            map[x - 1][y] = "$";
                        }

                    }
                }
               break;
            case "d":
                //通道和目标点
                if (map[x + 1][y].equals(" ") || map[x + 1][y].equals(".") ){
                    if( map[x + 1][y].equals(".")){
                        f=1;
                    }
                    if (map2[x][y].equals(".") ){
                        map[x][y] = ".";
                    } else {
                        map[x][y] = " ";
                    }
                    //3.将玩家移动过去
                    if(f==1){
                        map[x + 1][y] = "+";
                    }else {
                        map[x + 1][y] = "@";
                    }
                    //4.记录玩家的当前坐标
                    x += 1;
                    break;                }
                //如果是箱子
                if (map[x + 1][y].equals("$")||map[x + 1][y].equals("*")) {
                    //继续判断箱子的上边
                    //如果是通道或目标点
                    if ((x+2<map.length)&&map[x + 2][y].equals(" ") || map[x + 2][y].equals(".")) {
                        if( map[x + 1 + 1][y].equals(".")){
                            fb=1;
                        }
                        //移动玩家
                        if (map2[x][y].equals(".")) {
                            map[x][y] = ".";
                        } else {
                            map[x][y] = " ";
                        }
                        //3.将玩家移动过去
                        map[x + 1][y] = "@";
                        //4.记录玩家的当前坐标
                        x += 1;
                        //移动箱子
                        //1.将箱子当前的位子不需要还原
                        //3.移动箱子
                        if(fb==1){
                            map[x + 1 ][y] = "*";
                        }else {
                            map[x + 1 ][y] = "$";
                        }

                    }
                }
                break;
            case "l":

                //通道和目标点
                if (map[x][y - 1].equals(" " )|| map[x][y - 1].equals(".") ){
                    if(map[x][y - 1].equals(".")){
                        f=1;
                    }
                    if (map2[x][y].equals(".") ){
                        map[x][y] = ".";
                    } else {
                        map[x][y] = " ";
                    }
                    //3.将玩家移动过去
                    if(f==1){
                        map[x][y - 1] = "+";
                    }else {
                        map[x][y - 1] = "@";
                    }
                    //4.记录玩家的当前坐标
                    y -= 1;
                    break;
                }
                //如果是箱子
                if (map[x][y - 1].equals("$")|| map[x][y - 1].equals("*")){
                    //继续判断箱子的上边
                    //如果是通道或目标点
                    if ((y-2>0)&&map[x][y - 1 - 1].equals(" " )|| map[x][y - 1 - 1].equals(".")) {
                        if(map[x][y - 1 - 1].equals(".")){
                            fb=1;
                        }
                        //移动玩家
                        if (map2[x][y].equals(".") ){
                            map[x][y] = ".";
                        } else {
                            map[x][y] = " ";
                        }
                        //3.将玩家移动过去
                        map[x][y - 1] = "@";
                        //移动箱子
                        //1.将箱子当前的位子不需要还原
                        //3.移动箱子
                        if(fb==1){
                            map[x][y - 1 - 1] = "*";
                        }else {
                            map[x][y - 1 - 1] = "$";
                        }
                        //4.记录玩家的当前坐标
                        y -= 1;
                        //重画

                    }
                }
               break;

            case "r":
                //通道和目标点
                if (map[x][y + 1].equals(" " )|| map[x][y + 1].equals(".")) {
                    if( map[x][y + 1].equals(".")){
                        f=1;
                    }
                    if (map2[x][y].equals(".")) {
                        map[x][y] = ".";
                    } else {
                        map[x][y] = " ";
                    }
                    //3.将玩家移动过去
                    if(f==1){
                        map[x][y + 1] = "@";
                    }else {
                        map[x][y + 1] = "@";
                    }
                    //4.记录玩家的当前坐标
                    y += 1;
                    f=0;
                    break;
                }
                //如果是箱子
                if (map[x][y + 1].equals("$")|| map[x][y + 1].equals("*")){
                    //继续判断箱子的上边
                    //如果是通道或目标点
                    if ((x+2<map.length)&&map[x][y + 1 + 1].equals(" " )|| map[x][y + 1 + 1].equals(".") ){
                        if (map[x][y + 1 + 1].equals(".")){
                            fb=1;
                        }
                        //移动玩家
                        if (map2[x][y].equals(".")) {
                            map[x][y] = ".";
                        } else {
                            map[x][y] = " ";
                        }
                        //3.将玩家移动过去
                        map[x][y + 1] = "@";

                        //移动箱子
                        //1.将箱子当前的位子不需要还原
                        //3.移动箱子
                        if(fb==1){
                            map[x][y + 1 + 1] = "*";
                        }else {
                            map[x][y + 1 + 1] = "$";
                        }
                        //4.记录玩家的当前坐标
                        y += 1;

                    }
                }
                break;

            default:
                break;
        }
        return direction;
    }

    @Override
    public void reset() {

        for (int i = 0; i < map2.length; i++) {
            for (int j = 0; j < map2[i].length; j++) {
                map[i][j]=""+map2[i][j];
                if (map2[i][j]!=null && (map2[i][j].equals("@")||map2[i][j].equals("+"))){
                    x=i;
                    y=j;
                }

            }
            }

    }




}

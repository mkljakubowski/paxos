package hackerrank.algortithms;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

class Rect{
    int x1;
    int x2;
    int h;
    Rect(int _x1, int _x2, int _h){
        x1 = _x1;
        x2 = _x2;
        h = _h;
    }
}

public class RectanglesBorder {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int rectangles = Integer.parseInt(in.nextLine());
        int result = 0;
        int pos = 0;
        int height = 0;
        List<Rect> rects = new LinkedList<Rect>();
        List<Rect> openRects = new LinkedList<Rect>();

        for(int i = 0 ; i < rectangles ; i++){
            String[] numsStr = in.nextLine().split(" ");
            int x1 = Integer.parseInt(numsStr[0]);
            int x2 = Integer.parseInt(numsStr[1]);
            int h = Integer.parseInt(numsStr[2]);
            rects.add(new Rect(x1, x2, h));
        }

        //sort rectangles by starting point
        Collections.sort(rects, (Rect r1, Rect r2) -> r1.x1 - r2.x1);
        pos = rects.get(0).x1;

        for(Rect rect : rects){
            for(Rect prev : openRects){ // close all rects that ended recently
                if(prev.x2 <= pos){
                    openRects.remove(prev);
                    if(height == prev.h){
                        if(openRects.size() == 0){
                            height = 0;
                        } else {
                            int newH = Collections.max(openRects, (Rect r1, Rect r2) -> r2.h - r1.h).h;
                            result = height - newH;
                            height = newH;
                        }
                    }
                }
            }

            openRects.add(rect); // add current rect to list of open ones maintaining order
            Collections.sort(openRects, (Rect r1, Rect r2) -> r1.x2 - r2.x2);

            // compute border of current rect
            result += rect.x1 - pos;
            pos = rect.x1;
            if(rect.h > height) {
                result += rect.h - height;
                height = rect.h;
            }
        }

        // close all open rects
        for(Rect prev : openRects){
            if(height == prev.h){
                if(openRects.indexOf(prev) == openRects.size() - 1) {
                    result += height;
                    height = 0;
                } else {
                    prev.h = 0;
                    int newH = Collections.max(openRects, (Rect r1, Rect r2) -> r1.h - r2.h).h;
                    result += height - newH;
                    height = newH;
                }
            }
            prev.h = 0;
            result += prev.x2 - pos;
            pos = prev.x2;
        }

        System.out.println(result);
    }
}

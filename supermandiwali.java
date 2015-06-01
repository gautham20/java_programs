package gud;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class bpeople {
    public int b = 0;
    public int pc = 0;
    public bpeople(int bt, int pct){
        b = bt;
        pc = pct;
    }
    
    public String toString(){
    	return "("+b+","+pc+")" ;
    }
}

class rescue {
	public int total = 0;
	public bpeople bp = new bpeople(-1,-1);
	public rescue(){
		total = 0;
		bp.b = -1;
		bp.pc = -1;
	}
	public void add (int bt, int pct){
		bp.b = bt;
		bp.pc = pct;
		total = total + pct;
	}
}

class bpeople_list extends ArrayList<bpeople> {
	public bpeople_list(){
		super();
	}
	
    public bpeople containB (int b){
    	Iterator it = iterator();
    	while(it.hasNext()){
    		bpeople bp = (bpeople)it.next();
    		if(bp.b==b){
    			return bp;
    		}
    	}
    	return null;
    }
    
    public void display(){
    	Iterator it = iterator();
    	while(it.hasNext()){
    		System.out.print(it.next().toString()+" ");
    	}
    	System.out.println();
    }
    
}

public class supermandiwali {
        public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int h = s.nextInt();
        int min = s.nextInt();
        bpeople_list bpl[] = new bpeople_list[h];
        for(int g=0;g<h;g++){
        	bpl[g] = new bpeople_list();
        }
        rescue rarr[] = new rescue[h];
        for(int g=0;g<h;g++){
        	rarr[g] = new rescue();
        }
        for(int i=0; i<n ; i++){
        	int pt = s.nextInt();
        	for(int j=0; j<pt ; j++){
        		int f = (s.nextInt()-1);
        		bpeople bp = null;
        		if(bpl[f]!=null){
        		bp = bpl[f].containB(i);
        		}
        		if(bp!=null){
        			bp.pc++;
        		}
        		else{
        			bp = new bpeople(i,1);
        			//System.out.println(i +" "+j+" "+f);
        			bpl[f].add(bp);
        		}
        	}
        }
        
       for(int g=(h-1);g>=0;g--){
        	System.out.print(g);
        	bpl[g].display();
        }
        
        
        for(int c = (h-1); c>=0 ; c--){      //iterate through floors
        	if(!bpl[c].isEmpty()){
        		int len = bpl[c].size();
        		for(int k=0; k<len ; k++){   //iterate through elements of floor
        			bpeople temp = bpl[c].get(k);
        			rescue tr = new rescue();
        			tr.add(temp.b, temp.pc);
        			for(int bc = 1 ; bc<=(min-1) && (c+bc)<h ; bc++){
        				if(temp.b ==  rarr[c+bc].bp.b){
        					tr.total = tr.total>(temp.pc + rarr[c+bc].total)? tr.total : (temp.pc + rarr[c+bc].total);
        				}
        			}
        			if(c+min<h){
        			tr.total = tr.total>(temp.pc + rarr[c+min].total)? tr.total : (temp.pc + rarr[c+min].total);
        			}
        			System.out.println("tr.total "+ tr.total +"rarr[c].total "+rarr[c].total);
        			if(rarr[c].total==0){
        				rarr[c].total = tr.total;
        				rarr[c].bp.b = tr.bp.b;
        				rarr[c].bp.pc = tr.bp.pc;
        			}
        			
        				int trc=0,rc=0;
        				int trb = tr.bp.b;
        				int rcb = rarr[c].bp.b;
        				for(int l=1; l<=min && (c-l)>=0;l++){
        					int si = bpl[c-l].size();
        					for(int y=0;y<si;y++){
        						if(bpl[c-l].get(y).b==trb){ trc = trc+bpl[c-l].get(y).pc; }
        						if(bpl[c-l].get(y).b==rcb){ rc = bpl[c-l].get(y).pc; }
         					}
        				}if(c==5){
        				System.out.println("trrc "+trc+" rc "+rc);
        				}
        				if(trc+tr.total>rc+rarr[c].total){
        					rarr[c].total = tr.total;
            				rarr[c].bp.b = tr.bp.b;
            				rarr[c].bp.pc = tr.bp.pc;
        				}
        			
        			if((c+1)<h){
        			if(rarr[c].total<rarr[c+1].total ){
        				rarr[c].total = rarr[c+1].total;
        				rarr[c].bp.b = rarr[c+1].bp.b;
        				rarr[c].bp.pc = rarr[c+1].bp.pc;
        			}
        			}
        			
        		}
        	}
        	else{
        		//System.out.println(c);
        		if(c!=(h-1))
        		rarr[c].total = rarr[c+1].total;
        	}
        	System.out.println(c+"  "+rarr[c].total);
        }
        
        System.out.println(rarr[0].total);
        
        
    }
}

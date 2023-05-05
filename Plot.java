 

public class Plot {
	private int x, y, width, depth;
	
	Plot() {
		this.x = 0;
		this.y = 0;
		this.width = 1;
		this.depth = 1;
	}
	Plot(int x,int y,int width, int depth) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.depth = depth;
		//System.out.println(this);
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getDepth() {
		return depth;
	}

	public void setDepth(int depth) {
		this.depth = depth;
	}
	 
	public boolean overlaps(Plot plot) {
		boolean rtnValue = false;
		int pX = plot.getX();
		int pY = plot.getY();
		int pW = plot.getWidth();
		int pD = plot.getDepth();
		
		if ((pX<x+width)&&(pX+pW>x)&&(pY<y+depth)&&(pY+pD>y))
				{
			rtnValue=true;
				}
		return rtnValue;
	}

	 
	public boolean encompasses(Plot plot) {
		boolean rtnValue = false;
		int pX = plot.getX();
		int pY = plot.getY();
		int pW = plot.getWidth();
		int pD = plot.getDepth();
		if ((pX>=x)&&(pY>=y)&&(pX+pW<=x+width)&&(pY+pD<=y+depth))
				{
			rtnValue=true;
		}
		return rtnValue;
	}
	
	@Override
	public String toString() {
		return "Upper left: ("+x+","+y+"); Width: "+width+" Depth: "+depth;
	}

}

package org.tfzr.appform;

import java.io.Serializable;

public class CurrentProjectInfo implements Serializable{
	
    /**
	 * 
	 */
	private static final long serialVersionUID = -6191248941409467766L;
	private static int ROW_SIZE;
    private static int COLUMN_SIZE;
    private static int CELL_SIZE_X;
    private static int CELL_SIZE_Y;
    
	public static int getROW_SIZE() {
		return ROW_SIZE;
	}
	public static void setROW_SIZE(int rOW_SIZE) {
		ROW_SIZE = rOW_SIZE;
	}
	public static int getCOLUMN_SIZE() {
		return COLUMN_SIZE;
	}
	public static void setCOLUMN_SIZE(int cOLUMN_SIZE) {
		COLUMN_SIZE = cOLUMN_SIZE;
	}
	public static int getCELL_SIZE_X() {
		return CELL_SIZE_X;
	}
	public static void setCELL_SIZE_X(int cELL_SIZE_X) {
		CELL_SIZE_X = cELL_SIZE_X;
	}
	public static int getCELL_SIZE_Y() {
		return CELL_SIZE_Y;
	}
	public static void setCELL_SIZE_Y(int cELL_SIZE_Y) {
		CELL_SIZE_Y = cELL_SIZE_Y;
	}
    
    
}

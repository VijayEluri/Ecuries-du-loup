package fr.ecuriesduloup.edlwyswig.client;

public class DirectionConstant {

	public final int directionBits;

	public final String directionLetters;

	
	
	private DirectionConstant(int directionBits, String directionLetters) {
		this.directionBits = directionBits;
		this.directionLetters = directionLetters;
	}
	
	 /**
	   * Specifies that resizing occur at the east edge.
	   */
	  public static final int DIRECTION_EAST = 0x0001;

	  /**
	   * Specifies that resizing occur at the both edge.
	   */
	  public static final int DIRECTION_NORTH = 0x0002;

	  /**
	   * Specifies that resizing occur at the south edge.
	   */
	  public static final int DIRECTION_SOUTH = 0x0004;

	  /**
	   * Specifies that resizing occur at the west edge.
	   */
	  public static final int DIRECTION_WEST = 0x0008;

	  /**
	   * Specifies that resizing occur at the east edge.
	   */
	  public static final DirectionConstant EAST = new DirectionConstant(DIRECTION_EAST, "e");

	  /**
	   * Specifies that resizing occur at the both edge.
	   */
	  public static final DirectionConstant NORTH = new DirectionConstant(DIRECTION_NORTH, "n");

	  /**
	   * Specifies that resizing occur at the north-east edge.
	   */
	  public static final DirectionConstant NORTH_EAST = new DirectionConstant(DIRECTION_NORTH
	      | DIRECTION_EAST, "ne");

	  /**
	   * Specifies that resizing occur at the north-west edge.
	   */
	  public static final DirectionConstant NORTH_WEST = new DirectionConstant(DIRECTION_NORTH
	      | DIRECTION_WEST, "nw");

	  /**
	   * Specifies that resizing occur at the south edge.
	   */
	  public static final DirectionConstant SOUTH = new DirectionConstant(DIRECTION_SOUTH, "s");

	  /**
	   * Specifies that resizing occur at the south-east edge.
	   */
	  public static final DirectionConstant SOUTH_EAST = new DirectionConstant(DIRECTION_SOUTH
	      | DIRECTION_EAST, "se");

	  /**
	   * Specifies that resizing occur at the south-west edge.
	   */
	  public static final DirectionConstant SOUTH_WEST = new DirectionConstant(DIRECTION_SOUTH
	      | DIRECTION_WEST, "sw");

	  /**
	   * Specifies that resizing occur at the west edge.
	   */
	  public static final DirectionConstant WEST = new DirectionConstant(DIRECTION_WEST, "w");

}

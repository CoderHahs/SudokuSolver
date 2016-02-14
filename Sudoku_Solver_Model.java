// ////////////////////////////////////////////////////////
//
//                  SUDOKU SOLVER MODEL
//
// ////////////////////////////////////////////////////////


// array representation of the sudoku puzzle view
int board[] = new int [81];

// updates board with value at pos
public void update_board (int pos, int value)
{
    board [pos] = value;
}

// checks if number is in row
public boolean check_row (int cell, int value)
{
    int row_num = cell / 9;
    int start_pos = row_num * 9;
    int end_pos = start_pos + 8;
    boolean value_not_in_row = true;

    for (int pos = start_pos ; pos <= end_pos ; pos++)
    {
	if (board [pos] == value)
	    value_not_in_row = false;
    }


    return value_not_in_row;
}

// checks if number is in column
public boolean check_col (int cell, int value)
{
    int col_num = cell % 9;
    int start_pos = col_num;
    int end_pos = start_pos + 72;
    boolean value_not_in_col = true;

    for (int pos = start_pos ; pos <= end_pos ; pos = pos + 9)
    {
	if (board [pos] = value)
	    value_not_in_col = false;
    }


    return value_not_in_col;
}


// returns box number
public int get_box (int cell)
{
    int row_num = cell / 9;
    int col_num = cell % 9;
    int box_num;

    if (row_num <= 2)
    {
	if (col_num <= 2)
	    box_num = 1;
	if (col_num <= 5)
	    box_num = 2;
	if (col_num <= 8)
	    box_num = 3;
    }


    else if (row_num <= 5)
    {
	if (col_num <= 2)
	    box_num = 4;
	if (col_num <= 5)
	    box_num = 5;
	if (col_num <= 8)
	    box_num = 6;
    }


    else
    {
	if (col_num <= 2)
	    box_num = 7;
	if (col_num <= 5)
	    box_num = 8;
	if (col_num <= 8)
	    box_num = 9;
    }


    return box_num;
}


// helper of check_box
public boolean check_box_helper (int start_cell, int value)
{
    boolean value_not_in_box = true;
    int row_count = 1;

    while (row_count < 4)
    {

	if (row_count == 1)
	{
	    for (int pos = start_cell ; pos < (start_cell + 3) ; pos++)
	    {
		if (board [pos] == value)
		    value_not_in_box = false;
	    }
	}

	if (row_count == 2)
	{
	    for (int pos = start_cell + 9 ; pos < (start_cell + 12) ; pos++)
	    {
		if (board [pos] == value)
		    value_not_in_box = false;
	    }
	}

	if (row_count == 3)
	{
	    for (int pos = start_cell + 18 ; pos < (start_cell + 21) ; pos++)
	    {
		if (board [pos] == value)
		    value_not_in_box = false;
	    }
	}

	row_count++;
    }


    return value_not_in_box;
}

// checks if number is in box
public boolean check_box (int cell, int value)
{
    int box = get_box (cell);
    boolean value_not_in_box = true;

    if (box == 1)
	value_not_in_box = check_box_helper (0, value);
    if (box == 2)
	value_not_in_box = check_box_helper (3, value);
    if (box == 3)
	value_not_in_box = check_box_helper (6, value);
    if (box == 4)
	value_not_in_box = check_box_helper (27, value);
    if (box == 5)
	value_not_in_box = check_box_helper (30, value);
    if (box == 6)
	value_not_in_box = check_box_helper (33, value);
    if (box == 7)
	value_not_in_box = check_box_helper (54, value);
    if (box == 8)
	value_not_in_box = check_box_helper (57, value);
    if (box == 9)
	value_not_in_box = check_box_helper (60, value);

    return value_not_in_box;
}

// Counts number of null values in board
public int count_null ()
{
    int count;

    for (int pos = 0 ; pos < board.length ; pos++)
    {
	if (board [pos] == null)
	    count++;
    }


    return count;
}

// Solves the sudoku puzzle
public void solve_puzzle ()
{

    int begin_null_count = count_null ();

    while (begin_null_count != 0)
    {

	for (int pos = 0 ; pos < board.length ; pos++)
	{
	    if (board [pos] != null)
	    {
		for (int num = 1 ; num < 10 ; num++)
		{
		    boolean valid = check_row (pos, num) && check_col (pos, num) && check_box (pos, num);

		    if (valid == true)
			update_board (pos, num);
		}
	    }
	}
	
	begin_null_count = count_null();
    }
}










package com.test.spiralarray;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 * @author SHAWN GUO
 * */
// Given a ¡°n x m¡± array (n & m could be different or same numbers),
// print the contents of the array in a spiral order
// (i.e. print the outermost elements followed by the next inner layer
// followed by the next inner layer and so on until all elements are printed)
// in a clockwise manner. Note that all elements of the array should be
// printed only once.The input could be either read from a text file or
// from a command prompt and the output should be printed on a console.
public class SpiralArray
{ // ******* algorithm*******//time complexity O(M*N)
	public void printTopRight(char a[][], int x1, int y1, int x2, int y2)
	{
		int i = 0, j = 0;
		// print values in the row.
		for (i = x1; i <= x2; i++)
		{
			System.out.print(a[y1][i]);
		}
		// print values in the column.
		for (j = y1 + 1; j <= y2; j++)
		{
			System.out.print(a[j][x2]);
		}
		// see if more layers need to be printed.
		if (x2 - x1 > 0 && y2 - y1 > 0)
		{
			printBottomLeft(a, x1, y1 + 1, x2 - 1, y2);
		}
	}

	public void printBottomLeft(char a[][], int x1, int y1, int x2, int y2)
	{
		int i = 0, j = 0;
		// print the values in the row in reverse order.
		for (i = x2; i >= x1; i--)
		{
			System.out.print(a[y2][i]);
		}
		// print the values in the col in reverse order.
		for (j = y2 - 1; j >= y1; j--)
		{
			System.out.print(a[j][x1]);
		}
		// see if more layers need to be printed.
		if (x2 - x1 > 0 && y2 - y1 > 0)
		{
			printTopRight(a, x1 + 1, y1, x2, y2 - 1);
		}
	}

	public void printSpiral(char arr[][])
	{ // judge if the array is empty
		if (arr == null || arr.length == 0)
		{
			System.out.println("please provide an array in the file");
			return;
		}
		printTopRight(arr, 0, 0, arr[0].length - 1, arr.length - 1);
	}

	// test output in a main method
	public static void main(String[] args)
	{ // read array from file
		File f = new File("test2darray.txt");
		ReadFile m = new ReadFile();
		char[][] ch = m.readFile(f);
		// call algorithm for output
		SpiralArray s = new SpiralArray();
		s.printSpiral(ch);
	}
}

class ReadFile
{
	public char[][] readFile(File file)
	{
		char[][] point = null;
		int x = 0;
		int y = 0;
		int row = 0;
		int col = 0;
		try
		{
			// read the file to get the size
			FileReader file_reader = new FileReader(file);
			BufferedReader buf_reader = new BufferedReader(file_reader);
			String line;
			boolean firstline = true;
			while ((line = buf_reader.readLine()) != null)
			{
				if (firstline == true)
				{
					col = line.length();
					firstline = false;
				}
				row++;
			}
			point = new char[row][col];
			// read the file to get the data
			FileReader file2 = new FileReader(file);
			BufferedReader buf = new BufferedReader(file2);
			while ((line = buf.readLine()) != null)
			{
				for (y = 0; y < line.length(); y++)
				{
					point[x][y] = line.charAt(y);
				}
				x++;
			}
			buf_reader.close();
			buf.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return point;
	}
}

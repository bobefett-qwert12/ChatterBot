package chat.controller;

import java.util.Scanner;
import java.util.Calendar;
import java.io.IOException;
import java.io.File;
import java.io.PrintWriter;

public class IOController
{
	public static void saveText(ChatController app, String path, String textToSave)
	{
		try
		{
			//creates a new file name with the current date
			String fileName = path;
			Calendar date = Calendar.getInstance();
			fileName += "/" + date.get(Calendar.MONTH) + " " + date.get(Calendar.DAY_OF_MONTH);
			fileName += " at " +date.get(Calendar.HOUR) + "-" + date.get(Calendar.MINUTE);
			fileName += " chatbot save.txt";
			
			//creates a scanner and a print writer from that file
			File saveFile = new File(fileName);
			Scanner in = new Scanner(textToSave);
			PrintWriter saveText = new PrintWriter(saveFile);
			
			//reads the file with the scanner and writes it to the print writer
			while(in.hasNext())
			{
				String currentLine = in.nextLine();
				saveText.println(currentLine);
			}
			
			in.close();
			saveText.close();
		}
		catch(IOException e)
		{
			//catches file errors
			app.handleErrors(e);
		}
		catch(Exception genericError)
		{
			//catches generic errors
			app.handleErrors(genericError);
		}
	}
	public static String loadFile(ChatController app, String path)
	{
		String contents = "";
		try
		{
			File saveFile = new File(path);
			Scanner fileScanner;
			if(saveFile.exists())
			{
				fileScanner = new Scanner(saveFile);
				while(fileScanner.hasNext())
				{
					contents += fileScanner.nextLine() + "\n";
				}
				fileScanner.close();
			}
		}
		catch(IOException e)
		{
			app.handleErrors(e);
		}
		catch(Exception genericError)
		{
			app.handleErrors(genericError);
		}
		return contents;
	}
	
	private void close()
	{
		System.exit(0);
	}
}

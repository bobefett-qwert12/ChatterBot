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
			String fileName = path;
			Calendar date = Calendar.getInstance();
			fileName += "/" + date.get(Calendar.MONTH) + " " + date.get(Calendar.DAY_OF_MONTH);
			fileName += " chatbot save.txt";
			
			File saveFile = new File(fileName);
			Scanner in = new Scanner(textToSave);
			PrintWriter saveText = new PrintWriter(saveFile);
			
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
			app.handleErrors(e);
		}
		catch(Exception genericError)
		{
			app.handleErrors(genericError);
		}
	}
}
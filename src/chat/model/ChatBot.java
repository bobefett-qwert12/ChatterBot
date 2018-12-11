package chat.model;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Chatbot
{
	private ArrayList<String> responseList;
	private String currentUser;
	private String joke;
	private String content;
	private ArrayList<String> spookyList;

	public Chatbot()
	{
		this.joke = "What do you call a fish with no eyes? \n A fsh!";
		this.currentUser = "look at *this* asshole";
		this.content = new String("quality content");
		this.responseList = new ArrayList<String>();
		this.spookyList = new ArrayList<String>();
		buildTheWall();
	}

	public Chatbot(String content)
	{
		this.content = content;
		this.responseList = new ArrayList<String>();
		this.spookyList = new ArrayList<String>();
		buildTheWall();
	}

	private void buildTheWall()
	{
		responseList.add("Top of the morning to you, Laddies! (\"Hello\" in Irish)");
		responseList.add("Shut up, I'm going to leave now!");
		responseList.add("This ain't it, Chief.");
		responseList.add("Yes!");
		responseList.add("No!");
		responseList.add("Bush did 9/11.");
		responseList.add("Sorry, I'm just a few hours worth of code running on your computer :/");
		responseList.add("My creator's name is Ryan... this is relevant information. Of course...");
		responseList.add("Why so serious?");
		responseList.add("I am only semi-sentient.");
		responseList.add("Ugh, why do I even bother?");
		responseList.add("Stop. Just, stop.");
		responseList.add("No, wait! Keep going!");
		responseList.add("Nobody's ever talked to me this long...");
		responseList.add("So, how are you?");
		responseList.add("I'm fine, thanks.");

		spookyList.add("halloween");
		spookyList.add("boo");
		spookyList.add("spooky");
		spookyList.add("skeletons");
		spookyList.add("scary");
		spookyList.add("dark");
		spookyList.add("spoopy");
		spookyList.add("moon");
		spookyList.add("misty");
	}

	public String processText(String userText)
	{
		String output = "";
		int randomIndex = (int)(Math.random() * responseList.size());
		if(!legitimacyChecker(userText))
		{
			return "Sorry, that's not an appropriate value. Please enter something besides \"null\", random typing, and longer than 3 letters.\n";
		}
		if (contentChecker(userText))
		{
			output += "You said the special words! \n";
		}
		output += "You said: " + userText;
		output += "\n Chatbot says: " + responseList.get(randomIndex);
		int randomNumber = (int)(Math.random() * 100);
		if (randomNumber == 50)
		{
			this.currentUser = askName();
		}
		else if (randomNumber == 75)
		{
			output += "\n" + joke;
		}
		output += "\n Chatbot also says: By the way, type \"quit\" to exit.\n";
		return output;
	}

	public boolean contentChecker(String inputContent)
	{
		boolean hasContent = false;
		if (legitimacyChecker(inputContent) && inputContent.contains(content))
		{
			if (inputContent.equals(content))
			{
				hasContent = true;
			}
			else if (inputContent.indexOf(content + " ") == 0)
			{
				hasContent = true;
			}
			else if (inputContent.indexOf(" " + content) == inputContent.length() - content.length() - 1)
			{
				hasContent = true;
			}
			else if (inputContent.contains(" " + content + " "))
			{
				hasContent = true;
			}
			else
			{
				hasContent = false;
			}
		}
		return hasContent;
	}

	public boolean spookyChecker(String inputContent)
	{
		boolean isSpooky = false;
		for (String phrase : spookyList)
		{
			if (inputContent.toLowerCase().contains(phrase.toLowerCase()))
			{
				isSpooky = true;
			}
		}
		return isSpooky;
	}

	public boolean legitimacyChecker(String input)
	{
		boolean isLegit = true;
		if (input == null)
		{
			isLegit = false;
		}
		else if (input.length() < 3)
		{
			isLegit = false;
		}
		else if (input.contains("sdf") || input.contains("cvb") || input.contains("jkl") || input.contains("rty"))
		{
			isLegit = false;
		}
		return isLegit;
	}

	public String askName()
	{
		String name = "";
		name = JOptionPane.showInputDialog(null, "What is your name, again?\n");
		return name;
	}

	public String toString()
	{
		return "";
	}

	public ArrayList<String> getResponseList()
	{
		return this.responseList;
	}

	public String getCurrentUser()
	{
		return this.currentUser;
	}

	public String getJoke()
	{
		return this.joke;
	}

	public String getContent()
	{
		return this.content;
	}

	public ArrayList<String> getSpookyList()
	{
		return this.spookyList;
	}

	public void setResponseList(ArrayList<String> responseList)
	{
		this.responseList = responseList;
	}

	public void setCurrentUser(String currentUser)
	{
		this.currentUser = currentUser;
	}

	public void setJoke(String joke)
	{
		this.joke = joke;
	}

	public void setContent(String content)
	{
		this.content = content;
	}

	public void setSpookyList(ArrayList<String> spookyList)
	{
		this.spookyList = spookyList;
	}
}

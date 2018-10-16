package chat.model;

import java.util.ArrayList;

public class ChatBot
{
	private ArrayList<String> responseList;
	private String currentUser;
	private String joke;
	private String content;
	private ArrayList<String> spookyList;

	public ChatBot()
	{
		this.joke = "*insert dad joke*";
		this.currentUser = "default asshole";
		this.content = new String("quality content");
		this.responseList = new ArrayList<String>();
		this.spookyList = new ArrayList<String>();
		buildTheWall();
	}

	public ChatBot(ArrayList<String> responseList, String currentUser, String joke, String content, ArrayList<String> spookyList)
	{
		this.responseList = responseList;
		this.currentUser = currentUser;
		this.joke = joke;
		this.content = content;
		this.spookyList = spookyList;
	}
	
	private void buildTheWall()
	{
		responseList.add("Top of the morning to you, Laddies!");
		responseList.add("Shut up, I'm going to leave now!");
		responseList.add("This ain't it, Chief.");
		responseList.add("Yes!");
		responseList.add("No!");
		responseList.add("Bush did 9/11.");
		
	}

	public String askName()
	{
		String name = "";
		return name;
	}
	public String toString() {
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

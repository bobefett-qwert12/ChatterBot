package chat.controller;

import chat.model.Chatbot;
import javax.swing.JOptionPane;

public class ChatController
{
	private Chatbot myBot;

	public ChatController()
	{
		myBot = new Chatbot();
	}

	public void start()
	{
		boolean isDone = false;
		while (!isDone)
		{
			String userInput = "";
			while (!userInput.equals("quit"))
			{
				userInput = interactWithChatbot(userInput);
			}
		}
	}

	public String interactWithChatbot(String userInput)
	{
		String chatBotSays = JOptionPane.showInputDialog(null, "Hi, what do you want to talk about?");
		chatBotSays = myBot.processText(userInput);
		if (chatBotSays.toLowerCase().contains("quit"))
		{
			return "quit";
		}
		return chatBotSays;
	}

	public String useChatbotCheckers(String text)
	{
		String blah = "Halloween";
		return blah;
	}

	public Chatbot getChatbot()
	{
		return this.myBot;
	}

	public void setChatbot(Chatbot myBot)
	{
		this.myBot = myBot;
	}
}

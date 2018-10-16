package chat.controller;

import chat.model.ChatBot;
import javax.swing.JOptionPane;

public class ChatBotController
{
	private ChatBot myBot;

	public ChatBotController()
	{
		myBot = new ChatBot();
	}
	public void start()
	{
		boolean isDone = false;
		while (!isDone)
		{
			String userInput = "";
			while(!userInput.equals("quit"))
			{
				userInput = interactWithChatbot(userInput);
			}
		}
	}

	public String interactWithChatbot(String userInput)
	{
		String chatBotSays = JOptionPane.showInputDialog(null, "Hi, what do you want to talk about?");
		chatBotSays = myBot.processText(userInput);
		return chatBotSays;
	}

	public ChatBot getMyBot()
	{
		return this.myBot;
	}

	public void setMyBot(ChatBot myBot)
	{
		this.myBot = myBot;
	}
}

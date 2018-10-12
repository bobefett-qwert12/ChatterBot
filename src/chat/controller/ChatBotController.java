package chat.controller;

import chat.model.ChatBot;
import javax.swing.JOptionPane;

public class ChatBotController
{
	private ChatBot myBot;

	public void start()
	{
		boolean isDone = false;
		while (!isDone)
		{
			JOptionPane.showMessageDialog(null, "Would you like to play a game?");
			String quitting = JOptionPane.showInputDialog(null, "Type \"quit\" to exit:");
			if (quitting.equalsIgnoreCase("quit"))
			{
				isDone = true;
			}
		}
	}

	public String interactWithChatbot(String botText)
	{
		String something = "";
		return something;
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

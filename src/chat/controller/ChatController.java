package chat.controller;

import chat.model.Chatbot;
import javax.swing.JOptionPane;
import chat.view.ChatFrame;

public class ChatController
{
	private Chatbot myBot;
	private ChatFrame appFrame;

	public ChatController()
	{
		myBot = new Chatbot();
		appFrame = new ChatFrame(this);
	}

	public void start()
	{
//		boolean isDone = false;
//		while (!isDone)
//		{
//			String userInput = JOptionPane.showInputDialog(null, "Welcome to my world! My name is chatBot! What do you want to talk about?");
//			String userInput2 = userInput;
//			while (!userInput2.equals("quit"))
//			{
//				userInput2 = JOptionPane.showInputDialog(null, interactWithChatbot(userInput2));
//			}
//			isDone = true;
//		}
	}
	
	public void handleErrors(Exception e)
	{
		JOptionPane.showMessageDialog(appFrame, e.getMessage());
	}

	public String interactWithChatbot(String userInput)
	{
		String chatBotSays = myBot.processText(userInput);
		if (chatBotSays.toLowerCase().indexOf("quit") == 10)
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
	
	public ChatFrame getFrame()
	{
		return this.appFrame;
	}
}

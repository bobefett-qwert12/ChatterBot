package chat.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;
import chat.controller.ChatController;
import chat.controller.IOController;

public class ChatPanel extends JPanel
{
	private SpringLayout appLayout;
	private ChatController appController;
	private JButton chatButton;
	private JButton checkerButton;
	private JButton loadButton;
	private JButton saveButton;
	private JButton clearButton;
	private JTextField chatField;
	private JTextArea chatArea;
	private JScrollPane chatPane;

	public ChatPanel(ChatController appController)
	{
		super();
		this.appController = appController;
		appLayout = new SpringLayout();

		saveButton = new JButton("Save");
		loadButton = new JButton("Load");
		chatButton = new JButton("Chat");
		checkerButton = new JButton("Check Text");
		clearButton = new JButton("Clear Text");

		chatField = new JTextField("Talk to the bot here", 50);
		chatArea = new JTextArea("Chat Area", 20, 50);
		chatPane = new JScrollPane();
		
		setupScrollPane();
		setupPanel();
		setupLayout();
		setupListeners();
	}

	private void setupPanel()
	{
		this.setLayout(appLayout);
		this.setPreferredSize(new Dimension(800, 600));
		this.setBackground(Color.cyan);
		this.add(chatPane);
		this.add(chatButton);
		this.add(saveButton);
		this.add(loadButton);
		this.add(checkerButton);
		this.add(clearButton);
		this.add(chatField);
	}

	private void setupLayout()
	{
		appLayout.putConstraint(SpringLayout.WEST, loadButton, 36, SpringLayout.EAST, saveButton);
		appLayout.putConstraint(SpringLayout.NORTH, saveButton, 0, SpringLayout.NORTH, chatButton);
		appLayout.putConstraint(SpringLayout.WEST, saveButton, 27, SpringLayout.EAST, chatButton);
		appLayout.putConstraint(SpringLayout.SOUTH, saveButton, 0, SpringLayout.SOUTH, chatButton);
		appLayout.putConstraint(SpringLayout.EAST, saveButton, 142, SpringLayout.EAST, chatButton);
		appLayout.putConstraint(SpringLayout.NORTH, loadButton, 0, SpringLayout.NORTH, chatButton);
		appLayout.putConstraint(SpringLayout.SOUTH, loadButton, 0, SpringLayout.SOUTH, chatButton);
		appLayout.putConstraint(SpringLayout.NORTH, checkerButton, 0, SpringLayout.NORTH, chatButton);
		appLayout.putConstraint(SpringLayout.SOUTH, checkerButton, 0, SpringLayout.SOUTH, chatButton);
		appLayout.putConstraint(SpringLayout.EAST, checkerButton, -50, SpringLayout.EAST, this);
		appLayout.putConstraint(SpringLayout.EAST, loadButton, -36, SpringLayout.WEST, clearButton);
		appLayout.putConstraint(SpringLayout.WEST, clearButton, 494, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.EAST, clearButton, -191, SpringLayout.EAST, this);
		appLayout.putConstraint(SpringLayout.WEST, checkerButton, 26, SpringLayout.EAST, clearButton);
		appLayout.putConstraint(SpringLayout.SOUTH, clearButton, 0, SpringLayout.SOUTH, chatButton);
		appLayout.putConstraint(SpringLayout.NORTH, clearButton, 0, SpringLayout.NORTH, chatButton);
		appLayout.putConstraint(SpringLayout.NORTH, chatButton, 47, SpringLayout.SOUTH, chatField);
		appLayout.putConstraint(SpringLayout.SOUTH, chatButton, 138, SpringLayout.SOUTH, chatField);
		appLayout.putConstraint(SpringLayout.WEST, chatButton, 0, SpringLayout.WEST, chatPane);
		appLayout.putConstraint(SpringLayout.EAST, chatButton, 115, SpringLayout.WEST, chatPane);
		appLayout.putConstraint(SpringLayout.NORTH, chatField, 27, SpringLayout.SOUTH, chatPane);
		appLayout.putConstraint(SpringLayout.WEST, chatField, 0, SpringLayout.WEST, chatPane);
		appLayout.putConstraint(SpringLayout.EAST, chatField, 0, SpringLayout.EAST, chatPane);
		appLayout.putConstraint(SpringLayout.NORTH, chatPane, 50, SpringLayout.NORTH, this);
		appLayout.putConstraint(SpringLayout.WEST, chatPane, 50, SpringLayout.WEST, this);
		appLayout.putConstraint(SpringLayout.SOUTH, chatPane, -250, SpringLayout.SOUTH, this);
		appLayout.putConstraint(SpringLayout.EAST, chatPane, -50, SpringLayout.EAST, this);
	}

	private void setupListeners()
	{
		chatButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent mouseClick)
			{
				String userText = chatField.getText();
				String response = "";
				response = appController.interactWithChatbot(userText);
				chatArea.append(response);
				chatArea.setCaretPosition(chatArea.getDocument().getLength());
				chatField.setText("");
			}
		});

		clearButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent mouseClick)
			{
				chatArea.setText("Text cleared!");
			}
		});
		
		saveButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent mouseClick)
			{
				String chatText = chatArea.getText();
				String path = ".";
				IOController.saveText(appController, path, chatText);
				chatArea.setText("Chat saved!");
			}
		});
		
		loadButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent mouseClick)
			{
				
			}
		});
		
		checkerButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent mouseClick)
			{
				
			}
		});
	}

	private void setupScrollPane()
	{
		chatArea.setEditable(false);
		chatArea.setLineWrap(true);
		chatArea.setWrapStyleWord(true);

		chatPane.setViewportView(chatArea);
		chatPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		chatPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
	}
}

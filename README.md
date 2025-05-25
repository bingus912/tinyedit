# tinyedit
A tiny text editor at a whopping 4 KB!

![demo](https://github.com/user-attachments/assets/1b8201b8-c351-4693-84ae-a0f1391b2da2)

***

# Install

1. Install JDK
2. Install JRE (optional)
3. Download the .java file from this repo (or git clone it)
4. Compile the .java file
```sh
javac TinyEdit.java
```
5. Run the file
```sh
java TinyEdit
```

***

# Usage
```
java TinyEdit
```

***

# Features

- Simple and lightweight text editor
- Open and save text files
- Cross-platform compatibility
- Easy to use interface

***

# FAQ

## It's not running. How do I fix this?

To run java files, you may need to install JRE for it to work.

## How did you make this?

I made it with some help with AI.

## How do I customize it?

To customize TinyEdit, you need to edit the .java file and then recompile it.

## The config is so complex. Where is the documention?

I dont know how to make more modfications on this text editor, But you can find some tutrouirals to find somthing good.

## I WANT THE DOCUMENTION!!

Click the wiki button for documention. It is unfinsed, but you may not find it user friendly.

***

# Contributing

We welcome contributions to TinyEdit! If you would like to contribute, please follow these guidelines:

1. Fork the repository and create your branch from `main`.
2. If you've added code that should be tested, add tests.
3. Ensure the test suite passes.
4. Make sure your code lints.
5. Issue that pull request!

***

# License

This project is licensed under the terms of the GNU General Public License v3.0. See the [LICENSE](LICENSE) file for details.

***

# Code Structure and Functionality

## Code Structure

The `TinyEdit` class is the main class of the text editor. It extends `JFrame` and implements `ActionListener`. The class contains the following components:

- `JTextPane textPane`: The text area where the user can type and edit text.
- `StyledDocument doc`: The document model for the `JTextPane`.
- `JButton openButton`: The button to open a text file.
- `JButton saveButton`: The button to save the text to a file.

The class also contains the following methods:

- `TinyEdit()`: The constructor that sets up the GUI components and event listeners.
- `actionPerformed(ActionEvent e)`: The method that handles the button click events.
- `main(String[] args)`: The main method that starts the application.

## Functionality

The `TinyEdit` class provides the following functionality:

- Open a text file: When the user clicks the "Open" button, a file chooser dialog is displayed. The user can select a text file to open, and the contents of the file are displayed in the `JTextPane`.
- Save the text to a file: When the user clicks the "Save" button, a file chooser dialog is displayed. The user can select a location to save the text, and the contents of the `JTextPane` are saved to the selected file.
- Line wrapping: The text area supports line wrapping, which improves rendering performance for long lines of text.

## Custom EditorKit and ViewFactory

The `TinyEdit` class uses a custom `EditorKit` and `ViewFactory` to enable line wrapping in the `JTextPane`. The custom `EditorKit` and `ViewFactory` are implemented as inner classes:

- `WrapEditorKit`: A custom `StyledEditorKit` that provides a `ViewFactory` for creating views that support line wrapping.
- `WrapColumnFactory`: A custom `ViewFactory` that creates views for different types of elements in the document.
- `WrapLabelView`: A custom `LabelView` that supports line wrapping by overriding the `getMinimumSpan` method.

The custom `EditorKit` and `ViewFactory` are used to set the editor kit for the `JTextPane`, enabling line wrapping in the text area.

import java.io.*;
import java.util.*;
import java.util.logging.*;

import javax.swing.*;

import syntaxhighlight.SyntaxHighlighter;
import syntaxhighlighter.brush.*;
import syntaxhighlighter.example.Example;
import syntaxhighlighter.SyntaxHighlighterParser;
import syntaxhighlighter.theme.ThemeRDark;

public class QuickCodeInspector {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				SyntaxHighlighterParser parser = new SyntaxHighlighterParser(
						new BrushXml());
				
				parser.setHtmlScript(true);
				parser.setHTMLScriptBrushes(Arrays.asList(new BrushCss(),
						new BrushJScript(), new BrushPhp()));

				SyntaxHighlighter highlighter = new SyntaxHighlighter(parser,
						new ThemeRDark());
				highlighter.setFirstLine(1);
				highlighter.setHighlightedLineList(Arrays.asList(1,2,3,4,5, 27, 28,
						38, 42, 43, 53));
				try {
					highlighter.setContent(new File("C:/Users/Radi/Desktop/example.txt"));
				} catch (IOException ex) {
					Logger.getLogger(Example.class.getName()).log(Level.SEVERE,
							null, ex);
				}

				JFrame frame = new JFrame();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setContentPane(highlighter);
				frame.setLocationByPlatform(true);
				frame.pack();
				frame.setVisible(true);
			}
		});
	}
}

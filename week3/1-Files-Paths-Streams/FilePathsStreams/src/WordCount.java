import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;

class WordCountResult {
	public int lineCount = 0;
	public int wordCount = 0;
	public int characterCount = 0;

	public WordCountResult() {
	}

	public int getLineCount() {
		return lineCount;
	}

	public int getWordCount() {
		return wordCount;
	}

	public int getCharacterCount() {
		return characterCount;
	}
}

public class WordCount {

	WordCountResult wordCount(File file) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(file));
		WordCountResult wcr = new WordCountResult();

		String line = null;

		while ((line = br.readLine()) != null) {
			wcr.lineCount++;
			for (int i = 0; i < line.length(); i++) {
				if (line.charAt(i) == ' ')
					wcr.wordCount++;
			}
			wcr.characterCount += line.length();
		}
		br.close();
		wcr.wordCount++;

		return wcr;
	}

	WordCountResult wordCount(Path path) throws IOException {
		File f = new File(path.toString());
		return wordCount(f);
	}
	
	public static void main(String... args) throws IOException {
		WordCount wc = new WordCount();
		System.out.println(wc.wordCount(new File("C:/Users/Radi/Desktop/this.txt")).getCharacterCount());
		System.out.println(wc.wordCount(new File("C:/Users/Radi/Desktop/this.txt")).getLineCount());
		System.out.println(wc.wordCount(new File("C:/Users/Radi/Desktop/this.txt")).getWordCount());
	}
}

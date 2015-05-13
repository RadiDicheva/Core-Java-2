import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;

public class FileUtils {

	public static String readFrom(File file) throws IOException {
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);

		StringBuilder sb = new StringBuilder();
		String line = br.readLine();

		while (line != null) {
			sb.append(line);
			sb.append(System.lineSeparator());
			line = br.readLine();
		}
		br.close();

		return sb.toString();
	}

	public static String readFrom(Path path) throws IOException {
		File f = new File(path.toString());
		return readFrom(f);
	}

	public static void writeOn(String input) throws IOException {
		File f = new File("C:/Users/Radi/Desktop/this.txt");

		if (!f.exists())
			f.createNewFile();

		BufferedWriter bw = new BufferedWriter(new FileWriter(
				f.getAbsoluteFile()));
		bw.write(input);

		bw.close();
	}

	public static Map<String, String> parseProperties(File file)
			throws IOException {
		Map<String, String> hm = new LinkedHashMap<String, String>();

		BufferedReader br = new BufferedReader(new FileReader(file));

		StringBuilder key = new StringBuilder();
		StringBuilder value = new StringBuilder();
		String line = null;

		while ((line = br.readLine()) != null) {
			line = line.replaceAll(" ", "");

			if (line.charAt(0) == '#')
				continue;

			if (line.contains("#"))
				line = line.substring(0, line.indexOf("#"));

			int index = line.indexOf('=');
			key.append(line.substring(0, index));
			value.append(line.substring(index + 1, line.length()));
			hm.put(key.toString(), value.toString());
			key.setLength(0);
			value.setLength(0);
		}

		br.close();
		return hm;
	}

	public static void writeBinary(byte[] aBytes, String aFileName)
			throws IOException {
		Path path = Paths.get(aFileName);
		Files.write(path, aBytes);
	}

	public static void fixEncoding(Path path) throws IOException {
		byte[] bytes = Files.readAllBytes(path);

		bytes = new String(bytes, "Windows-1251").getBytes("UTF-8");

		writeBinary(bytes, "D:/root/this.txt");
	}

	public static Path reduceFilePath(Path path) {
		return path.normalize();
	}

	public static void brokenLink(Path path) throws IOException {
		File file = new File(path.toString());

		File[] listOfFiles = file.listFiles();

		for (int i = 0; i < listOfFiles.length; i++) {
			if (Files.isSymbolicLink(listOfFiles[i].toPath())
					&& !Files.exists(Files.readSymbolicLink(listOfFiles[i]
							.toPath())))
				System.out.println(listOfFiles[i].getAbsolutePath());
			if (listOfFiles[i].isDirectory())
				brokenLink(listOfFiles[i].toPath());
		}
	}

	public static void compress(Path path) throws IOException {
		String fileContent = readFrom(path);
		String[] fileContentArray = fileContent.split(" ");
		LinkedHashMap<String, Integer> hashMap = new LinkedHashMap<String, Integer>();
		StringBuilder sb = new StringBuilder();

		int counter = 0;
		for (int i = 0; i < fileContentArray.length; i++) {
			if (!hashMap.containsKey(fileContentArray[i])) {
				hashMap.put(fileContentArray[i], counter);
				sb.append(" ~" + hashMap.get(fileContentArray[i]));
				counter++;
			} else
				sb.append(" ~" + hashMap.get(fileContentArray[i]));
		}

		StringBuilder result = new StringBuilder();
		result.append("Legend:");
		result.append(hashMap.toString());
		result.append(System.getProperty("line.separator"));
		result.append(sb.toString());

		writeOn(result.toString());
	}

	public static void decompress(Path path) throws IOException {
		String fileContent = readFrom(path);
		String legend = null;
		String compressed = null;
		LinkedHashMap<Integer, String> lhm = new LinkedHashMap<Integer, String>();

		for (int i = 0; i < fileContent.length(); i++) {
			if (fileContent.charAt(i) == '{')
				legend = (fileContent
						.substring(i + 1, fileContent.indexOf('}')));

			if (fileContent.charAt(i) == '~') {
				compressed = (fileContent.substring(i));
				break;
			}
		}

		legend = legend.replaceAll("\\s+", "");
		legend = legend.replaceAll(",", "=");

		String[] legendArray = legend.split("=");
		ArrayList<String> strList = new ArrayList<String>();
		ArrayList<Integer> intList = new ArrayList<Integer>();

		for (int i = 0; i < legendArray.length; i++) {
			if (i % 2 == 0)
				strList.add(legendArray[i]);
			else
				intList.add(Integer.parseInt(legendArray[i]));
		}

		for (int i = 0; i < strList.size(); i++) {
			lhm.put(intList.get(i), strList.get(i));
		}

		compressed = compressed.replaceAll("~", "");
		String[] compressedArray = compressed.split(" ");
		ArrayList<Integer> compList = new ArrayList<Integer>();
	}

	public static void main(String... args) throws IOException {

		Path p = Paths.get("C:/Users/Radi/Desktop/this.txt");
		File f = new File("C:/Users/Radi/Desktop/this.txt");

		try {
			System.out.println(parseProperties(f));
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			System.out.println(readFrom(p));
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			writeOn("Wohoo I'm writing!!!");
		} catch (IOException e) {
			e.printStackTrace();
		}

		Path path = Paths.get("D:/root/test.txt");
		try {
			fixEncoding(path);
		} catch (IOException e) {
			e.printStackTrace();
		}

		Path path1 = Paths.get("/../");
		System.out.println(reduceFilePath(path1));

		Path pat = Paths.get("C:/Users/Radi/Desktop/test.txt");
		compress(pat);
		
	}
}

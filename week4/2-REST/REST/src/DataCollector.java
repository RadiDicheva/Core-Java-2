import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DataCollector {
	public void crawl(String nextURL) {

	}

	public boolean searchForNeedle(String needle) {
		return false;
	}

	public List<String> getAllLinks(String content) {
		ArrayList<String> resultList = new ArrayList<>();
		String regex = "<a.*?href=\"((?!javascript).*?)\".*?>";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(content);
		
		while (matcher.find()) {
			resultList.add(matcher.group(1));
		}
		
		return resultList;
	}
}

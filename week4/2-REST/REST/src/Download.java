import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class Download {
	public static void downloadFile(final String fileName, final String urlLink)
			throws MalformedURLException, IOException {
		BufferedInputStream inputStream = null;
		FileOutputStream outputStream = null;
		try {
			inputStream = new BufferedInputStream(new URL(urlLink).openStream());
			outputStream = new FileOutputStream(fileName);

			final byte data[] = new byte[1024];
			int counter;
			while ((counter = inputStream.read(data, 0, 1024)) != -1) {
				outputStream.write(data, 0, counter);
			}
		} finally {
			if (inputStream != null) {
				inputStream.close();
			}
			if (outputStream != null) {
				outputStream.close();
			}
		}
	}

	public static void main(String[] args) {
		try {
			downloadFile("information.jpg",
					"http://d3dsacqprgcsqh.cloudfront.net/photo/aozrdx0_700b.jpg");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

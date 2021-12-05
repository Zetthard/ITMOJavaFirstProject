package zetthard.finalProj;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class HttpDownloader {
    //public static final List<String[]> summary = new ArrayList<>();

    public static void main(String[] args) throws InterruptedException {
        //temporary variables for testing. to be replaced by CL params
        String temp = "/Users/semennikolaev/Downloads/filedownloader/";
        String temp2 = "/Users/semennikolaev/Downloads/filedownloader/links.txt";

        int threadCount = 5; //Integer.parseInt(args[0]);
        File location = new File(temp); //args[1]
        File links = new File(temp2); //args[2]

        Map<String, String> linkList = LinkLister.makeList(links);

        ExecutorService execServ = Executors.newFixedThreadPool(threadCount); //service to create threads

        linkList.forEach((key, value) -> execServ.execute(new FileDownloader(key, location, value))); //start threads

        execServ.shutdown();
    }
}

class FileDownloader extends Thread {
    private final String link;
    private final String path;
    private final String saveName;

    public FileDownloader(String link, File dir, String saveName) {
        this.link = link;
        this.path = dir + "/" + saveName;
        this.saveName = saveName;
    }

    @Override
    public void run() {
        try {
            InputStream inputStream = Connect(); //connect and get inputstream
            String result = Download(inputStream, path, saveName); //download and get time
            long size = new File(path).length()/1000; //get size
            System.out.printf("File %s saved. Downloaded %s KB in %s seconds.\n", saveName, size, result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public InputStream Connect() throws IOException {
        URL url = new URL(link);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setReadTimeout(5000);
        connection.setConnectTimeout(10000);
        connection.setRequestMethod("GET");
        connection.setDoInput(true);
        connection.connect();

        return connection.getInputStream();
    }

    public String Download(InputStream inputStream, String path, String saveName) {
        String result = "";
        NumberFormat nf = new DecimalFormat("###.###");

        try (FileOutputStream output = new FileOutputStream(path)) {
            System.out.printf("Downloading file %s\n", saveName);
            //measure time using currentTimeMillis()
            long startTime = System.currentTimeMillis();
            inputStream.transferTo(output); //actual bytes transfer happens here
            long stopTime = System.currentTimeMillis();
            double time = (double)(stopTime - startTime)/1000;
            result = nf.format(time);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}

//makes List of links
class LinkLister {
    public static Map<String, String> makeList(File file) {
        Map<String, String> linkMap = new HashMap<>();
        try {
            List<String> lines = Files.readAllLines(Path.of(file.getPath())); //read file to list of Strings
            //and for each line make a Map of link : name pairs
            for (String line : lines) {
                String[] split = line.split(" ");
                linkMap.putIfAbsent(split[0], split[1]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return linkMap;
    }
}

//Thread for printing the complete download stats
class SummaryThread extends Thread {
    @Override
    public void run() {
        System.out.println("Downloaded d files in d milliseconds. Average download speed: d\n");
    }
}
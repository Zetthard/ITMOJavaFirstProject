package zetthard.httpDownloader;

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
    //public static volatile List<String[]> summary = new ArrayList<>();

    public static void main(String[] args) {
        //temporary variables for testing. to be replaced by CL params
        String temp = "/Users/semennikolaev/Downloads/filedownloader/";
        String temp2 = "/Users/semennikolaev/Downloads/filedownloader/links.txt";

        int threadCount = 5; //Integer.parseInt(args[0]);
        String dir = temp; //args[1]
        File links = new File(temp2); //args[2]

        Map<String, String> linkList = LinkLister.makeList(links);

        ExecutorService execServ = Executors.newFixedThreadPool(threadCount); //service to create threads

        linkList.forEach((link, name) -> execServ.execute(new DownloadThread(link, name, dir))); //start threads

        execServ.shutdown();

        while (Reporter.summary.size() < threadCount) {
            Thread.onSpinWait(); //wait for all threads to add their results
        }
        synchronized (Reporter.summary) {
            String report = Reporter.ShowSummary();
            System.out.println(report); //report download results
        }
    }
}

class DownloadThread extends Thread {
    private final String link;
    private final String saveName;
    private final String path;

    public DownloadThread(String link, String name, String dir) {
        this.link = link;
        this.path = dir + "/" + name;
        this.saveName = name;
    }

    @Override
    public void run() {
        NumberFormat nf = new DecimalFormat("###.###");
        try {
            InputStream inputStream = Downloader.Connect(link); //connect and get inputstream
            double[] statistics = Downloader.Download(inputStream, path, saveName); //download and get time
            Downloader.SaveStats(saveName, statistics);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class Downloader {

    public static InputStream Connect(String link) throws IOException {
        URL url = new URL(link);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setReadTimeout(5000);
        connection.setConnectTimeout(10000);
        connection.setRequestMethod("GET");
        connection.setDoInput(true);
        connection.connect();
        return connection.getInputStream();
    }

    public static double[] Download(InputStream inputStream, String path, String saveName) {

        double[] stat = new double[2];

        try (FileOutputStream output = new FileOutputStream(path)) {
            System.out.printf("Downloading file %s\n", saveName);
            //measure time using currentTimeMillis()
            long startTime = System.currentTimeMillis();
            inputStream.transferTo(output); //actual bytes transfer happens here
            long stopTime = System.currentTimeMillis();
            stat[0] = new File(path).length()/1000.0;
            stat[1] = (double)(stopTime - startTime)/1000;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stat;
    }

    public static void SaveStats(String fileName, double[] stats) {
        NumberFormat nf = new DecimalFormat("###.###");
        String sizeAsStr = nf.format(stats[0]);
        String timeAsStr = nf.format(stats[1]);
        System.out.printf("File %s saved. Downloaded %s KB in %s seconds.\n", fileName, sizeAsStr, timeAsStr);
        synchronized (Reporter.summary) {
            Reporter.summary.add(stats);
        }
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

//generates the final report from summary list
class Reporter {
    public static final List<double[]> summary = new ArrayList<>();

    public static String ShowSummary() {
        NumberFormat nf = new DecimalFormat("###.##");
        NumberFormat nf2 = new DecimalFormat("###.###");

        double totalSize = 0;
        double totalTime = 0;

            for (var stat : summary) {
                totalSize += stat[0];
                totalTime += stat[1];
            }

        double aveSpeed = totalTime == 0 ? 0 : 8.0/1000*totalSize/totalTime;

        return "\nDownloaded " + summary.size() + " files. " + "Total: " + nf.format(totalSize) + " KB in "
                + nf2.format(totalTime) + " seconds.\n" + "Average download speed is " + nf.format(aveSpeed) + " Mb/s";
    }
}

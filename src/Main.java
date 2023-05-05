import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        StringBuilder log = new StringBuilder();
        List<String> dirPaths = new ArrayList();
        dirPaths.add("C:\\Users\\Lisitsa Vera\\java\\Games\\src");
        dirPaths.add("C:\\Users\\Lisitsa Vera\\java\\Games\\res");
        dirPaths.add("C:\\Users\\Lisitsa Vera\\java\\Games\\saveGames");
        dirPaths.add("C:\\Users\\Lisitsa Vera\\java\\Games\\temp");
        dirPaths.add("C:\\Users\\Lisitsa Vera\\java\\Games\\src\\main");
        dirPaths.add("C:\\Users\\Lisitsa Vera\\java\\Games\\src\\test");
        dirPaths.add("C:\\Users\\Lisitsa Vera\\java\\Games\\res\\drawables");
        dirPaths.add("C:\\Users\\Lisitsa Vera\\java\\Games\\res\\vectors");
        dirPaths.add("C:\\Users\\Lisitsa Vera\\java\\Games\\res\\icons");

        for (String dirPath : dirPaths) {
            mkDir(dirPath, log);
        }

        List<String> filePaths = new ArrayList();
        filePaths.add("C:\\Users\\Lisitsa Vera\\java\\Games\\temp\\temp.txt");
        filePaths.add("C:\\Users\\Lisitsa Vera\\java\\Games\\src\\main\\Main.java");
        filePaths.add("C:\\Users\\Lisitsa Vera\\java\\Games\\src\\main\\Utils.java");

        for (String filePath : filePaths) {
            createFile(filePath, log);
        }

        File tempFile = new File("C:\\Users\\Lisitsa Vera\\java\\Games\\temp\\temp.txt");

        if (tempFile.canWrite()) {
            try (FileWriter writer = new FileWriter(tempFile, true)) {
                writer.write(log.toString());
                Date date = new Date();
                writer.append("[" + date.toString() + "] + Информация записана в " + tempFile.getAbsolutePath() + "\n");

            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    public static void mkDir(String dirPath, StringBuilder log) {
        File dir = new File(dirPath);
        Date date = new Date();
        if (dir.mkdir()) {
            log.append("[" + date.toString() + "] + Создана папка " + dir.getAbsolutePath() + "\n");
        } else {
            log.append("[" + date.toString() + "] + Ошибка создания папки " + dir.getAbsolutePath() + " Системе не удается найти указанный путь\n");
        }
    }

    public static void createFile(String filePath, StringBuilder log) {
        File file = new File(filePath);
        Date date = new Date();
        try {
            if (file.createNewFile())
                log.append("[" + date.toString() + "] + Создан файл " + file.getAbsolutePath() + "\n");

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            log.append("[" + date.toString() + "] + Ошибка создания файла " + file.getAbsolutePath() + " Системе не удается найти указанный путь\n");
        }

    }
}
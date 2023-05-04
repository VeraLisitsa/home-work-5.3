import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class Main {
    public static void main(String[] args) {

        StringBuilder log = new StringBuilder();

        File src = new File("C:\\Users\\Lisitsa Vera\\java\\Games\\src");
        File res = new File("C:\\Users\\Lisitsa Vera\\java\\Games\\res");
        File saveGames = new File("C:\\Users\\Lisitsa Vera\\java\\Games\\saveGames");
        File temp = new File("C:\\Users\\Lisitsa Vera\\java\\Games\\temp");

        mkDir(src, log);
        mkDir(res, log);
        mkDir(saveGames, log);
        mkDir(temp, log);

        File main = new File("C:\\Users\\Lisitsa Vera\\java\\Games\\src\\main");
        File test = new File("C:\\Users\\Lisitsa Vera\\java\\Games\\src\\test");
        File drawables = new File("C:\\Users\\Lisitsa Vera\\java\\Games\\res\\drawables");
        File vectors = new File("C:\\Users\\Lisitsa Vera\\java\\Games\\res\\vectors");
        File icons = new File("C:\\Users\\Lisitsa Vera\\java\\Games\\res\\icons");

        mkDir(main, log);
        mkDir(test, log);
        mkDir(drawables, log);
        mkDir(vectors, log);
        mkDir(icons, log);

        File tempFile = new File("C:\\Users\\Lisitsa Vera\\java\\Games\\temp", "temp.txt");
        File mainFile = new File("C:\\Users\\Lisitsa Vera\\java\\Games\\src\\main", "Main.java");
        File utilsFile = new File("C:\\Users\\Lisitsa Vera\\java\\Games\\src\\main", "Utils.java");

        createFile(tempFile, log);
        createFile(mainFile, log);
        createFile(utilsFile, log);

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

    public static void mkDir(File dir, StringBuilder log) {
        Date date = new Date();
        if (dir.mkdir()) {
            log.append("[" + date.toString() + "] + Создана папка " + dir.getAbsolutePath() + "\n");
        } else {
            log.append("[" + date.toString() + "] + Ошибка создания папки " + dir.getAbsolutePath() + " Системе не удается найти указанный путь\n");
        }
    }

    public static void createFile(File file, StringBuilder log) {
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
package parser.ozon;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class FileAction {
    public static void write(List<String> products) throws IOException {
        String filePath = Property.get("products-file-path");
        removeFile(filePath);

        try (FileWriter fileWriter = new FileWriter(filePath, true)) {
            for (String line : products) {
                fileWriter.append(line).append("\n").flush();
            }
        }
    }
    public static void removeFile(String filePath) {
        File file = new File(filePath);
        if(file.exists() && !file.isDirectory())
            file.delete();
    }
}

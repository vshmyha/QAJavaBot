package com.lerkin.qa.api;

import com.lerkin.qa.api.dto.ExerciseDto;
import com.lerkin.qa.api.service.ExerciseService;
import lombok.RequiredArgsConstructor;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//@Component
@RequiredArgsConstructor
public class FileSplitter {

    private final ExerciseService service;

    //if need initial db use this annotation
//    @EventListener(ContextRefreshedEvent.class)
    private void saveEntity() {

        File folder = new File("C:\\Users\\48574\\Documents\\Q&A text\\");
        List<ExerciseDto> entities = collectCollectionEntities(folder);
        service.saveEntity(entities);

    }

    private static List<ExerciseDto> collectCollectionEntities(File folder) {

        List<ExerciseDto> finalCollection = new ArrayList<>();
        File[] files = folder.listFiles();
        for (File file : files) {
            if (file.isFile()) {
                String path = file.getPath();
                List<ExerciseDto> entities = readFileByLine(path);
                finalCollection.addAll(entities);
            }
        }
        return finalCollection;
    }

    private static String getFileName(String path) {

        int firstIndex = path.lastIndexOf('\\');
        int lastIndex = path.length() - 4;
        String name = path.substring(firstIndex + 1, lastIndex);
        return name;

    }

    private static List<ExerciseDto> readFileByLine(String path) {

        List<ExerciseDto> entities = new ArrayList<>();
        String topicId = getFileName(path);

        try(BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line = reader.readLine();
            boolean firsLine = true;

            StringBuilder answer = new StringBuilder("");
            String question = null;
            int counter = 1;
            while (line != null) {
                line = line.replaceAll("\\+", " ");
                if (firsLine) {
                    question = line;
                    firsLine = false;
                } else if (line.contains("оглавлению")) {
                    ExerciseDto entity = entityParser(counter, question, answer.toString(), Integer.parseInt(topicId));
                    counter++;
                    entities.add(entity);
                    answer.setLength(0);
                    firsLine = true;
                } else {
                    answer.append(line);
                }
                line = reader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return entities;
    }

    private static ExerciseDto entityParser(Integer counter, String question, String answer, int topicId) {

        return new ExerciseDto(counter, topicId, question, answer);
    }
}
